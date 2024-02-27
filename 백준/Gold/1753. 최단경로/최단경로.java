import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br;
	public static StringTokenizer st;
	
	public static class Node {
		int vertex, weight;
		Node next;
		
		public Node(int vertex, int weight, Node next) {
			this.vertex = vertex;
			this.weight = weight;
			this.next = next;
		}
	}
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine().trim());
		int vertexCount = Integer.parseInt(st.nextToken()); // 정점 개수
		int edgeCount = Integer.parseInt(st.nextToken()); // 간선 개수
		
		int start = Integer.parseInt(br.readLine().trim()) - 1; // 시작 지점
		final int INF = Integer.MAX_VALUE; // 무한(infinity) 상태
		
		Node[] adjList = new Node[vertexCount]; // 인접 리스트
		int[] minDistance = new int[vertexCount];
		boolean[] visited = new boolean[vertexCount];
		
		// 인접 리스트 생성
		for (int idx = 0; idx < edgeCount; idx++) {
			st = new StringTokenizer(br.readLine().trim());
			int from = Integer.parseInt(st.nextToken()) - 1; // 간선의 시작 정점
			int to = Integer.parseInt(st.nextToken()) - 1; // 간선의 끝 정점
			int weight = Integer.parseInt(st.nextToken()); // 간선의 가중치
			
			// from과 연결된 정점들(to)을 노드로 표현하여 from 인덱스에 저장
			adjList[from] = new Node(to, weight, adjList[from]);
		}
		
		Arrays.fill(minDistance, INF);
		minDistance[start] = 0; // 출발지에서의 비용을 0으로 초기화
		
		int min = 0;
		int stopOver = 0;
		
		// 모든 정점을 처리
		for (int count = 0; count < vertexCount; count++) {
			min = INF;
			stopOver = -1;
			
			// 방문하지 않은 정점들 중 출발지에서 가장 가까운 정점을 선택
			for (int idx = 0; idx < vertexCount; idx++) {
				if (!visited[idx] && min > minDistance[idx]) {
					min = minDistance[idx];
					stopOver = idx;
				}
			}
			
			// 아무 정점도 방문하지 못했다면 멈춘다
			if (stopOver == -1) {
				break;
			}
			visited[stopOver] = true;
			
			// 선택한 경유지를 거쳐서 가는 비용 vs 기존 최소 비용
			// 방문하지 않은 정점들들에 대해 비교해서 갱신한다
			for (Node temp = adjList[stopOver]; temp != null; temp = temp.next) {
				if (minDistance[temp.vertex] > min + temp.weight) {
					minDistance[temp.vertex] = min + temp.weight;
				}
			}
		}

		for (int end = 0; end < vertexCount; end++) {
			System.out.println(minDistance[end] != INF ? minDistance[end] : "INF");
		}
	}
}
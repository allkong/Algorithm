import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 서로소 집합을 이용해 크루스칼 알고리즘으로 구현한다.
 */
public class Main {
	public static BufferedReader br;
	public static StringTokenizer st;
	
	public static int vertexCount; // .정점의 개수
	public static int edgeCount; // 간선의 개수
	public static Edge[] edgeList; // 간선의 정보
	public static int[] parents; // 부모 정보
	public static int[] ranks; // 랭크 정보
	
	public static class Edge implements Comparable<Edge> {
		int from, to, weight;
		
		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
		// 간선의 가중치가 낮은 순으로 정렬한다
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	public static boolean union(int element1, int element2) {
		int e1Parent = find(element1);
		int e2Parent = find(element2);
		
		// 이미 같은 집합이다
		if (e1Parent == e2Parent) {
			return false;
		}
		
		// 두 집합의 랭크가 다른 경우
		// e1Parent의 랭크가 더 높다
		if (ranks[e1Parent] > ranks[e2Parent]) {
			parents[e2Parent] = e1Parent;
			return true;
		}
		
		// e2Parent의 랭크가 더 높다
		parents[e1Parent] = e2Parent;
		
		// 두 집합의 랭크가 같은 경우
		if (ranks[e1Parent] == ranks[e2Parent]) {
			ranks[e2Parent]++;
		}
		return true;
	}
	
	public static int find(int element) {
		// 자신이 부모일 때는 그대로 반환
		if (element == parents[element]) {
			return element;
		}
		
		return parents[element] = find(parents[element]); // 부모를 찾아서 갱신
	}
	
	public static void make() {
		parents = new int[vertexCount + 1];
		ranks = new int[vertexCount + 1];
		
		// 자신을 부모로 설정
		for (int idx = 1; idx < vertexCount + 1; idx++) {
			parents[idx] = idx;
			ranks[idx] = 0;
		}
	}
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine().trim());
		vertexCount = Integer.parseInt(st.nextToken());
		edgeCount = Integer.parseInt(st.nextToken());
		
		edgeList = new Edge[edgeCount];
		
		for (int idx = 0; idx < edgeCount; idx++) {
			st = new StringTokenizer(br.readLine().trim());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			// 간선 리스트 생성
			edgeList[idx] = new Edge(from, to, weight);
		}
		
		// 간선 리스트 오름차순 정렬
		Arrays.sort(edgeList);
		
		make();
		
		// 간선을 하나씩 꺼내서 신장 트리를 생성한다
		int weight = 0;
		int count = 0;
		
		for (Edge edge: edgeList) {
			// 이미 같은 집합이므로 간선을 추가하면 사이클이 발생하게 된다 
			if (!union(edge.from, edge.to)) {
				continue;
			}
			
			// 추가할 간선의 가중치를 더한다
			weight += edge.weight;
			count++;
			
			// 최소 신장 트리가 완성되면 종료한다
			if (count == vertexCount - 1) {
				break;
			}
		}
		
		System.out.println(weight);
	}
}
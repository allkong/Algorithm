import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 1. 정점의 개수, 간선의 개수, 탐색을 시작할 정점의 번호를 입력받는다.
 * 2. 간선이 연결하는 두 정점의 번호를 입력받는다.
 * 3. 그래프 리스트를 만들어 한 정점의 번호 인덱스에 연결된 다른 정점의 번호를 넣는다.
 * 4. 만든 그래프로 DFS 탐색을 한다.
 * 5. 만든 그래프로 BFS 탐색을 한다. 
 */
public class Main {
	public static BufferedReader br;
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static int nodeCount; // 정점의 개수
	public static int linkCount; // 간선의 개수
	public static int start; // 탐색을 시작할 정점의 번호
	public static int[][] graph; // 그래프
	public static boolean[] dfsVisited; // dfs 탐색에서의 방문 처리 배열
	public static boolean[] bfsVisited; // bfs 탐색에서의 방문 처리 배열
	public static Deque<Integer> queue; // bfs 탐색에서 다음 탐색 위치를 저장할 큐
	
	public static void dfs(int start) {
		// 현재 노드를 방문 처리
		dfsVisited[start] = true;
		sb.append(start).append(" ");
		
		// 현재 노드와 연결된 다른 노드를 재귀적으로 방문
		for (int idx = 1; idx <= nodeCount; idx++) {
			if (graph[start][idx] == 1 && !dfsVisited[idx]) {
				dfs(idx);
			}
		}
	}
	
	public static void bfs(int start) {
		queue = new ArrayDeque<>();
		queue.offer(start);
		
		// 현재 노드를 방문 처리
		bfsVisited[start] = true;
		
		while (!queue.isEmpty()) {
			// 큐에서 방문할 원소 꺼내기
			int vertex = queue.poll();
			sb.append(vertex).append(" ");
			
			// 아직 방문하지 않은 인접한 원소들을 큐에 삽입
			for (int idx = 1; idx <= nodeCount; idx++) {
				if (graph[vertex][idx] == 1 && !bfsVisited[idx]) {
					queue.offer(idx);
					bfsVisited[idx] = true;
				}
			} 
		}
	}

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine().trim());
		nodeCount = Integer.parseInt(st.nextToken());
		linkCount = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());
		
		// 간선이 연결하는 두 정점의 번호를 입력받아 그래프 생성
		graph = new int[nodeCount + 1][nodeCount + 1];
		for (int idx = 0; idx < linkCount; idx++) {
			st = new StringTokenizer(br.readLine().trim());
			int one = Integer.parseInt(st.nextToken());
			int other = Integer.parseInt(st.nextToken());
			
			graph[one][other] = 1;
			graph[other][one] = 1;
		}
		
		dfsVisited = new boolean[nodeCount + 1];
		dfs(start);
		sb.append("\n");
		
		bfsVisited = new boolean[nodeCount + 1];
		bfs(start);
		
		System.out.println(sb);
	}
}
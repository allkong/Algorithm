import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 1. 사람의 수, 친구 관계의 수를 입력받는다.
 * 2. 친구 관계를 입력받는다.
 * 3. 간선이 연결하는 두 사람의 번호를 입력받는다.
 * 3. 친구 관계 그래프를 만들어 한 사람의 번호 인덱스에 연결된 다른 사람의 번호를 넣는다.
 */
public class Main {
	public static BufferedReader br;
	public static StringTokenizer st;
	
	public static final int CONDITION = 5;
	public static int headCount; // 사람의 수
	public static int relationCount; // 친구 관계의 수
	public static int isRelate; // 문제 조건의 관계가 존재하는지 체크
	public static ArrayList<Integer>[] friends; // 친구 관계 그래프
	public static boolean[] visited;
	
	public static void searchRelation(int start, int depth) {
		// 관계 조건이 만족하면 종료한다
		if (depth == CONDITION) {
			isRelate = 1;
			return;
		}
		
		visited[start] = true;
		
		// 친구 관계이고 방문하지 않은 곳이면 탐색한다
		for (int idx : friends[start]) {
			
			if (!visited[idx]) {
				searchRelation(idx, depth + 1);
			}
		}
		
		visited[start] = false;
	}
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine().trim());
		headCount = Integer.parseInt(st.nextToken());
		relationCount = Integer.parseInt(st.nextToken());
		friends = new ArrayList[headCount];
		visited = new boolean[headCount];
		isRelate = 0;
		
		for (int idx = 0; idx < headCount; idx++) {
			friends[idx] = new ArrayList<>();
		}
		
		// 친구 관계 그래프를 생성한다
		for (int count = 0; count < relationCount; count++) {
			st = new StringTokenizer(br.readLine().trim());
			int one = Integer.parseInt(st.nextToken());
			int other = Integer.parseInt(st.nextToken());
			
			friends[one].add(other);
			friends[other].add(one);			
		}
		
		for (int idx = 0; idx < headCount; idx++) {
			// 이미 관계 조건을 만족했다면 종료한다
			if (isRelate == 1) {
				break;
			}
			searchRelation(idx, 1);
		}
		
		System.out.println(isRelate);		
	}
}
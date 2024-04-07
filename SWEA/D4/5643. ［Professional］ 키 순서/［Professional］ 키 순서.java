import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br;
	static StringBuilder sb;
	static StringTokenizer st;
	
	static int studentCount; // 학생 수
    static int compareCount; // 비교 횟수
    static int[][] adj; // 자신보다 키 큰 학생 정보
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		int testCase = Integer.parseInt(br.readLine().trim());
		
		for (int tc = 1; tc <= testCase; tc++) {
			studentCount = Integer.parseInt(br.readLine().trim());
			compareCount = Integer.parseInt(br.readLine().trim());
			
			adj = new int[studentCount + 1][studentCount + 1];
			
			for (int idx = 0; idx < compareCount; idx++) {
				st = new StringTokenizer(br.readLine().trim());
				
				int shorter = Integer.parseInt(st.nextToken());
				int taller = Integer.parseInt(st.nextToken());
				
				// 키가 더 작은 학생 -> 키가 더 큰 학생 간의 관계 표시
				adj[shorter][taller] = 1;
			}
			
			// 자신과 연결된 학생과 연결된 학생..을 모두 찾아 연결시킨다
			int answer = 0;
			for (int mid = 1; mid <= studentCount; mid++) { // 경유
				for (int start = 1; start <= studentCount; start++) { // 출발
					if (start == mid || adj[start][mid] == 0) {
						continue;
					}
					
					for (int end = 1; end <= studentCount; end++) { // 도착
						if (adj[start][end] == 1) {
							continue;
						}
						
						adj[start][end] = adj[start][mid] & adj[mid][end];
					}
				}
			}
			
			// 자신보다 키가 더 큰 학생과 키가 더 작은 학생의 수를 센다
			for (int start = 1; start <= studentCount; start++) {
				for (int end = 1; end <= studentCount; end++) {
					adj[start][0] += adj[start][end]; // start 학생보다 end 학생이 키가 더 크면 1, 모르면 0
					adj[0][end] += adj[start][end]; // start 학생보다 end 학생이 키가 더 작으면 1, 모르면 0
				}
			}
			
			// 자신이 키가 몇 번째인지 알 수 있는 학생 수를 구한다
			for (int idx = 1; idx <= studentCount; idx++) {
				if (adj[idx][0] + adj[0][idx] == studentCount - 1) {
					answer++;
				}
			}
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
}
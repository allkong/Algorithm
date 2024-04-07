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
    static int count; // 자신보다 키가 큰 학생과 키가 작은 학생의 수
    static int[][] tallerAdj; // 자신보다 키 큰 학생 정보
    static int[][] shorterAdj; // 자신보다 키가 작은 학생 정보
    
    private static void dfs(int current, boolean[] visited, int[][] adj) {
    	visited[current] = true;
    	
    	for (int idx = 1; idx <= studentCount; idx++) {
    		// 자신보다 키가 더 작은 학생을 아직 탐색하지 않았다면 탐색하러 간다
    		if (adj[idx][current] == 1 && !visited[idx]) {
    			count++;
    			dfs(idx, visited, adj);
    		}
    	}
    }
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		int testCase = Integer.parseInt(br.readLine().trim());
		
		for (int tc = 1; tc <= testCase; tc++) {
			studentCount = Integer.parseInt(br.readLine().trim());
			compareCount = Integer.parseInt(br.readLine().trim());
			
			tallerAdj = new int[studentCount + 1][studentCount + 1];
			shorterAdj = new int[studentCount + 1][studentCount + 1];
			
			for (int idx = 0; idx < compareCount; idx++) {
				st = new StringTokenizer(br.readLine().trim());
				
				int shorter = Integer.parseInt(st.nextToken());
				int taller = Integer.parseInt(st.nextToken());
				
				// 키가 더 작은 학생 -> 키가 더 큰 학생 간의 관계 표시
				tallerAdj[shorter][taller] = 1;
				// 키가 더 큰 학생 -> 키가 더 작은 학생 간의 관계 표시
				shorterAdj[taller][shorter] = 1;
			}
			
			int answer = 0;
			for (int idx = 1; idx <= studentCount; idx++) {
				count = 0;
				dfs(idx, new boolean[studentCount + 1], tallerAdj);
				dfs(idx, new boolean[studentCount + 1], shorterAdj);
			
				if (count == studentCount - 1) {
					answer++;
				}
			}
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
}
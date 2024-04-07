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
    
    private static void dfs(int current) {    	
    	for (int idx = 1; idx <= studentCount; idx++) {
    		// 자신보다 키가 더 큰 학생을 찾는다
    		if (adj[current][idx] == 1) {
    			// 탐색이 안된 정점이면 탐색한다
    			if (adj[idx][0] == -1) {
    				dfs(idx);
    			}
    			// 현재 학생보다 큰 학생이 있다면 그 관계들을 자신과의 관계에 반영
    			if (adj[idx][0] > 0) {
    				for (int other = 1; other <= studentCount; other++) {
    					if (adj[idx][other] == 1) { // idx보다 큰 학생 other를 나 current와의 관계로 표현
    						adj[current][other] = 1;
    					}
    				}
    			}
    		}
    	}
    	
    	int count = 0;
    	for (int idx = 1; idx <= studentCount; idx++) {
    		count += adj[current][idx]; // 자신보다 큰 학생 수 카운팅 (0은 덧셈에 영향 없으니 ㄱㅊ)
    	}
    	
    	adj[current][0] = count;
    }
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		int testCase = Integer.parseInt(br.readLine().trim());
		
		for (int tc = 1; tc <= testCase; tc++) {
			studentCount = Integer.parseInt(br.readLine().trim());
			compareCount = Integer.parseInt(br.readLine().trim());
			
			adj = new int[studentCount + 1][studentCount + 1];
			for (int idx = 1; idx <= studentCount; idx++) {
				adj[idx][0] = -1; // 탐색되지 않았으면 -1
			}
			
			for (int idx = 0; idx < compareCount; idx++) {
				st = new StringTokenizer(br.readLine().trim());
				
				int shorter = Integer.parseInt(st.nextToken());
				int taller = Integer.parseInt(st.nextToken());
				
				// 키가 더 작은 학생 -> 키가 더 큰 학생 간의 관계 표시
				adj[shorter][taller] = 1;
			}
			
			
			for (int idx = 1; idx <= studentCount; idx++) {
				if (adj[idx][0] == -1) {
					dfs(idx); // 탐색이 안된 정점만 탐색하러 간다
				}
			}
			
			// 자신보다 키가 더 작은 학생 수를 구한다
			for (int row = 1; row <= studentCount; row++) {
				for (int col = 1; col <= studentCount; col++) {
					adj[0][col] += adj[row][col];
				}
			}
			
			int answer = 0;
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
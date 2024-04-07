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
    static int[][] students; // 학생 키 정보 배열 (유향 그래프)
    
    private static void searchTaller(int current, boolean[] visited) {
    	visited[current] = true;
    	
    	for (int idx = 1; idx <= studentCount; idx++) {
    		// 자신보다 키가 더 큰 학생을 아직 탐색하지 않았다면 탐색하러 간다
    		if (students[current][idx] == 1 && !visited[idx]) {
    			count++;
    			searchTaller(idx, visited);
    		}
    	}
    }
    
    private static void searchShorter(int current, boolean[] visited) {
    	visited[current] = true;
    	
    	for (int idx = 1; idx <= studentCount; idx++) {
    		// 자신보다 키가 더 작은 학생을 아직 탐색하지 않았다면 탐색하러 간다
    		if (students[idx][current] == 1 && !visited[idx]) {
    			count++;
    			searchShorter(idx, visited);
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
			
			students = new int[studentCount + 1][studentCount + 1];
			
			for (int idx = 0; idx < compareCount; idx++) {
				st = new StringTokenizer(br.readLine().trim());
				
				int shorter = Integer.parseInt(st.nextToken());
				int taller = Integer.parseInt(st.nextToken());
				
				// 키가 더 작은 학생 -> 키가 더 큰 학생 간의 관계 표시
				students[shorter][taller] = 1;
			}
			
			int answer = 0; // 자신이 키가 몇 번째인지 알 수 있는 학생 수
			for (int idx = 1; idx <= studentCount; idx++) {
				count = 0; // 자신보다 키가 작거나 크다는 걸 알 수 있는 학생 수
				searchTaller(idx, new boolean[studentCount + 1]); // 자신보다 키가 큰 학생들을 탐색
				searchShorter(idx, new boolean[studentCount + 1]); // 자신보다 키가 작은 학생들을 탐색
				
				if (count == studentCount - 1) {
					answer++;
				}
			}
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
}
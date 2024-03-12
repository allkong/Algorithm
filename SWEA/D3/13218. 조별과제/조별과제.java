import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1. 테스트 케이스를 입력받는다.
 * 2. 학생 수를 입력받는다.
 * 3. 학생 수에서 3으로 나눈 값을 출력한다.
 */
public class Solution {
	public static BufferedReader br;
	public static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		int testCase = Integer.parseInt(br.readLine().trim());
		
		for (int tc = 1; tc <= testCase; tc++) {
			int numOfStudents = Integer.parseInt(br.readLine().trim());
			// 학생 수에서 3으로 나눈 값을 출력한다
			sb.append("#").append(tc).append(" ").append(numOfStudents / 3).append("\n");
		}
		System.out.println(sb);
	}
}
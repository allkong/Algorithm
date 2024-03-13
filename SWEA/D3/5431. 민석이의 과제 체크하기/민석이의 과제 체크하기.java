import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 테스트 케이스를 입력받는다.
 * 2. 수강생의 수, 과제를 제출한 사람의 수를 입력받는다.
 * 3. 과제를 제출한 사람들의 번호를 입력받는다.
 *    3-1. boolean 배열에서 해당 번호를 true로 체크한다.
 * 4. 과제를 제출하지 않은 사람의 번호(배열에서 값이 false인 인덱스)를 출력한다.
 */
public class Solution {
	public static BufferedReader br;
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		final int testCase = Integer.parseInt(br.readLine().trim());
		
		for (int tc = 1; tc <= testCase; tc++) {			
			st = new StringTokenizer(br.readLine().trim());
			
			int headCount = Integer.parseInt(st.nextToken());
			int submitCount = Integer.parseInt(st.nextToken());
			boolean[] submitStudents = new boolean[headCount + 1];
			
			st = new StringTokenizer(br.readLine().trim());
			for (int count = 0; count < submitCount; count++) {
				int studentIdx = Integer.parseInt(st.nextToken()); // 제출한 사람 번호
				submitStudents[studentIdx] = true; // 과제 제출한 살마 번호 체크
			}
			
			sb.append("#").append(tc).append(" ");
			for (int idx = 1; idx <= headCount; idx++) {
				// 과제 제출하지 않은 사람의 번호 출력
				if (!submitStudents[idx]) {
					sb.append(idx).append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
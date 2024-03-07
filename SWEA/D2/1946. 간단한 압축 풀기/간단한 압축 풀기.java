import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 알파벳과 그 알파벳의 연속된 개수를 입력받는다.
 *    1-1. 각각 다른 배열에 저장한다.
 * 2. 알파벳 배열의 행 길이(row)만큼 반복문을 돌린다.
 *    2-1. 알파벳 하나를 출력할 때마다 열 번호(col)를 +1한다.
 *    2-2. 열 번호(col)가 10이 되면 다시 0으로 되돌린다.
 */
public class Solution {
	public static BufferedReader br;
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		int testCase = Integer.parseInt(br.readLine().trim());
		
		for (int tc = 1; tc <= testCase; tc++) {
			int size = Integer.parseInt(br.readLine().trim());
			String[] alphabetArr = new String[size];
			int[] alphabetCount = new int[size];
			
			for (int idx = 0; idx < size; idx++) {
				st = new StringTokenizer(br.readLine().trim());
				alphabetArr[idx] = st.nextToken();
				alphabetCount[idx] = Integer.parseInt(st.nextToken());
			}
			
			sb.append("#").append(tc).append("\n");

			int col = 0;
			for (int row = 0; row < size; row++) {
				// 해당 알파벳의 연속된 개수만큼 담는다
				for (int idx = 0; idx < alphabetCount[row]; idx++) {
					sb.append(alphabetArr[row]);
					col++;
					
					// 열 번호(col)가 10이 되면 다시 0으로 되돌린다
					if (col == 10) {
						sb.append("\n");
						col = 0;
					}
				}
			}
            sb.append("\n");
		}
		System.out.println(sb);
	}
}
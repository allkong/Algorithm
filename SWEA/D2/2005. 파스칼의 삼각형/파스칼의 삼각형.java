import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 1. 파스칼의 삼각형을 저장할 배열을 선언한다.
 * 2. 먼저 배열의 첫 번째 행에는 1을 한 개 넣고, 두 번째 행에는 1을 두 개 넣는다.
 * 3. 세 번째 행부터는 현재 자신의 행 번호만큼 숫자를 넣는다.
 *    3-1. 1을 넣는다.
 *    3-2. (현재 자신의 행 번호 - 2)만큼 반복문을 돌린다.
 *         3-2-1. 자신의 한 칸 왼쪽의 숫자와 한 칸 위의 숫자를 더한 값을 넣는다.
 *    3-3. 1을 넣는다.
 */
public class Solution {
	public static BufferedReader br;
	public static StringBuilder sb;
	
	public static int rowCount; // 행 수
	public static List<Integer>[] triangle; // 파스칼의 삼각형
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		int testCase = Integer.parseInt(br.readLine().trim());
		
		for (int tc = 1; tc <= testCase; tc++) {
			rowCount = Integer.parseInt(br.readLine().trim());
			triangle = new List[rowCount];
			
			for (int idx = 0; idx < rowCount; idx++) {
				triangle[idx] = new ArrayList<Integer>();
			}
			
			for (int row = 0; row < rowCount; row++) {
				// 첫 번째 행에는 1을 한 개 넣는다
				if (row == 0) {
					triangle[row].add(1);
				}
				// 두 번째 행에는 1을 두 개 넣는다
				else if (row == 1) {
					triangle[row].add(1);
					triangle[row].add(1);
				} else {
					triangle[row].add(1);
					// (현재 자신의 행 번호 - 2)만큼 반복문을 돌린다
					for (int idx = 1; idx < row; idx++) {
						// 자신의 한 칸 왼쪽의 숫자와 한 칸 위의 숫자를 더한 값을 넣는다
						triangle[row].add(triangle[row - 1].get(idx - 1) + triangle[row - 1].get(idx));
					}
					triangle[row].add(1);
				}
			}
			
			// 출력
			sb.append("#").append(tc).append("\n");
			for (int row = 0; row < rowCount; row++) {
				for (int col = 0; col < triangle[row].size(); col++) {
					sb.append(triangle[row].get(col)).append(" ");
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 두 숫자열 중에 길이가 더 짧은 숫자열을 구한다.
 * 2. 길이가 더 짧은 숫자열이 한 칸씩 이동하며 서로 마주보는 위치를 변경한다.
 *    2-1. (긴 길이 - 짧은 길이 + 1)만큼 비교하면 된다.
 * 3. 서로 마주보는 숫자들을 모두 곱한 뒤에 더한다.
 * 4. 3번에서 구한 최댓값을 출력한다.
 */
public class Solution {
	public static BufferedReader br;
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static int[] shortArr; // 길이가 더 짧은 숫자열
	public static int[] longArr; // 길이가 더 긴 숫자열
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		int testCase = Integer.parseInt(br.readLine().trim());
		
		for (int tc = 1; tc <= testCase; tc++) {
			st = new StringTokenizer(br.readLine().trim());
			int lengthA = Integer.parseInt(st.nextToken());
			int lengthB = Integer.parseInt(st.nextToken());
			
			int[] arrA = new int[lengthA];
			int[] arrB = new int[lengthB];
			
			st = new StringTokenizer(br.readLine().trim());
			for (int idx = 0; idx < lengthA; idx++) {
				arrA[idx] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine().trim());
			for (int idx = 0; idx < lengthB; idx++) {
				arrB[idx] = Integer.parseInt(st.nextToken());
			}
			
            // 길이가 더 짧은 숫자열과 길이가 더 긴 숫자열 지정
			if (lengthA < lengthB) {
				shortArr = arrA;
				longArr = arrB;
			} else {
				shortArr = arrB;
				longArr = arrA;
			}
			
			int maxTotal = 0; // 계산값 중 최댓값
			
			// 이동 횟수: 길이가 더 긴 숫자열 길이 - 길이가 더 짧은 숫자열 길이 + 1
			// 짧은 숫자열이 이동하면 긴 숫자열의 인덱스가 idx + move가 된다
			for (int move = 0; move < longArr.length - shortArr.length + 1; move++) {
				int total = 0; // 계산값
				// idx: 길어가 더 짧은 숫자열의 인덱스
				for (int idx = 0; idx < shortArr.length; idx++) {
					// 서로 마주보는 숫자들을 모두 곱한 뒤에 더한다
					total += longArr[idx + move] * shortArr[idx];
				}
				// 계산 결과의 최댓값을 구한다
				maxTotal = Math.max(maxTotal, total);
			}
			
			sb.append("#").append(tc).append(" ").append(maxTotal).append("\n");
		}
		System.out.println(sb);
	}
}
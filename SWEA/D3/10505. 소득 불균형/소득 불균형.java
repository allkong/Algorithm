import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 테스트 케이스를 입력받는다.
 * 2. 사람 수를 입력받는다.
 * 3. 사람들의 소득을 입력받아 배열에 저장한다.
 *    3-1. 입력받을 때 total에 더한다.
 * 4. total에 사람 수를 나누어 평균을 구한다.
 * 5. 사람들의 소득 배열을 순회하며 소득이 평균 이하인 사람의 인원을 센다.
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
			int headCount = Integer.parseInt(br.readLine().trim());
			int[] people = new int[headCount]; // 사람들의 소득 배열
			int total = 0; // 모든 사람들의 소득 총합
			
			st = new StringTokenizer(br.readLine().trim());
			for (int idx = 0; idx < headCount; idx++) {
				people[idx] = Integer.parseInt(st.nextToken());
				total += people[idx];
			}
			
			// total에 사람 수를 나누어 평균을 구한다
			int average = total / headCount;
			int targetCount = 0; // 평균 이하의 소득을 가진 사람들의 수
			
			// 사람들의 소득 배열을 순회하며 소득이 평균 이하인 사람의 인원을 센다
			for (int idx = 0; idx < headCount; idx++) {
				if (people[idx] <= average) {
					targetCount++;
				}
			}
			
			sb.append("#").append(tc).append(" ").append(targetCount).append("\n");
		}
		System.out.println(sb);
	}
}
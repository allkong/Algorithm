import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 수의 개수, 합을 구해야 하는 횟수를 입력받는다.
 * 2. 숫자들을 입력받아 숫자 배열에 저장한다.
 *    2-1. 숫자 배열을 선언한다.
 * 3. 입력받을 때 바로 전 칸의 값을 더하여 저장한다.
 *    3-1. 누적합을 저장하도록 만든다.
 * 4. 합을 구해야 하는 횟수만큼 반복한다.
 * 5. 배열에서 구간의 끝에 해당하는 값에서 구간의 시작에 해당하는 값을 뺀다. 
 */
public class Main {
	public static BufferedReader br;
	public static StringBuilder sb;
	public static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine().trim());
		int numCount = Integer.parseInt(st.nextToken()); // 수의 개수
		int totalCount = Integer.parseInt(st.nextToken()); // 합을 구해야 하는 횟수
		
		int[] nums = new int[numCount + 1]; // 숫자 배열
		
		// 숫자들을 입력받아 숫자 배열에 저장한다.
		st = new StringTokenizer(br.readLine().trim());
		
		// 0번째 칸은 0으로 냅둔다
		// 첫 번째 칸부터는 이전 칸의 값과 입력받은 값을 더하여 누적합을 구한다
		for (int idx = 1; idx <= numCount; idx++) {
			nums[idx] = nums[idx - 1] + Integer.parseInt(st.nextToken());
		}
		
		// 합을 구해야 하는 횟수만큼 반복한다
		for (int totalNum = 0; totalNum < totalCount; totalNum++) {
			st = new StringTokenizer(br.readLine().trim());
			int start = Integer.parseInt(st.nextToken()); // 구간의 시작 지점 
			int end = Integer.parseInt(st.nextToken()); // 구간의 끝 지점
			
			// 끝 지점의 누적합에서 시작 지점의 한 칸 앞 누적합을 빼서 구간의 합을 구한다
			sb.append(nums[end] - nums[start - 1]).append("\n");
		}
		System.out.println(sb);
	}
}
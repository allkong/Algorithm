import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 1. 과일의 개수와 스네이크버드의 초기 길이를 입력받는다.
 * 2. 과일들의 높이를 입력받아 배열에 저장한다.
 * 3. 과일 높이 배열을 오름차순으로 정렬한다.
 * 4. 과일 높이 배열을 앞에서부터 살펴보며 스네이크버드의 길이와 비교한다.
 *    4-1. 과일의 높이가 스네이크버드의 길이보다 작거나 같다면 스네이크버드의 길이를 1 늘린다.
 *    4-2. 그렇지 않다면 종료한다.
 */
public class Main {
	public static BufferedReader br;
	public static StringTokenizer st;
	
	public static int fruitCount; // 과일 개수
	public static int snakebirdLength; // 스네이크버드의 길이
	public static int[] fruitHeight; // 과일 높이 배열

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		// 과일의 개수와 스네이크버드의 초기 길이를 입력받는다
		st = new StringTokenizer(br.readLine().trim());
		fruitCount = Integer.parseInt(st.nextToken());
		snakebirdLength = Integer.parseInt(st.nextToken());
		// 과일들의 높이를 입력받아 배열에 저장한다
		fruitHeight = new int[fruitCount];
		st = new StringTokenizer(br.readLine().trim());
		for (int idx = 0; idx < fruitCount; idx++) {
			fruitHeight[idx] = Integer.parseInt(st.nextToken());
		}
		
		// 과일 높이 배열을 오름차순으로 정렬한다
		Arrays.sort(fruitHeight);
		
		// 과일 높이 배열을 앞에서부터 살펴보며 스네이크버드의 길이와 비교한다
		for (int idx = 0; idx < fruitCount; idx++) {
			// 과일의 높이가 스네이크버드의 길이보다 작거나 같다면 스네이크버드의 길이를 1 늘린다
			if (fruitHeight[idx] <= snakebirdLength) {
				snakebirdLength++;
			} else {
				break;
			}
		}
		System.out.println(snakebirdLength);
	}
}
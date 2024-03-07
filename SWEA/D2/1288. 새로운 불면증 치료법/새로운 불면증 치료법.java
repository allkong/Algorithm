import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1. 숫자를 입력받는다.
 * 2. 0부터 9까지의 인덱스를 갖는 방문 배열을 선언한다.
 * 3. 입력받은 숫자를 *1, *2, *3, ... 하며 반복한다.
 *    3-1. 입력받은 숫자 *n한 숫자의 각 자릿수를 인덱스로 하는 방문 배열에서 방문 체크한다.
 *    3-3. 방문 배열에서 모든 인덱스가 방문 처리되었으면 종료한다.
 *         3-3-1. 종료한 시점에서의 입력받은 숫자 *n을 출력한다.
 */
public class Solution {
	public static BufferedReader br;
	public static StringBuilder sb;

	public static final int COUNT = 10; // 0~9 -> 10개
	public static int startNum; // 시작 숫자
	public static boolean[] visited; // 방문 배열
	
	/** 모든 숫자를 방문했는지 확인하는 메소드 */
	public static boolean isVisitedAll() {
		for (int idx = 0; idx < COUNT; idx++) {
			// 방문하지 않은 곳이 한 곳이라도 있다면 실패
			if (!visited[idx]) {
				return false;
			}
		}
		// 모든 곳을 방문했다면 성공
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		int testCase = Integer.parseInt(br.readLine().trim());
		
		for (int tc = 1; tc <= testCase; tc++) {
			startNum = Integer.parseInt(br.readLine().trim());
			visited = new boolean[COUNT];
			
			int multiple = 1;
			while (true) {
				String current = String.valueOf(startNum * multiple);
				
				// 입력받은 숫자 *n한 숫자의 각 자릿수를 인덱스로 하는 방문 배열에서 방문 체크한다
				for (int idx = 0; idx < current.length(); idx++) {
					visited[Character.getNumericValue(current.charAt(idx))] = true;
				}
				
				// 모든 자릿수를 방문했다면 양 세기를 멈춘다
				if (isVisitedAll()) {
					sb.append("#").append(tc).append(" ").append(current).append("\n");
					break;
				}
	
				multiple++;
			}
		}
		System.out.println(sb);
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 0: 현재 속도 유지, 1: 가속, 2: 감속
 * 1. 초기 속도는 0이다.
 * 2. command 0을 입력받았다면, 현재 속도인 숫자만큼 거리를 이동한다.
 * 3. command 1을 입력받았다면, 현재 속도에 가속 속도를 더해서 속도만큼 거리를 이동한다.
 * 4. command 2를 입력받았다면, 현재 속도에 감속 속도를 빼서 속도만큼 거리를 이동한다.
 */
public class Solution {
	public static BufferedReader br;
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static int currentSpeed; // 현재 속도
	public static int totalDistance; // 총 이동 거리
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		int testCase = Integer.parseInt(br.readLine().trim());
		
		for (int tc = 1; tc <= testCase; tc++) {
			int moveCount = Integer.parseInt(br.readLine().trim());
			currentSpeed = 0;
			totalDistance = 0;
			
			for (int move = 0; move < moveCount; move++) {
				st = new StringTokenizer(br.readLine().trim());
				
				int command = Integer.parseInt(st.nextToken());
				
				// command 0을 입력받았다면, 현재 속도인 숫자만큼 거리를 이동한다
				if (command == 0) {
					totalDistance += currentSpeed;
				}
				// command 1을 입력받았다면, 현재 속도에 가속 속도를 더해서 거리를 이동한다
				else if (command == 1) {
					int acceleration = Integer.parseInt(st.nextToken()); // 가속 숫자
					currentSpeed += acceleration;
					totalDistance += currentSpeed;
				}
				// command 2를 입력받았다면, 현재 속도에 감속 속도를 빼서 거리를 이동한다
				else if (command == 2) {
					int deceleration = Integer.parseInt(st.nextToken()); // 감속 숫자
					// 현재 속도보다 감속할 속도가 더 클 경우, 속도는 0이 된다
					if (deceleration > currentSpeed) {
						deceleration = 0;
					}
					currentSpeed -= deceleration;
					totalDistance += currentSpeed;
				}
			}
			
			sb.append("#").append(tc).append(" ").append(totalDistance).append("\n");
		}
		System.out.println(sb);
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br;
	static StringBuilder sb;
	static StringTokenizer st;
	
	static int pointCount; // 점의 개수
	static int furthestDistance; // 가장 멀리 있는 점의 거리
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		int testCase = Integer.parseInt(br.readLine().trim());
		
		for (int tc = 1; tc <= testCase; tc++) {
			pointCount = Integer.parseInt(br.readLine().trim());
			furthestDistance = 0;
			boolean isEven = false; // 짝수가 존재하는지 판별
			boolean isOdd = false; // 홀수가 존재하는지 판별
			
			for (int idx = 0; idx < pointCount; idx++) {
				st = new StringTokenizer(br.readLine().trim());
				
				int x = Integer.parseInt(st.nextToken()); // x 좌표
				int y = Integer.parseInt(st.nextToken()); // y 좌표
				
				int distance = Math.abs(x) + Math.abs(y); // (x, y)의 원점과의 거리를 배열에 저장
				
				if (distance % 2 == 0) {
					isEven = true;
				} else {
					isOdd = true;
				}
				
				if (furthestDistance < distance) {
					furthestDistance = distance;
				}
			}
			
			int moveCount = 1; // 몇 번째 움직임인지
			
			// 짝수와 홀수가 섞여있으면 원점 도달이 불가능하다
			if (isEven && isOdd) {
				moveCount = -1;
			}
			// 이미 모든 점이 원점이면 이동하지 않아도 된다
			else if (furthestDistance == 0) {
				moveCount = 0;
			}
			// 움직임을 센다
			else {
				int total = 1; // 한 번의 움직임 당 증가하는 이동 횟수
				while (true) {
					if (total >= furthestDistance && (total - furthestDistance) % 2 == 0) {
						break;
					}
					moveCount++;
					total += moveCount;
				}
			}
			sb.append("#").append(tc).append(" ").append(moveCount).append("\n");
		}
		System.out.println(sb);
	}
}
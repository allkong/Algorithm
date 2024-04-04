import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static BufferedReader br;
	static StringBuilder sb;
	static StringTokenizer st;
	
	static int mapSize; // 지도 크기 
	static int rampSize; // 경사로의 길이
	static int runwayCount; // 가능한 활주로 수
	static boolean[][] built; // 경사로 설치 체크
	
	/* 경사로를 설치한 땅을 체크하는 메소드 */
	static void checkLand(int row, int col, int direction) {
		int buildCount = 0; // 경사로 설치를 표시한 땅의 칸 수
		
		while(col >= 0 && col < mapSize && buildCount < rampSize) {
			built[row][col] = true;
			buildCount++;
			col += direction; // 다음 칸으로 이동
		}
	}
	
	/* 경사로를 설치할 수 있는 땅의 칸 수를 세는 메소드 */
	static int countLand(int row, int col, int direction, int[][] map) {
		int height = map[row][col]; // 현재 지형의 높이
		int count = 0; // 같은 높이 지형의 땅 칸 수
		
		// 높이가 같은 지형이고 경사로가 설치되지 않은 땅이 몇 칸인지 센다
		while (col >= 0 && col < mapSize && map[row][col] == height && !built[row][col]) {
			count++;
			col += direction; // 다음 칸으로 이동
		}
		
		return count;
	}
	
	static void buildRamp(int[][] map) {
		for (int row = 0; row < mapSize; row++) {
			boolean isBuild = true; // 활주로 건설 가능 여부
			
			for (int col = 0; col < mapSize - 1; col++) {
				// 지형의 높이가 달라지면 확인한다
				if (map[row][col] != map[row][col + 1]) {
					// 지형의 높이가 1칸 높아졌다
					if (map[row][col + 1] - map[row][col] == 1) {
						// 현재 지형에 경사로를 설치할 수 있으면 설치한다
						if (countLand(row, col, -1, map) >= rampSize) {
							// 경사로 설치한 구역을 체크한다
							checkLand(row, col, -1);
						}
						// 경사로를 설치할 수 있는 공간이 없다
						else {
							isBuild = false;
							break;
						}
					}
					// 지형의 높이가 1칸 낮아졌다
					else if (map[row][col] - map[row][col + 1] == 1) {
						// 다음 지형에 경사로를 설치할 수 있으면 설치한다
						if (countLand(row, col + 1, 1, map) >= rampSize) {
							// 경사로 설치한 구역을 체크한다
							checkLand(row, col + 1, 1);
						}
						// 경사로를 설치할 수 있는 공간이 없다
						else {
							isBuild = false;
							break;
						}
					}
					// 지형의 높이 차이가 2 이상이면 경사로로 해결할 수 없다
					else {
						isBuild = false;
					}
				}
			}
			
			// 활주로를 건설할 수 있으면 횟수를 센다
			if (isBuild) {
				runwayCount++;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		int testCase = Integer.parseInt(br.readLine().trim());
		
		for (int tc = 1; tc <= testCase; tc++) {
			st = new StringTokenizer(br.readLine().trim());
			
			mapSize = Integer.parseInt(st.nextToken());
			rampSize = Integer.parseInt(st.nextToken());
			int[][] map = new int[mapSize][mapSize];
			int[][] reverseMap = new int[mapSize][mapSize];
			
			for (int row = 0; row < mapSize; row++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int col = 0; col < mapSize; col++) {
					map[row][col] = Integer.parseInt(st.nextToken());
					reverseMap[col][row] = map[row][col];
				}
			}
			
			runwayCount = 0;
			
			built = new boolean[mapSize][mapSize];
			buildRamp(map); // 행 탐색
			
			built = new boolean[mapSize][mapSize];
			buildRamp(reverseMap); // 열 탐색
			
			sb.append("#").append(tc).append(" ").append(runwayCount).append("\n");
		}
		System.out.println(sb);
	}
}
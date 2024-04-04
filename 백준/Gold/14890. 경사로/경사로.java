import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader br;
	static StringBuilder sb;
	static StringTokenizer st;
	
	static int mapSize; // 지도 크기 
	static int rampSize; // 경사로의 길이
	static int runwayCount; // 가능한 활주로 수
	
	static void buildRamp(int[][] map) {
		for (int row = 0; row < mapSize; row++) {
			boolean isBuild = true; // 활주로 건설 가능 여부
			int count = 1;
			
			for (int col = 1; col < mapSize; col++) {
				// 높이가 같다
				if (map[row][col - 1] == map[row][col]) {
					count += 1; // 같은 높이인 땅의 칸 수를 센다
				}
				// 높이가 1 높아졌다 (이전 위치에 경사로 설치)
				// 이전 지형에 경사로를 설치할 공간이 있다
				else if (count >= rampSize && map[row][col] - map[row][col - 1] == 1) {
					count = 1;
				}
				// 높이가 1 낮아졌다 (현재 위치에 경사로 설치)
				// 현재 위치에 경사로를 설치할 공간이 있다
				else if (count >= 0 && map[row][col - 1] - map[row][col] == 1) {
					// 경사로 길이를 빼서 count가 0이 되면 경사로 설치할 공간이 있는 것으로 체크한다
					count = 1 - rampSize;
				}
				// 경사로를 설치할 수 없다
				else {
					isBuild = false;
					break;
				}
			}
			// count가 음수이면 경사로를 설치할 수 없는 경우가 있는 것이므로
			// count가 양수여야 활주로를 건설할 수 있다
			if (isBuild && count >= 0) {
				runwayCount++;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
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
		buildRamp(map);
		buildRamp(reverseMap);
		
		System.out.println(runwayCount);
	}
}
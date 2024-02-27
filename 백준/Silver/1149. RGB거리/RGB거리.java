import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 색 배열을 입력받아 저장한다.
 * 2. 비용 배열을 만든다. (houseCount * colorCount)
 * 3. 이전 집에서 다른 색들 중 최솟값과 현재 집의 색을 더해서 현재 집 칸에 저장한다.
 *    3-1. 예를 들어, 두 번째 집 행에서 R(빨강)열에는 해당 행, 열에 해당하는 색 비용과
 *         첫 번째 집 행의 G(초록), B(파랑)열 중 더 작은 값을 더한 값을 저장한다.
 * 4. 마지막 행의 3개 열 중 가장 작은 값을 출력한다.
 */
public class Main {	
	public static BufferedReader br;
	public static StringTokenizer st;
	
	public static final int COLOR_COUNT = 3;
	public static final int RED = 0;
	public static final int GREEN = 1;
	public static final int BLUE = 2;
	
	public static int houseCount; // 집의 수
	public static int minCost; // 모든 집을 칠하는 비용의 최솟값
	
	public static int[][] paintCost; // 각각의 집을 칠하는 비용 (RGB 순)
	public static int[][] totalCost; // 최소 비용을 구하기 위한 비용 합계 배열
	
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		houseCount = Integer.parseInt(br.readLine().trim());
		
		paintCost = new int[houseCount + 1][houseCount];
		totalCost = new int[houseCount + 1][COLOR_COUNT];
		
		for (int row = 1; row <= houseCount; row++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int col = 0; col < COLOR_COUNT; col++) {
				paintCost[row][col] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int idx = 1; idx <= houseCount; idx++) {
			totalCost[idx][RED] = paintCost[idx][RED] + Math.min(totalCost[idx - 1][GREEN], totalCost[idx - 1][BLUE]);
			totalCost[idx][GREEN] = paintCost[idx][GREEN] + Math.min(totalCost[idx - 1][RED], totalCost[idx - 1][BLUE]);
			totalCost[idx][BLUE] = paintCost[idx][BLUE] + Math.min(totalCost[idx - 1][RED], totalCost[idx - 1][GREEN]);
		}
		
		// 마지막 집까지의 비용 합계 중 첫 번째 경우(마지막 집이 빨강인 경우)로 초기화
		minCost = totalCost[houseCount][RED];
		minCost = Math.min(minCost, totalCost[houseCount][GREEN]);
		minCost = Math.min(minCost, totalCost[houseCount][BLUE]);
		
		System.out.println(minCost);
	}
}
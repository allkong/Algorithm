import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/** 
 * 1. 처음 파이프의 위치는 (0,0)과 (0,1)이고, 방향은 가로이다.
 * 2. visited 배열에 파이프의 현재 방향에 따라 현재 칸의 숫자를 정한다.
 *    2-1. 파이프의 방향이 가로이면, 이전 <→, ↘> 칸의 경우들을 더한다. 
 *    2-2. 파이프의 방향이 세로이면, 이전 <↓, ↘> 칸의 경우들을 더한다.
 *    2-3. 파이프의 방향이 대각선이면, 이전의 <→, ↘, ↓> 칸의 경우들을 더한다. 
 * 3. 집 배열의 가장 마지막 위치의 가로에서 오는 파이프, 세로에서 오는 파이프, 대각선에서 오는 파이프의 경우를 모두 더한다.
 */
public class Main {
	public static BufferedReader br;
	public static StringTokenizer st;
	
	public static final int HORIZONTAL = 0; // 가로
	public static final int VERTICAL = 1; // 세로
	public static final int DIAGONAL = 2; // 대각선
	
	public static int size; // 집의 크기
	public static int pipeDirection; // 파이프의 방향
	public static int[][] house; // 집 배열
	public static int[][][] visited; // 방문한 방법의 수를 저장하는 배열
	
	public static void movePipe() {
		visited[0][1][HORIZONTAL] = 1;
		
		for (int row = 0; row < size; row++) {
			for (int col = 2; col < size; col++) {
				// 벽이면 이동할 수 없다
				if (house[row][col] == 1) {
					continue;
				}
				
				// 배열의 범위를 벗어나지 않아야 한다
				
				// 가로의 파이프 이동 범위에 벽이 없어야 한다
				// 이전 <→, ↘> 칸의 경우들을 더한다
				if (house[row][col-1] != 1) {
					visited[row][col][HORIZONTAL] = visited[row][col-1][HORIZONTAL] + visited[row][col-1][DIAGONAL];
				}
				
				// 세로의 파이프 이동 범위에 벽이 없어야 한다
				// 이전 <↓, ↘> 칸의 경우들을 더한다
				if (row-1 >= 0 && house[row-1][col] != 1) {
					visited[row][col][VERTICAL] = visited[row-1][col][VERTICAL] + visited[row-1][col][DIAGONAL];
				}
				
				// 대각선 파이프의 이동 범위에 벽이 없어야 한다
				// 이전의 <→, ↘, ↓> 칸의 경우들을 더한다
				if (row-1 >= 0 && house[row][col] != 1 && house[row-1][col] != 1 && house[row][col-1] != 1) {
					visited[row][col][DIAGONAL] = visited[row-1][col-1][HORIZONTAL] + visited[row-1][col-1][VERTICAL] + visited[row-1][col-1][DIAGONAL];
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		size = Integer.parseInt(br.readLine().trim());
		house = new int[size][size];
		visited = new int[size][size][3];
		
		for (int row = 0; row < size; row++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int col = 0; col < size; col++) {
				house[row][col] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 파이프를 옮기는 메소드 호출
		movePipe();
		
		// 파이프를 끝까지 옮기는 방법의 수 출력
		// 마지막 위치의 가로에서 오는 파이프, 세로에서 오는 파이프, 대각선에서 오는 파이프의 경우 모두 더하기
		System.out.println(visited[size-1][size-1][HORIZONTAL] + visited[size-1][size-1][VERTICAL] + visited[size-1][size-1][DIAGONAL]);
	}
}
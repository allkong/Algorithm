import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br;
	static StringBuilder sb;
	static StringTokenizer st;
	
	static int[] deltaRow = {-1, 1, 0, 0};
	static int[] deltaCol = {0, 0, -1, 1};
	
	static int beadsCount; // 구슬을 쏘는 횟수
	static int rowSize; // 행 크기
	static int colSize; // 열 크기
	static int minRemainCount; 
	
	static int[][] board; // 벽돌 정보 배열
	
	static class Brick {
		int row, col, count; // 벽돌의 좌표, 벽돌에 적힌 숫자

		public Brick(int row, int col, int count) {
			this.row = row;
			this.col = col;
			this.count = count;
		}
	}
	
	/* 배열을 복사하는 메소드 */
	static void copy(int[][] one, int[][] other) {
		for (int row = 0; row < rowSize; row++) {
			for (int col = 0; col < colSize; col++) {
				other[row][col] = one[row][col];
			}
		}
	}
	
	/* 보드에 남아 있는 벽돌의 개수를 세는 메소드 */
	static int getRemainBrick() {
		int remainCount = 0;
		for (int row = 0; row < rowSize; row++) {
			for (int col = 0; col < colSize; col++) {
				if (board[row][col] > 0) {
					remainCount++;
				}
			}
		}
		return remainCount;
	}
	
	/* 중간에서 깨진 벽돌에 의해 빈 자리가 생겨 중력에 의해 벽돌을 내리는 메소드 */
	static void down() {
		Stack<Integer> stack = new Stack<>();
		
		for (int col = 0; col < colSize; col++) {
			// 현재 열에 대해 벽돌을 모두 회수한다
			for (int row = 0; row < rowSize; row++) {
				// 벽돌이 존재하면 벽돌의 숫자를 스택에 넣는다
				if (board[row][col] != 0) {
					stack.push(board[row][col]);
					board[row][col] = 0;
				}
			}
			
			// 회수한(스택에 넣은) 벽돌들을 다시 바닥부터 쌓는다
			int row = rowSize - 1;
			while (!stack.isEmpty()) {
				board[row][col] = stack.pop();
				row--;
			}
		}
	}
	
	/* 연쇄적으로 주변 벽돌을 깨트리는 메소드 */
	static void bomb(int row, int col) {
		Queue<Brick> queue = new ArrayDeque<>();
		queue.offer(new Brick(row, col, board[row][col]));
		board[row][col] = 0;
		
		while (!queue.isEmpty()) {
			Brick current = queue.poll();
			
			// 현재 벽돌의 상하좌우 벽돌을 깨트린다
			for (int direction = 0; direction < deltaRow.length; direction++) {
				int nextRow = current.row;
				int nextCol = current.col;
				
				// 한 방향 당 벽돌에 적힌 횟수만큼 깨트린다
				for (int count = 1; count < current.count; count++) {
					nextRow += deltaRow[direction];
					nextCol += deltaCol[direction];
					
					// 범위를 벗어나면 탐색하지 않는다
					// 빈 곳이면 탐색하지 않는다
					if (nextRow < 0 || nextCol < 0 || nextRow >= rowSize || nextCol >= colSize || board[nextRow][nextCol] == 0) {
						continue;
					}
					
					// 벽돌에 적혀 있는 숫자가 1보다 크면 해당 벽돌도 주변 벽돌을 깨트려야 한다
					if (board[nextRow][nextCol] > 1) {
						queue.offer(new Brick(nextRow, nextCol, board[nextRow][nextCol]));
					}
					
					// 벽돌을 깨트린다
					board[nextRow][nextCol] = 0;
				}
			}
		}
	}
	
	/* 구슬을 벽돌에 쏘는 메소드 */
	static boolean shootBead(int beadIdx) {
		// 현재 보드에 남아 있는 벽돌의 개수를 센다
		int remainCount = getRemainBrick();
		
		// 기저 조건 1: 모든 벽돌을 깨트렸다면 종료한다
		if (remainCount == 0) {
			minRemainCount = 0;
			return true;
		}
		
		// 기저 조건 2: 구슬을 모두 쐈다면 종료한다
		if (beadIdx == beadsCount) {
			minRemainCount = Math.min(minRemainCount, remainCount);
			return false;
		}
		
		// 모든 열에 구슬 쏘기를 시도한다
		for (int col = 0; col < colSize; col++) { 
			// 한 열에 대해 벽돌이 몇 번째 행에 있는지 찾는다
			int row = 0;
			while (row < rowSize && board[row][col] == 0) {
				row++;
			}
			
			// 만약 해당 열에 벽돌이 아예 없다면, 깨트릴 게 없으므로 건너뛴다
			if (row == rowSize) {
				continue;
			}
			
			// 새로운 보드 배열을 만들어 현재 보드 배열을 저장한다
			int[][] copyBoard = new int[rowSize][colSize];
			// 현재 시도에서 벽돌을 깨트린 것을 다른 시도를 위해 다시 되돌리기 위해서
			// 현재 시점의 배열을 copyBoard에 저장해두고 나중에 copyBoard로 되돌린다
			copy(board, copyBoard);
			
			// 벽돌이 있다면, 해당 벽돌을 깨트려야 한다
			// 먼저 벽돌에 적힌 숫자를 가져온다
			int brickNum = board[row][col]; 
			
			// 벽돌에 적힌 숫자가 1이면 현재 벽돌만 깨트리면 된다
			if (brickNum == 1) {
				board[row][col] = 0;
			}
			// 벽돌에 적힌 숫자가 1보다 크다면 주변 벽돌도 깨트려야 한다
			else {
				// 연쇄적으로 주변 벽돌을 깨트린다
				bomb(row, col);
				// 중간에 깨진 벽돌들의 위에 있는 벽돌들을 아래로 내린다 (중력 작용 처리)
				down();
			}
			
			// 다음 구슬을 깨트리러 간다
			if (shootBead(beadIdx + 1)) {
				return true;
			}
			
			// 다시 벽돌을 깨트리기 전으로 만든다
			copy(copyBoard, board);
		}
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		int testCase = Integer.parseInt(br.readLine().trim());
		
		for (int tc = 1; tc <= testCase; tc++) {
			st = new StringTokenizer(br.readLine().trim());
			
			beadsCount = Integer.parseInt(st.nextToken());
			colSize = Integer.parseInt(st.nextToken());
			rowSize = Integer.parseInt(st.nextToken());
			board = new int[rowSize][colSize];
			
			for (int row = 0; row < rowSize; row++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int col = 0; col < colSize; col++) {
					board[row][col] = Integer.parseInt(st.nextToken());
				}
			}
			
			minRemainCount = Integer.MAX_VALUE;
			
			shootBead(0);

			sb.append("#").append(tc).append(" ").append(minRemainCount).append("\n");
		}
		System.out.println(sb);
	}
}
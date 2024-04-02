import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static BufferedReader br;
    
    static final int SIZE = 9; // 스도쿠 배열의 크기
    static final int ROW = 0; // 행 영역
    static final int COL = 1; // 열 영역
    static final int GRID = 2; // 3*3 보드 영역
    
    static boolean isFillAll; // 스도쿠의 모든 칸이 채워졌는지 
    static int[][] sudoku; // 스도쿠 배열
    static int[][] check; // 각 영역 당 1~9 숫자 체크 배열
    static List<Cell> blanks; // 빈 칸들
    
    static class Cell {
    	// 스도쿠 한 칸의 행 번호, 열 번호, 3*3 보드 번호
    	int row, col, grid;
    	
    	Cell (int row, int col, int grid) {
    		this.row = row;
    		this.col = col;
    		this.grid = grid;
    	}
    }
    
    static void fillBlank(int blankIdx) {
    	// 모든 빈 칸을 다 처리했다
    	if (blankIdx == blanks.size()) {
    		isFillAll = true;
    		return;
    	}
    	
    	// 빈 칸 하나를 가져온다
    	Cell current = blanks.get(blankIdx);
    	
    	for (int num = 1; num <= SIZE; num++) {
    		// 이미 현재 칸을 포함하는 세 영역 중에 채워진 숫자라면 건너뛴다
    		if ((check[ROW][current.row] & 1 << num) != 0 || (check[COL][current.col] & 1 << num) != 0 || (check[GRID][current.grid] & 1 << num) != 0) {
    			continue;
    		}
    		
    		// 세 영역 안에 존재하지 않는 숫자면 현재 칸을 채운다
    		sudoku[current.row][current.col] = num;
    		// 스도쿠 칸을 채웠으니 숫자 체크 배열에도 체크한다
    		check[ROW][current.row] |= 1 << num;
			check[COL][current.col] |= 1 << num;
			check[GRID][current.grid] |= 1 << num;
    		
    		// 다음 칸을 채우러 간다
    		fillBlank(blankIdx + 1);
    		
    		// 스도쿠의 모든 칸을 채웠다면 종료한다
    		if (isFillAll) {
    			return;
    		}
    		
    		// 다시 빈 칸으로 만든다
    		check[ROW][current.row] &= ~(1 << num);
    		check[COL][current.col] &= ~(1 << num);
    		check[GRID][current.grid] &= ~(1 << num);
    	}
    }
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        
        sudoku = new int[SIZE][SIZE];
        check = new int[3][SIZE];
        blanks = new ArrayList<>();
        
        for (int rowIdx = 0; rowIdx < SIZE; rowIdx++) {
        	String line = br.readLine().trim();
        	for (int colIdx = 0; colIdx < SIZE; colIdx++) {
        		// 몇 번째 3*3 보드에 속하는지 구한다
        		int gridIdx = rowIdx / 3 * 3 + colIdx / 3;
        		
        		int num = Character.getNumericValue(line.charAt(colIdx));
        		
        		// 빈 칸이면 리스트에 저장한다
        		if (num == 0) {
        			blanks.add(new Cell(rowIdx, colIdx, gridIdx));
        		}
        		// 이미 채워져 있는 칸이면 현재 위치에 해당하는 행, 열, 3*3 보드에 표시한다
        		else {
        			// 스도쿠 배열에 숫자를 채운다
        			sudoku[rowIdx][colIdx] = num;
            		// 숫자 체크 배열의 각 행, 각 열, 각 3*3 보드에 숫자가 존재한다는 것을 체크한다
        			check[ROW][rowIdx] |= 1 << num;
        			check[COL][colIdx] |= 1 << num;
        			check[GRID][gridIdx] |= 1 << num;
        		}
        	}
        }
        
        // 스도쿠 빈 칸 채우기
        fillBlank(0);
        
        // 스도쿠 배열 출력
        for (int rowIdx = 0; rowIdx < SIZE; rowIdx++) {
        	for (int colIdx = 0; colIdx < SIZE; colIdx++) {
        		System.out.print(sudoku[rowIdx][colIdx]);
        	}
        	System.out.println();
        }
    }
}
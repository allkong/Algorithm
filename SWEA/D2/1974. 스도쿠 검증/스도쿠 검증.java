import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 스도쿠 배열을 입력받는다.
 * 2. 스도쿠 배열을 검사한다.
 *    2-1. visited 배열을 만들어서 방문한 숫자는 true로 체크한 후, 방문한 숫자를 또 방문하면 검증 실패이다.
 *    2-2. 각 행, 각 열, 3*3칸들을 검사한다.
 */
public class Solution {
    public static BufferedReader br;
    public static StringBuilder sb;
    public static StringTokenizer st;
    
    public static final int SIZE = 9; // 9*9 스도쿠
    public static int[][] board; // 스도쿠 배열
    
    /**
     * 스도쿠 배열을 검증하는 메소드
     * 검증 성공하면 @return 1;
     * 검증 실패하면 @return 0;
     */
    public static int checkSudoku() {  	
    	// 스도쿠 행, 스도쿠 열 검사
    	for (int row = 0; row < SIZE; row++) {
    		// 스도쿠 검증을 위한 방문 배열
    		boolean[] rowVisited = new boolean[SIZE + 1];
    		boolean[] colVisited = new boolean[SIZE + 1];
    		for (int col = 0; col < SIZE; col++) {
    			// 이미 방문한 숫자면 검증 실패
    			if (rowVisited[board[row][col]] || colVisited[board[col][row]]) {
    				return 0;
    			}
    			
    			rowVisited[board[row][col]] = true; // 스도쿠 행
    			colVisited[board[col][row]] = true; // 스도쿠 열
    		}
    	}
    	
    	// 스도쿠 3*3칸 검사
    	for (int rowStart = 0; rowStart < SIZE; rowStart += 3) {
    		for (int colStart = 0; colStart < SIZE; colStart += 3) {
    			boolean[] gridVisited = new boolean[SIZE + 1];
    			for (int row = 0; row < 3; row++) {
    				for (int col = 0; col < 3; col++) {
    					// 이미 방문한 숫자면 검증 실패
    	    			if (gridVisited[board[row][col]]) {
    	    				return 0;
    	    			}
    	    			
    	    			gridVisited[board[row][col]] = true; // 스도쿠 3*3칸
    				}
    			}
    		}
    	}
    	
    	// 위 검사들에서 실패하지 않았다면 검증 성공
    	return 1;
    }
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        int testCase = Integer.parseInt(br.readLine().trim());
        
        for (int tc = 1; tc <= testCase; tc++) {
        	board = new int[SIZE][SIZE];
        	
        	// 스도쿠 배열 입력
        	for (int row = 0; row < SIZE; row++) {
        		st = new StringTokenizer(br.readLine().trim());
        		for (int col = 0; col < SIZE; col++) {
        			board[row][col] = Integer.parseInt(st.nextToken());
        		}
        	}
        	
        	// 스도쿠 배열 검증 결과
        	int result = checkSudoku();
        	sb.append("#").append(tc).append(" ").append(result).append("\n");
        }
        
        System.out.println(sb);
    }
}
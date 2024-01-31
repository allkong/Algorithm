import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 달팽이 숫자를 구현한다.
 * (골뱅이 모양으로 돌리기)
 * 
 * 1. 테스트 케이스를 입력받는다.
 * 2. 테스트 케이스만큼 반복한다.
 * 3. 달팽이의 크기(배열의 사이즈)를 입력받는다.
 * 4. 달팽이 숫자를 담을 배열을 선언한다.
 * 5. 델타 배열에 우, 하, 좌, 상 순서로 방향을 담는다.
 * 6. 한 칸씩 이동하다가 배열의 범위를 벗어나거나 이미 숫자가 담긴 칸이라면 방향을 바꾼다.
 *    6-1. 한 칸씩 이동할 때마다 각 칸에 숫자를 저장한다.  
 */
public class Solution {
    public static BufferedReader br;
    public static StringBuilder sb;

    public static int size;
    public static int[][] snail;
    
    public static final int[] deltaRow = {0, 1, 0, -1};
    public static final int[] deltaCol = {1, 0, -1, 0};
    
    public static int num, direction, currentRowIdx, currentColIdx, nextRowIdx, nextColIdx;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        // 테스트 케이스를 입력받는다
        int testCase = Integer.parseInt(br.readLine().trim());
        // 테스트 케이스만큼 반복한다
        for (int tc = 1; tc <= testCase; tc++) {        	
        	size = Integer.parseInt(br.readLine().trim()); // 달팽이의 크기
        	snail = new int[size][size]; // 달팽이 배열
        	num = 1; // 달팽이 배열에 저장할 숫자
        	
        	// 좌표 초기화
        	currentRowIdx = 0;
        	currentColIdx = -1; // (0, 0)의 왼쪽에서 시작한다
        	nextRowIdx = 0;
        	nextColIdx = 0;
        	
        	// 달팽이 숫자를 만든다
        	while (num <= size * size) {
        		nextRowIdx = currentRowIdx + deltaRow[direction];
    			nextColIdx = currentColIdx + deltaCol[direction];
    			
    			// 다음 위치가 배열의 범위를 벗어나면 방향을 바꾼다
    			// 다음 위치에 이미 숫자가 저장되어 있다면 방향을 바꾼다
    			if (nextRowIdx < 0 || nextColIdx < 0 || nextRowIdx >= size || nextColIdx >= size || snail[nextRowIdx][nextColIdx] > 0) {
    				direction = (direction + 1) % 4;
    				continue;
    			}
    			
    			// 달팽이 배열에 숫자를 저장한다
    			snail[nextRowIdx][nextColIdx] = num;
    			// 현재 좌표를 다음 좌표로 초기화한다
    			currentRowIdx = nextRowIdx;
    			currentColIdx = nextColIdx;
    			num++;
        	}
        	
        	sb.append("#").append(tc).append("\n");
        	for (int row = 0; row < size; row++) {
        		for (int col = 0; col < size; col++) {
        			sb.append(snail[row][col]).append(" ");
        		}
        		sb.append("\n");
        	}
        }
        System.out.println(sb);
    }
}
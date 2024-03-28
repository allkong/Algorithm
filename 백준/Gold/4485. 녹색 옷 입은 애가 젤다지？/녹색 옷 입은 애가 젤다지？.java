import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 동굴의 크기를 입력받는다.
 *    1-1. 0이면 입력을 종료한다.
 * 2. 동굴의 각 칸에 있는 도둑루피를 입력받는다.
 *    2-1. 동굴의 크기만큼 2차원 배열을 선언한다.
 * 3. 2차원 배열(dp 배열)을 선언하여 INF 값으로 초기화한다.
 * 4. bfs로 배열의 모든 칸을 탐색한다.
 *    4-1. 한 칸 한 칸 이동하며 도둑루피를 획득한다.
 *    4-2. 도둑루피를 덜 획득할 수 있는 경로를 찾는다.
 * 5. 현재 칸에서 사방향을 탐색한다.
 *    5-1. 현재 획득한 도둑루피에 다음 칸 도둑루피를 더한 값이 다음 칸의 이전 경로에서 도둑루피를 획득량보다 더 작다면 갱신한다.
 * 6. dp 배열의 가장 마지막 칸을 출력한다.
 */
public class Main {
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;
    
    static final int INF = Integer.MAX_VALUE;
    static final int[] deltaRow = {1, 0, 0, -1}; // 하우좌상
    static final int[] deltaCol = {0, 1, -1, 0};
    
    static int size; // 동굴의 크기
    static int[][] cave; // 동굴 배열
    static int[][] thiefRupee; // 도둑루피 배열
    
    static class Position {
        int row, col;
        
        Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    
    static void move() {
        Queue<Position> queue = new ArrayDeque<>();
        // (0, 0)에서 시작한다
        queue.offer(new Position(0, 0));
        // 시작 위치는 무조건 해당 칸의 도둑루피를 획득해야 한다
        thiefRupee[0][0] = cave[0][0];
        
        while (!queue.isEmpty()) {
            Position current = queue.poll();
            
            for (int direction = 0; direction < deltaRow.length; direction++) {
                int nextRow = current.row + deltaRow[direction];
                int nextCol = current.col + deltaCol[direction];
                
                // 범위를 벗어나면 탐색하지 않는다
                if (nextRow < 0 || nextCol < 0 || nextRow >= size || nextCol >= size) {
                    continue;
                }
                
                // 현재 획득한 도둑루피에 다음 칸 도둑루피를 더한 값이 다음 칸의 이전 경로에서 도둑루피를 획득량보다 더 작다면 갱신한다
                if (thiefRupee[current.row][current.col] + cave[nextRow][nextCol] < thiefRupee[nextRow][nextCol]) {
                	thiefRupee[nextRow][nextCol] = thiefRupee[current.row][current.col] + cave[nextRow][nextCol];
                	queue.offer(new Position(nextRow, nextCol));
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int tc = 1; // 테스트 케이스 번호
        
        while (true) {
            size = Integer.parseInt(br.readLine().trim());
            
            // 동굴의 크기가 0이면 전체 입력을 종료한다
            if (size == 0) {
                break;
            }
            
            cave = new int[size][size];
            for (int row = 0; row < size; row++) {
                st = new StringTokenizer(br.readLine().trim());
                for (int col = 0; col < size; col++) {
                    cave[row][col] = Integer.parseInt(st.nextToken());
                }
            }
            
            thiefRupee = new int[size][size];
            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    thiefRupee[row][col] = INF;
                }
            }
            
            move();
            // 마지막 칸을 출력한다
            sb.append("Problem ").append(tc).append(": ").append(thiefRupee[size-1][size-1]).append("\n");
            tc++;
        }
        
        System.out.println(sb);
    }
}
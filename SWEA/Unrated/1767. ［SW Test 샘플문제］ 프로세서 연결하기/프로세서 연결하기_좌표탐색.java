import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
 
/**
 * 1. 현재 코어에 대해 전선을 연결하는 것과 전선을 연결하지 않는 것을 시도한다.
 *    1-1. 전선을 연결하기: 4방향으로 시도한다.
 *         1-1-1. 해당 방향으로 연결이 불가능하다면 다른 방향으로 시도한다.
 *         1-1-2. 해당 방향으로 연결이 가능하다면 전선을 연결하고 상태를 세팅한 후, 다음 코어를 처리한다.
 *    1-2. 전선을 연결하지 않기: 다음 코어를 처리한다.
 * 2. 마지막 코어까지 탐색했다면, 최대 코어 수일 때의 전선 길이 최소 합을 구한다.
 */
public class Solution {
    public static BufferedReader br;
    public static StringBuilder sb;
    public static StringTokenizer st;
     
    public static final int EMPTY = 0;
    public static final int CORE = 1;
    public static final int WIRE = 2;
    public static final int[] deltaRow = {-1, 1, 0, 0};
    public static final int[] deltaCol = {0, 0, -1, 1};
 
    public static int size; // 배열의 크기
    public static int maxConnect; // 최대 코어 연결 수
    public static int minTotalWire; // 전선 길이의 합 최솟값
    public static int[][] processor; // 멕시노스 프로세서 배열
    public static ArrayList<Position> coreList; // 가장자리가 아닌 코어들의 정보를 저장
     
    public static class Position {
        int row, col;
 
        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
     
    /** 코어에서 전선을 연결하려는 방향의 상태를 세팅하는 메소드 **/
    public static int setStatus(int currentRow, int currentCol, int direction, int status) {
        int nextRow = currentRow;
        int nextCol = currentCol;
        int changeCount = 0; // 처리한 빈 칸의 개수
         
        while (true) {
            nextRow += deltaRow[direction];
            nextCol += deltaCol[direction];
             
            // 범위를 벗어난다면 탐색하지 않는다
            if (nextRow < 0 || nextCol < 0 || nextRow >= size || nextCol >= size) {
                break;
            }
             
            processor[nextRow][nextCol] = status;
            changeCount++;
        }
         
        return changeCount;
    }
     
    /** 코어를 연결하려는 방향에 다른 코어 전선이 없는지 확인하는 메소드 */
    static boolean checkConnection(int currentRow, int currentCol, int direction) {
        int nextRow = currentRow;
        int nextCol = currentCol;
         
        while (true) {
            nextRow += deltaRow[direction];
            nextCol += deltaCol[direction];
             
            // 연결하려는 길이 모두 빈 칸이면 연결한다
            if (nextRow < 0 || nextCol < 0 || nextRow >= size || nextCol >= size) {
                return true;
            }
             
            // 연결하려는 길에 전선이나 다른 코어가 있으면 연결할 수 없다
            if (processor[nextRow][nextCol] > 0) {
                return false;
            }
        }
    }
 
    /** 코어를 연결하는 메소드 */
    static void connectCore(int coreIdx, int connect, int totalWire) {
        // 남은 코어를 전부 더해도 최대 코어 연결 개수보다 적다면 더 탐색하지 않는다
        if (connect + coreList.size() - coreIdx < maxConnect) {
            return;
        }
         
        // 모든 코어의 연결을 세팅했다면 전선 길이 합을 갱신한다
        if (coreIdx == coreList.size()) {
            if (maxConnect < connect) {
                maxConnect = connect;
                minTotalWire = totalWire;
            } else if (maxConnect == connect && minTotalWire > totalWire) {
                minTotalWire = totalWire;
            }
            return;
        }
         
        Position current = coreList.get(coreIdx); // 현재 탐색할 코어
         
        // 4방향으로 시도한다
        for (int direction = 0; direction < deltaRow.length; direction++) {
            // 다른 전선이나 코어와 겹치지 않는다면 해당 방향으로 연결
            if (checkConnection(current.row, current.col, direction)) {
                int wireLength = setStatus(current.row, current.col, direction, WIRE); // 전선 연결
                connectCore(coreIdx + 1, connect + 1, totalWire + wireLength); // 다음 코어 탐색
                setStatus(current.row, current.col, direction, EMPTY); // 전선 연결을 해제
            }
        }
         
        // 전선을 연결하지 않는다
        connectCore(coreIdx + 1, connect, totalWire);
    }
     
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
 
        int testCase = Integer.parseInt(br.readLine().trim());
 
        for (int tc = 1; tc <= testCase; tc++) {
            size = Integer.parseInt(br.readLine().trim());
            processor = new int[size][size];
            coreList = new ArrayList<>();
            maxConnect = 0;
            minTotalWire = Integer.MAX_VALUE;
 
            for (int row = 0; row < size; row++) {
                st = new StringTokenizer(br.readLine().trim());
                for (int col = 0; col < size; col++) {
                    processor[row][col] = Integer.parseInt(st.nextToken());
                     
                    // 가장자리가 아닌 코어만 코어 리스트에 담는다
                    if (row > 0 && row < size - 1 && col > 0 && col < size - 1 && processor[row][col] == CORE) {
                        coreList.add(new Position(row, col));
                    }
                }
            }
             
            connectCore(0, 0, 0);
 
            sb.append("#").append(tc).append(" ").append(minTotalWire).append("\n");
        }
        System.out.println(sb);
    }
}

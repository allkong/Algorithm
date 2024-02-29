import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 1. 코어의 방향 세팅
 *    1-1. 0: 방향 설정x, 1: 상, 2: 우, 3: 하, 4: 좌 5: 가장자리
 * 2. 코어를 연결한다.
 *    2-1. 연결하지 않은 코어들만 탐색한다.
 *    2-2. 다른 전선과 겹치지 않는지 검사한다.
 *          2-2-1. 현재 코어의 방향에 따라 해당 방향에 다른 코어나 다른 코어의 전선이 없는지 확인한다.
 *    2-3. 겹치지 않는다면 다음 코어를 연결하기 위해 탐색한다.
 * 3. 코어의 방향을 다 설정했다면 전선 길이의 합을 구한다.
 */
public class Solution {
    public static BufferedReader br;
    public static StringBuilder sb;
    public static StringTokenizer st;

    public static final int CORE = 1;
    public static final int UP = 1;
    public static final int RIGHT = 2;
    public static final int DOWN = 3;
    public static final int LEFT = 4;
    public static final int EDGE = 5; // 가장자리

    public static int size; // 배열의 크기
    public static int maxConnect; // 코어 연결 수
    public static int minTotalWire; // 전선 길이의 합 최솟값
    public static int[][] processor; // 멕시노스 프로세서 배열
    public static List<Position> coreList; // 코어들의 정보를 저장

    public static class Position {
        int row, col, direction;

        public Position(int row, int col, int direction) {
            this.row = row;
            this.col = col;
            this.direction = direction;
        }
    }

    /** 전선 길이의 합을 구하는 메소드 */
    public static int countWire() {
        int totalWire = 0;

        for (int idx = 0; idx < coreList.size(); idx++) {
            Position current = coreList.get(idx);

            if (current.direction == UP) {
                totalWire += current.row;
            } else if (current.direction == RIGHT) {
                totalWire += size - current.col - 1;
            } else if (current.direction == DOWN) {
                totalWire += size - current.row - 1;
            } else if (current.direction == LEFT) {
                totalWire += current.col;
            }
        }
        // 전선의 길이 합 반환
        return totalWire;
    }

    /** 코어를 연결하려는 방향에 다른 코어 전선이 없는지 확인하는 메소드 */
    public static boolean checkConnection(Position current, int direction) {
        for (int idx = 0; idx < coreList.size(); idx++) {
            Position prev = coreList.get(idx);

            // 현재 코어의 방향이 위쪽이면 현재 코어의 위쪽에 다른 코어들이나 다른 코어들의 전선이 없는지 확인
            if (direction == UP) {
                if (prev.row < current.row && prev.col < current.col && prev.direction == RIGHT
                        || prev.row < current.row && prev.col > current.col && prev.direction == LEFT
                        || prev.row < current.row && prev.col == current.col) {
                    return false;
                }
            }

            // 현재 코어의 방향이 오른쪽이면 현재 코어의 오른쪽에 다른 코어들이나 다른 코어들의 전선이 없는지 확인
            else if (direction == RIGHT) {
                if (prev.row < current.row && prev.col > current.col && prev.direction == DOWN
                        || prev.row > current.row && prev.col > current.col && prev.direction == UP
                        || prev.row == current.row && prev.col > current.col) {
                    return false;
                }
            }

            // 현재 코어의 방향이 아래쪽이면 현재 코어의 아래쪽에 다른 코어들이나 다른 코어들의 전선이 없는지 확인
            else if (direction == DOWN) {
                if (prev.row > current.row && prev.col < current.col && prev.direction == RIGHT
                        || prev.row > current.row && prev.col > current.col && prev.direction == LEFT
                        || prev.row > current.row && prev.col == current.col) {
                    return false;
                }
            }

            // 현재 코어의 방향이 왼쪽이면 현재 코어의 왼쪽에 다른 코어들이나 다른 코어들의 전선이 없는지 확인
            else if (direction == LEFT) {
                if (prev.row < current.row && prev.col < current.col && prev.direction == DOWN
                        || prev.row > current.row && prev.col < current.col && prev.direction == UP
                        || prev.row == current.row && prev.col < current.col) {
                    return false;
                }
            }
        }
        // 다른 코어들이 전부 위 조건들에 해당하지 않는다면 연결 가능
        return true;
    }

    /** 코어를 연결하는 메소드 */
    public static void connectCore(int coreIdx, int connect) {
    	// 모든 코어의 연결을 세팅했다면(연결x 포함) 전선 길이 합 메소드 호출 
        if (coreIdx == coreList.size()) {
            if (maxConnect < connect) {
                maxConnect = connect;
                minTotalWire = countWire();
            } else if (maxConnect == connect) {
                minTotalWire = Math.min(minTotalWire, countWire());
            }
            return;
        }
        
        // 남은 코어를 전부 더해도 최대 코어 연결 개수보다 적다면 더 탐색하지 않는다
        if (connect + coreList.size() - coreIdx < maxConnect) {
        	return;
        }

        Position current = coreList.get(coreIdx); // 현재 탐색할 코어

        // 가장자리 코어
        if (current.direction == 5) {
        	connectCore(coreIdx + 1, connect + 1);
        }

        // 코어의 방향을 위쪽으로 설정할 수 있다면 코어 연결
        if (checkConnection(current, UP)) {
            current.direction = UP;
            connectCore(coreIdx + 1, connect + 1); // 코어 연결
        }
        
        // 코어의 방향을 오른쪽로 설정할 수 있다면 코어 연결
        if (checkConnection(current, RIGHT)) {
            current.direction = RIGHT;
            connectCore(coreIdx + 1, connect + 1); // 코어 연결
        }
        
        // 코어의 방향을 아래쪽로 설정할 수 있다면 코어 연결
        if (checkConnection(current, DOWN)) {
            current.direction = DOWN;
            connectCore(coreIdx + 1, connect + 1); // 코어 연결
        }
        
        // 코어의 방향을 왼쪽로 설정할 수 있다면 코어 연결
        if (checkConnection(current, LEFT)) {
            current.direction = LEFT;
            connectCore(coreIdx + 1, connect + 1); // 코어 연결
        }
        
        // 코어 연결 해제
        current.direction = 0;
        connectCore(coreIdx + 1, connect);
        
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= testCase; tc++) {
            size = Integer.parseInt(br.readLine().trim());
            processor = new int[size][size];
            coreList = new LinkedList<>();
            maxConnect = 0;

            for (int row = 0; row < size; row++) {
                st = new StringTokenizer(br.readLine().trim());
                for (int col = 0; col < size; col++) {
                    processor[row][col] = Integer.parseInt(st.nextToken());

                    // 가장자리가 아닌 코어는 방향을 0으로, 가장자리인 코어는 방향을 5로 설정
                    if (processor[row][col] == CORE) {
                        if (row != 0 && col != 0 && row != size - 1 && col != size - 1) {
                            coreList.add(new Position(row, col, 0));
                        } else {
                            // 가장자리 코어의 방향은 EDGE로 설정하고, 가장자리 코어의 개수를 센다
                            coreList.add(new Position(row, col, EDGE));
                        }
                    }
                }
            }

            minTotalWire = Integer.MAX_VALUE;
            connectCore(0, 0);

            sb.append("#").append(tc).append(" ").append(minTotalWire).append("\n");
        }
        System.out.println(sb);
    }
}
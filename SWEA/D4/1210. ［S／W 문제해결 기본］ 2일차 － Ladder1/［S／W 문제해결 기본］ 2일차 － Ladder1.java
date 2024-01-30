import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 사다리의 목표 지점인 아래에서부터 위로 올라온다.
 * (사다리를 거꾸로 탄다.)
 *
 * 1. 10개의 테스트 케이스만큼 반복한다.
 * 2. 100 * 100 사이즈의 사다리를 입력받아 배열에 저장한다.
 * 3. 사다리 배열의 가장 마지막 행에서 사다리 막대들(1)과 목표 지점(2)을 찾는다.
 * 4. 목표 지점에서 위로 출발한다.
 * 5. 현재 위치의 좌, 우를 우선적으로 체크한다.
 *    5-1. 좌가 1이면 왼쪽 막대로, 우가 1이면 오른쪽 막대로 이동한다.
 * 6. 좌나 우가 1이 나올 때까지 위로 올라간다.
 * 8. 1행에 도달할 때까지 5~6을 반복한다.
 */
public class Solution {
    public static BufferedReader br;
    public static StringBuilder sb;
    public static StringTokenizer st;

    public static final int SIZE = 100;
    public static int[][] ladder;
    public static ArrayList<Integer> bar;
    static int barIdx;

    public static int rideLadder(int rowIdx, int colIdx) {
        // 0번째 행에 도달할 때까지 반복
        while (rowIdx > 0) {
            // 좌나 우에 1이 있으면 해당 좌표로 이동하여 탐색
            if (colIdx - 1 >= 0 && ladder[rowIdx][colIdx - 1] == 1) {
                colIdx = bar.get(--barIdx);
            } else if (colIdx + 1 < SIZE && ladder[rowIdx][colIdx + 1] == 1) {
                colIdx = bar.get(++barIdx);
            }
            rowIdx--;
        }
        return colIdx;
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        // 테스트 케이스만큼 반복한다
        for (int tc = 1; tc <= 10; tc++) {
            bar = new ArrayList<>();
            int testCase = Integer.parseInt(br.readLine().trim());
            // 사다리타기 경로를 저장할 배열을 선언한다
            ladder = new int[SIZE][SIZE];
            // 현재 위치
            int currentBar = 0;

            // 사다리타기 경로를 입력받아 사다리 배열에 저장한다
            for (int rowIdx = 0; rowIdx < SIZE; rowIdx++) {
                st = new StringTokenizer(br.readLine().trim());

                for (int colIdx = 0; colIdx < SIZE; colIdx++) {
                    ladder[rowIdx][colIdx] = Integer.parseInt(st.nextToken());
                }
            }

            // 마지막 행에서 목표 지점과 사다리 막대 부분을 찾는다
            for (int idx = 0; idx < SIZE; idx++) {
                if (ladder[SIZE - 1][idx] == 1) {
                    bar.add(idx);
                } else if (ladder[SIZE - 1][idx] == 2) {
                    bar.add(idx);
                    currentBar = idx; // 시작 위치는 출발점 (현재 코드에서는 탐색 끝 지점)
                    barIdx = bar.indexOf(idx); // 현재 위치의 막대 인덱스
                }
            }

            // 사다리 타는 메서드 호출
            currentBar = rideLadder(SIZE - 1, currentBar);
            sb.append("#").append(testCase).append(" ").append(currentBar).append("\n");
        }
        System.out.println(sb);
    }
}
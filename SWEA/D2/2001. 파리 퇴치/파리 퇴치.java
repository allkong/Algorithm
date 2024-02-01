import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 테스트 케이스를 입력받는다.
 * 2. 파리의 개수를 담을 배열의 사이즈와 파리채의 사이즈를 입력받는다.
 * 3. 파리의 개수를 입력받아 배열에 저장한다.
 *    3-1. 2차원 배열을 선언한다.
 *    3-2. 입력받을 때 숫자 그대로가 아니라 누적합으로 저장한다.
 * 4. 파리 배열 위에 파리채 배열로 한 칸씩 이동하며 탐색한다.
 * 5. 누적합을 활용해 파리채 배열 안의 죽은 파리 개수를 계산한다.
 *    5-1. 탐색하면서 죽은 파리의 개수가 더 크면 업데이트한다.
 */
public class Solution {
    public static BufferedReader br;
    public static StringBuilder sb;
    public static StringTokenizer st;

    public static int flyMapSize; // 파리 배열 사이즈
    public static int flySwatterSize; // 파리채 사이즈
    public static int flyMax; // 죽은 파리의 개수
    public static int[][] flyMap; // 파리 개수를 담을 배열


    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= testCase; tc++) {
            st = new StringTokenizer(br.readLine().trim());
            flyMapSize = Integer.parseInt(st.nextToken());
            flySwatterSize = Integer.parseInt(st.nextToken());
            flyMap = new int[flyMapSize + 1][flyMapSize + 1];

            for (int row = 1; row <= flyMapSize; row++) {
                st = new StringTokenizer(br.readLine().trim());
                for (int col = 1; col <= flyMapSize; col++) {
                    // 누적합으로 저장한다
                    flyMap[row][col] = Integer.parseInt(st.nextToken()) + flyMap[row - 1][col] + flyMap[row][col - 1] - flyMap[row - 1][col - 1];
                }
            }

            // (0, 0) ~ (flySwatterSize, flySwatterSize) 사이즈의 파리채 배열로 파리 배열을
            // 가로 세로 각각 (flyMapSize - flySwatterSize + 1)번 탐색해야 함
            flyMax = 0;
            for (int row = 1; row <= flyMapSize - flySwatterSize + 1; row++) {
                for (int col = 1; col <= flyMapSize - flySwatterSize + 1; col++) {
                    flyMax = Math.max(flyMax, flyMap[row + flySwatterSize - 1][col + flySwatterSize - 1] - flyMap[row + flySwatterSize - 1][col - 1] - flyMap[row - 1][col + flySwatterSize - 1] + flyMap[row - 1][col - 1]);
                }
            }
            sb.append("#").append(tc).append(" ").append(flyMax).append("\n");
        }
        System.out.println(sb);
    }
}
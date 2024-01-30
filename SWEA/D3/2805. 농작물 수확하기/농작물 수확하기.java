import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 1. 테스트 케이스를 입력받고 테스트 케이스만큼 반복한다.
 * 2. 농장의 크기와 농장 내 작물의 가치를 입력받는다.
 *    2-1. 농장 내 작물의 가치를 배열에 저장한다.
 * 3. 농장의 크기는 항상 홀수이기 때문에 가운데 행의 모든 작물 가치를 수익에 더한다.
 * 4. 가운데 행을 기준으로 위 피라미드와 아래 역피라미드의 작물 가치를 수익에 더한다.
 */
public class Solution {
    public static BufferedReader br;
    public static StringBuilder sb;
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= testCase; tc++) {
            int size = Integer.parseInt(br.readLine()); // 농장의 크기
            int[][] farm = new int[size][size]; // 농장 내 농작물 가치 배열
            int profit = 0; // 수익
            int mid = size / 2; // 행 중간 지점

            // 농장 내 농작물 가치를 입력받아 2차원 배열에 저장한다
            for (int rowIdx = 0; rowIdx < size; rowIdx++) {
                String line = br.readLine().trim();
                for (int colIdx = 0; colIdx < size; colIdx++) {
                    farm[rowIdx][colIdx] = Character.getNumericValue(line.charAt(colIdx));
                }
            }

            // 가운데 행의 모든 작물 가치를 수익에 더한다
            profit += Arrays.stream(farm[mid]).sum();

            // 가운데 행을 기준으로 위 피라미드와 아래 역피라미드의 작물 가치를 수익에 더한다
            for (int move = 1; move <= mid; move++) {
                for (int col = move; col < size - move; col++) {
                    profit += farm[mid - move][col]; // 위 피라미드
                    profit += farm[mid + move][col]; // 아래 역피라미드
                }
            }
            sb.append("#").append(tc).append(" ").append(profit).append("\n");
        }
        System.out.println(sb);
    }
}
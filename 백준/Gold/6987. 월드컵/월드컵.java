import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 전체 경기 수는 (나라 개수) * (나라 개수 - 1) / 2 이다.
 * 2. 각 나라의 승+무+패 합이 5여야 한다.
 * 3. 만약 모든 경기에 무승부인 경기가 없다면
 *    3-1. 모든 나라의 승리 합과 모든 나라의 패배 합이 전체 경기 수와 같아야 한다.
 * 4. 만약 모든 경기에 무승부인 경기가 있다면
 *    4-1. 모든 나라의 무승부 합은 짝수여야 한다.
 *    4-2. 한 나라의 무승부 횟수가 모든 나라의 무승부 합의 과반수를 넘지 않아야 한다.
 *    4-3. 전체 경기 수에서 모든 나라의 무승부 합 절반을 뺀 값이 모든 나라의 승리 합(=모든 나라의 패배 합)과 같아야 한다.
 * 5. 한 나라(one)를 기준으로 다른 나라(other)와의 경기를 비교하여 승, 패, 합을 하나씩 센다.
 *    5-1. 모두 정확하게 떨어질 때가 가능한 경우이다.
 */
public class Main {
    public static BufferedReader br;
    public static StringBuilder sb;
    public static StringTokenizer st;

    public static final int TEST_CASE = 4; // 테스트 케이스
    public static final int COUNTRY_COUNT = 6; // 나라 개수
    public static final int MATCH_COUNT = COUNTRY_COUNT - 1; // 각 나라의 경기 수
    public static final int RESULT_CASE = 3; // 승, 무, 패 3가지
    public static final int WIN_NUMBER = 0;
    public static final int DRAW_NUMBER = 1;
    public static final int LOSE_NUMBER = 2;

    public static int countryMatches; // 한 나라의 경기 수
    public static int totalMatches; // 전체 경기 수
    public static int totalWin; // 모든 나라의 승리 합
    public static int totalDraw; // 모든 나라의 무승부 합
    public static int totalLose; // 모든 나라의 패배 합
    public static boolean casePossible; // 불가능한 경우를 통해 가능한 결과인지 판단
    public static boolean countPossible; // 승패합을 하나씩 세어봤을 때 가능한 결과인지 판단

    public static int[][] matchResult;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        // 전체 경기수를 구한다
        totalMatches = COUNTRY_COUNT * MATCH_COUNT / 2;

        matchResult = new int[COUNTRY_COUNT][RESULT_CASE];

        for (int tc = 0; tc < TEST_CASE; tc++) {
            totalWin = 0;
            totalDraw = 0;
            totalLose = 0;
            casePossible = true;

            // 경기 정보를 입력받는다
            st = new StringTokenizer(br.readLine().trim());
            for (int countryIdx = 0; countryIdx < COUNTRY_COUNT; countryIdx++) {
                for (int resultIdx = 0; resultIdx < RESULT_CASE; resultIdx++) {
                    matchResult[countryIdx][resultIdx] = Integer.parseInt(st.nextToken());
                }
            }

            // 모든 나라의 승리 합, 모든 나라의 무승부 합, 모든 나라의 패배 합을 구한다
            for (int countryIdx = 0; countryIdx < COUNTRY_COUNT; countryIdx++) {
                countryMatches = matchResult[countryIdx][WIN_NUMBER] + matchResult[countryIdx][DRAW_NUMBER] + matchResult[countryIdx][LOSE_NUMBER];
                // 각 나라의 경기 수가 (나라 - 1)만큼이여야 한다
                if (countryMatches != MATCH_COUNT) {
                    casePossible = false;
                    break;
                }

                totalWin += matchResult[countryIdx][WIN_NUMBER];
                totalDraw += matchResult[countryIdx][DRAW_NUMBER];
                totalLose += matchResult[countryIdx][LOSE_NUMBER];
            }

            // 만약 모든 경기에 무승부인 경기가 없다면
            // 모든 나라의 승리 합과 모든 나라의 패배 합이 전체 경기 수와 같아야 한다
            if (totalDraw == 0) {
                if (totalMatches != totalWin || totalMatches != totalLose) {
                    casePossible = false;
                }
            }
            // 만약 모든 경기에 무승부인 경기가 있다면
            else {
                int lastMatches = totalMatches - (totalDraw / 2);

                // 모든 나라의 무승부 합은 짝수여야 한다
                // 전체 경기 수에서 모든 나라의 무승부 합 절반을 뺀 값이 모든 나라의 승리 합, 모든 나라의 패배 합과 같아야 한다
                if (totalDraw % 2 != 0 || lastMatches != totalWin) {
                    casePossible = false;
                }

                // 한 나라의 무승부 횟수가 모든 나라의 무승부 합의 과반수를 넘지 않아야 한다
                for (int countryIdx = 0; countryIdx < COUNTRY_COUNT; countryIdx++) {
                    if (matchResult[countryIdx][DRAW_NUMBER] > totalDraw / 2) {
                        casePossible = false;
                        break;
                    }
                }
            }

            if (casePossible) {
                countPossible = false;
                checkMatches(0, 1);
            }

            sb.append(casePossible && countPossible? 1 : 0).append(" ");
        }
        System.out.println(sb);
    }

    public static void checkMatches(int one, int other) {
        // 6개국을 다 살펴보았다면 종료한다
        if (one == COUNTRY_COUNT) {
            countPossible = true;
            return;
        }

        // one 나라가 다른 나라들과 경기하는 경우를 다 살펴봤다면 기준(one)을 다음 나라로 잡는다
        if (other == COUNTRY_COUNT) {
            checkMatches(one + 1, one + 2);
            return;
        }

        // one: 승, other: 패
        if (matchResult[one][WIN_NUMBER] > 0 && matchResult[other][LOSE_NUMBER] > 0) {
            matchResult[one][WIN_NUMBER]--;
            matchResult[other][LOSE_NUMBER]--;

            checkMatches(one, other + 1);

            matchResult[one][WIN_NUMBER]++;
            matchResult[other][LOSE_NUMBER]++;
        }

        // one: 무, other: 무
        if (matchResult[one][DRAW_NUMBER] > 0 && matchResult[other][DRAW_NUMBER] > 0) {
            matchResult[one][DRAW_NUMBER]--;
            matchResult[other][DRAW_NUMBER]--;

            checkMatches(one, other + 1);

            matchResult[one][DRAW_NUMBER]++;
            matchResult[other][DRAW_NUMBER]++;
        }

        // one: 패, other: 승
        if (matchResult[one][LOSE_NUMBER] > 0 && matchResult[other][WIN_NUMBER] > 0) {
            matchResult[one][LOSE_NUMBER]--;
            matchResult[other][WIN_NUMBER]--;

            checkMatches(one, other + 1);

            matchResult[one][LOSE_NUMBER]++;
            matchResult[other][WIN_NUMBER]++;
        }
    }
}
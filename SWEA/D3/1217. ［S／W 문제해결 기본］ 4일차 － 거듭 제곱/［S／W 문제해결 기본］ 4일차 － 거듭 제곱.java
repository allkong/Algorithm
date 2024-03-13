import java.util.Scanner;

/**
 * 1. 테스트 케이스를 입력받는다.
 * 2. 밑과 지수를 입력받는다.
 * 3. 지수만큼 재귀를 들어가서 num에 자기 자신을 곱한다.
 */
public class Solution {
    public static int base; // 밑
    public static int exponent; // 지수

    /**
     * 재귀로 거듭제곱을 구하는 메소드
     * num: 밑으로 시작해서 자신을 계속 곱하는 숫자, count: 재귀 횟수
     */
    public static int recursive(int num, int count) {
        // 지수만큼 재귀했다면 자신을 곱해서 리턴한다
        if (count == 0) {
            return 1;
        }
        // 지수만큼 재귀한다
        return num * recursive(num, count - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int testCase = 10;
        for (int tc = 1; tc <= testCase; tc++) {
            int caseNum = sc.nextInt();

            base = sc.nextInt();
            exponent = sc.nextInt();

            int resultValue = recursive(base, exponent);

            System.out.println("#" + tc + " " + resultValue);
        }
    }
}
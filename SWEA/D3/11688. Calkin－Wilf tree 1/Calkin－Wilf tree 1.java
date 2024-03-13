import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1. 테스트 케이스를 입력받는다.
 * 2. 문자열 명령어를 입력받는다.
 *    2-1. 각 문자가 하나의 명령어이며, 명령어는 'L' 또는 'R'이다.
 * 3. 명령어가 L이면 왼쪽 자식 노드로 이동한다.
 *    3-1. 현재 노드가 a/b라면, 왼쪽 자식 노드는 a/(a+b)
 * 4. 명령어가 R이면 오른쪽 자식 노드로 이동한다.
 *    4-1. 현재 노드가 a/b라면, 오른쪽 자식 노드는 (a+b)/b
 */
public class Solution {
    public static BufferedReader br;
    public static StringBuilder sb;
    
    public static int numerator; // 분자
    public static int denominator; // 분모

    /**
     * 왼쪽 자식 노드로 이동하는 메소드
     * @param a: 탐색 시작 시 분자에 해당하는 숫자
     * @param b: 탐색 시작 시 분모에 해당하는 숫자
     */
    static void moveLeftChild(int a, int b) {
        // 현재 노드가 a/b라면, 왼쪽 자식 노드는 a/(a+b)
        numerator = a;
        denominator = a + b;
    }

    /**
     * 오른쪽 자식 노드로 이동하는 메소드
     * @param a: 탐색 시작 시 분자에 해당하는 숫자
     * @param b: 탐색 시작 시 분모에 해당하는 숫자
     */
    static void moveRightChild(int a, int b) {
        // 현재 노드가 a/b라면, 오른쪽 자식 노드는 (a+b)/b
        numerator = a + b;
        denominator = b;
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= testCase; tc++) {
            String commands = br.readLine().trim();
            // 루트는 1/1이다
            numerator = 1;
            denominator = 1;
            
            // 명령어를 하나씩 수행한다
            for (int idx = 0; idx < commands.length(); idx++) {
                char command = commands.charAt(idx);
                
                // L이면 왼쪽 자식 노드로 이동한다
                if (command == 'L') {
                    moveLeftChild(numerator, denominator);
                }
                
                // R이면 오른쪽 자식 노드로 이동한다
                else if (command == 'R') {
                    moveRightChild(numerator, denominator);
                }
            }

            sb.append("#").append(tc).append(" ").append(numerator).append(" ").append(denominator).append("\n");
        }
        System.out.println(sb);
    }
}
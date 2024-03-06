import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 숫자 1부터 입력받은 숫자까지 반복문을 돌린다.
 * 2. 현재 숫자의 자릿수만큼 반복문을 돌린다.
 * 3. 3, 6, 9와 같은 숫자가 있으면 StringBuilder에 '-'를 넣는다.
 * 4. 없으면 그냥 숫자를 넣는다.
 */
public class Solution {
    public static BufferedReader br;
    public static StringBuilder sb;
    public static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        int end = Integer.parseInt(br.readLine().trim());
        
        for (int num = 1; num <= end; num++) {
            boolean clap = false;
            // 현재 숫자의 자릿수만큼 반복문을 돌린다
            for (int digitNum = 0; digitNum < String.valueOf(num).length(); digitNum++) {
                char current = String.valueOf(num).charAt(digitNum);
                // 3, 6, 9와 같은 숫자가 있으면 StringBuilder에 '-'를 넣는다
                if (current == '3' || current == '6' || current == '9') {
                    sb.append('-');
                    clap = true;
                }
            }
            // 박수를 친 적 없다면 StringBuilder에 숫자를 넣는다
            if (!clap) {
                sb.append(num);
            }
            sb.append(" ");
        }
        
        System.out.println(sb);
    }
}
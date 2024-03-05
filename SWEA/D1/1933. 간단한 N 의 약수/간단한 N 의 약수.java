import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 숫자를 입력받는다.
 * 2. 입력받은 숫자의 약수를 구한다.
 *    2-1. 1부터 자신까지 입력받은 숫자를 나누었을 때 나누어 떨어지면 약수이다.
 */
public class Solution {
	public static BufferedReader br;
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		int num = Integer.parseInt(br.readLine().trim());
		
		for (int idx = 1; idx <= num; idx++) {
			// 1부터 자신까지 입력받은 숫자를 나누었을 때 나누어 떨어지면 약수이다.
			if (num % idx == 0) {
				sb.append(idx).append(" ");
			}
		}
		
		System.out.println(sb);
	}
}

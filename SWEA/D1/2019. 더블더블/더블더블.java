import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1. 2의 n제곱을 출력한다.
 *    1-1. n은 0부터 입력받은 숫자까지이다.
 * 3. Math.pow()를 활용해 2의 n제곱을 구할 수 있다.
 */
public class Solution {
	public static BufferedReader br;
	public static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		int num = Integer.parseInt(br.readLine().trim());
		
		for (int idx = 0; idx <= num; idx++) {
			sb.append((int) Math.pow(2, idx)).append(" ");
		}
		
		System.out.println(sb);
	}
}

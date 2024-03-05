import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 비밀번호 숫자 4자리를 입력받는다.
 * 2. 몇 번부터 확인할 건지 입력받는다.
 * 3. 2번에서 입력받은 숫자부터 차례로 1씩 더해서 비밀번호 숫자 4자리까지 도달한 횟수를 구한다.
 *    3-1. 횟수 = 비밀번호 숫자 - 시작하는 숫자 + 1
 */
public class Solution {
	public static BufferedReader br;
	public static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine().trim());
		int password = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		
		System.out.println(password - start + 1);
	}
}

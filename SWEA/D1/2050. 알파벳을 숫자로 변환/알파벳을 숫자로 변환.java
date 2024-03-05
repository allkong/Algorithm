import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1. 입력받은 알파벳들을 숫자로 변환하여 출력한다.
 *    1-1. A가 1로 시작한다.
 * 2. 아스키코드로 A가 65이기 때문에 -64를 하면 각 알파벳에 해당하는 숫자를 구할 수 있다.
 */
public class Solution {
	public static BufferedReader br;
	public static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		String line = br.readLine().trim();
		
		for (int idx = 0; idx < line.length(); idx++) {
			sb.append(line.charAt(idx) - 64).append(" ");
		}
		
		System.out.println(sb);
	}
}

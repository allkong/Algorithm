import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/** 
 * 1. 입력받은 문자열의 문자들을 모두 대문자로 바꿔서 출력한다.
 * 2. toUpperCase()를 활용하면 문자열의 모든 문자를 대문자로 바꿔준다.
 */
public class Solution {
	public static BufferedReader br;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine().trim();
		System.out.println(line.toUpperCase());
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1. 문자열을 입력받아 StringBuilder에 넣는다.
 * 2. StringBuilder를 reverse해서 문자열 내의 문자 순서를 뒤집는다.
 * 3. 처음 입력받은 문자열과 reverse한 문자열을 비교해서 같으면 1, 다르면 0을 출력한다.
 */
public class Solution {
	public static BufferedReader br;
	public static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		int testCase = Integer.parseInt(br.readLine().trim());
		
		for (int tc = 1; tc <= testCase; tc++) {
			String originalWord = br.readLine().trim();
			StringBuilder reverseWord = new StringBuilder(originalWord);
			
			int palindrom = 0; // 회문인지 체크 (회문이면 1, 회문이 아니면 0)
			// StringBuilder를 reverse해서 문자열 내의 문자 순서를 뒤집는다
			if (originalWord.equals(reverseWord.reverse().toString())) {
				palindrom = 1;
			}
			
			sb.append("#").append(tc).append(" ").append(palindrom).append("\n");
		}
		System.out.println(sb);
	}
}
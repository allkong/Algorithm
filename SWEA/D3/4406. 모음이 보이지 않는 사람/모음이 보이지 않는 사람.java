import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1. 테스트 케이스를 입력받는다.
 * 2. 문자열을 입력받는다.
 * 3. 문자열을 한 문자씩 순회한다.
 *    3-1. 한 문자 당 모음 배열과 비교하여 모음이 아니면 stringBuilder에 넣는다.
 */
public class Solution {
	public static BufferedReader br;
	public static StringBuilder sb;
	
	public static final char[] vowels = {'a', 'e', 'i', 'o', 'u'}; // 모음 배열
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		int testCase = Integer.parseInt(br.readLine().trim());
		
		for (int tc = 1; tc <= testCase; tc++) {
			sb.append("#").append(tc).append(" ");
			String str = br.readLine().trim();
			
			for (int idx = 0; idx < str.length(); idx++) {
				boolean isVowel = false; // 모음 여부
				for (int vowel = 0; vowel < vowels.length; vowel++) {
					// 탐색 중인 문자가 모음이라면 isVowel을 true로 변경
					if (str.charAt(idx) == vowels[vowel]) {
						isVowel = true;
					}
				}
				
				// 모음이 아니면 StringBuilder에 넣는다
				if (!isVowel) {
					sb.append(str.charAt(idx));
				}
			}
			
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
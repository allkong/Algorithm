import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 1. 암호의 자릿수와 가능한 문자 개수를 입력받는다.
 * 2. 가능한 문자들을 입력받는다.
 *    2-1. 암호를 이루는 알파벳이 암호에서 증가하는 순서이므로 정렬한다.
 * 3. 문자들에서 조합으로 암호의 자릿수만큼 뽑는다.
 * 4. 뽑은 조합의 문자들이 최소 모음 1개, 자음 2개가 포함된 조합이라면 가능성 있는 암호로 판단한다.
 */
public class Main {
	public static BufferedReader br;
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static final char[] vowel = {'a', 'e', 'i', 'o', 'u'}; // 모음
	
	public static int passwordDigit; // 암호의 자릿수
	public static int charCount; // 가능한 문자 개수
	public static char[] possibleChar; // 가능한 문자들
	public static int[] selectList; // 선택한 암호
	
	/** 암호 후보가 가능성 있는 암호인지 확인하는 메서드 */
	public static boolean checkPassword() {
		int vowelCount = 0;
		
		// 선택한 암호 후보의 모음 개수를 센다
		for (int passwordIdx = 0; passwordIdx < passwordDigit; passwordIdx++) {
			for (int vowelIdx = 0; vowelIdx < vowel.length; vowelIdx++) {
				if (possibleChar[selectList[passwordIdx]] == vowel[vowelIdx]) {
					vowelCount++;
				}
			}
		}
		
		// 최소 모음 1개, 자음 2개가 포함된 조합인지 확인한다
		if (vowelCount > 0 && passwordDigit - vowelCount > 1) {
			return true;
		}
		return false;
	}
	
	/** 조합으로 가능한 암호 후보를 뽑는 메서드 */
	public static void selectPassword(int selectIdx, int charIdx) {
		if (selectIdx == passwordDigit) {
			// 가능성이 있는 암호이면 출력한다
			if (checkPassword()) {
				for (int idx = 0; idx < passwordDigit; idx++) {
					sb.append(possibleChar[selectList[idx]]);
				}
				sb.append("\n");
			}
			return;
		}
		
		if (charIdx == charCount) {
			return;
		}
		
		selectList[selectIdx] = charIdx;
		selectPassword(selectIdx + 1, charIdx + 1);
		selectList[selectIdx] = 0;
		selectPassword(selectIdx, charIdx + 1);
	}
		
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine().trim());
		passwordDigit = Integer.parseInt(st.nextToken());
		charCount = Integer.parseInt(st.nextToken());
		
		possibleChar = new char[charCount];
		selectList = new int[passwordDigit];
		
		st = new StringTokenizer(br.readLine().trim());
		
		for (int idx = 0; idx < charCount; idx++) {
			possibleChar[idx] = st.nextToken().charAt(0);
		}
		
		// 암호를 이루는 알파벳이 암호에서 증가하는 순서이므로 정렬한다
		Arrays.sort(possibleChar);
		
		// 가능성이 있는 암호를 구한다
		selectPassword(0, 0);
		
		System.out.println(sb);
	}
}
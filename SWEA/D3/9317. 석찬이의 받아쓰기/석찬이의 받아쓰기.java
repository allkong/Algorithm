import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1. 테스트케이스를 입력받는다.
 * 2. 문자열의 길이를 입력받는다.
 * 3. 따라 적어야 하는 문자열을 입력받는다.
 * 4. 따라 적은 문자열을 입력받는다.
 * 5. 따라 적어야 하는 문자열과 따라 적은 문자열을 한 자리씩 비교한다.
 *    5-1. 비교 중인 문자가 같으면 횟수를 1 증가시킨다.
 */
public class Solution {
    public static BufferedReader br;
    public static StringBuilder sb;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        int testCase = Integer.parseInt(br.readLine().trim());
        
        for (int tc = 1; tc <= testCase; tc++) {
        	int strLength = Integer.parseInt(br.readLine().trim());
        	String firstLine = br.readLine().trim();
        	String secondLine = br.readLine().trim();
        	
        	int sameCount = 0; // 두 문자열의 같은 문자 개수
        	// 따라 적어야 하는 문자열과 따라 적은 문자열을 한 자리씩 비교한다
        	for (int idx = 0; idx < strLength; idx++) {
        		// 비교 중인 문자가 같으면 횟수를 1 증가시킨다
        		if (firstLine.charAt(idx) == secondLine.charAt(idx)) {
        			sameCount++;
        		}
        	}
            
            sb.append("#").append(tc).append(" ").append(sameCount).append("\n");
        }
        System.out.println(sb);
    }
}
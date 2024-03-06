import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 반복문을 통해 1부터 마디의 최대 길이(10)까지를 검사 길이로 설정한다.
 * 2. 검사 길이만큼의 문자열을 만든다.
 * 3. 2번 문자열 다음에 오는 검사 길이만큼의 문자열을 반복해서 2번과 비교한다.
 *    3-1. 2번 문자열과 같지 않다면 현재 길이에서 패턴이 존재하지 않는다. (break)
 * 4. 3번 검사를 마쳤을 때 패턴이 존재한다면 종료한다.
 *    4-1. 존재하지 않는다면 다음 길이를 탐색한다.
 */
public class Solution {
    public static BufferedReader br;
    public static StringBuilder sb;
    public static StringTokenizer st;
    
    public static final int MAX_LENGTH = 10;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        int testCase = Integer.parseInt(br.readLine().trim());
        
        for (int tc = 1; tc <= testCase; tc++) {
        	String line = br.readLine().trim();
        	// 검사할 패턴 길이 설정
        	for (int length = 1; length <= MAX_LENGTH; length++) {
        		String current = line.substring(0, length); // 검사 길이만큼의 문자열
        		boolean isPattern = true; // 패턴이 존재하는지
        		
        		for (int idx = length; idx < line.length() - length; idx += length) {
        			// 다음 검사 길이만큼의 문자열
        			String next = line.substring(idx, idx + length);
        			
        			// 두 문자열이 다르다면 현재 길이에서 패턴이 반복하지 않는다
        			if (!current.equals(next)) {
        				isPattern = false;
        				break;
        			}
        		}
        		
        		// 검사를 마치고 패턴이 존재하면 종료
        		if (isPattern) {
        			sb.append("#").append(tc).append(" ").append(length).append("\n");
        			break;
        		}
        	}
        }
        
        System.out.println(sb);
    }
}
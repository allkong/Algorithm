import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static BufferedReader br;
    public static StringBuilder sb;
    public static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        int testCase = Integer.parseInt(br.readLine().trim());
        
        for (int tc = 1; tc <= testCase; tc++) {
        	st = new StringTokenizer(br.readLine().trim());
        	
        	int bitCount = Integer.parseInt(st.nextToken()); // 마지막 비트 개수
        	int number = Integer.parseInt(st.nextToken()); // 확인할 숫자
        	
        	// bitCount만큼 1로 채워진 숫자를 구한다
        	int bit = (1 << bitCount) - 1;
        	// & 연산을 통해 비트가 켜져 있는지 판별한다
        	boolean isOn = (number & bit) == bit;
        	
        	// 출력
        	sb.append("#").append(tc).append(" ");
        	if (isOn) {
        		sb.append("ON");
        	} else {
        		sb.append("OFF");
        	}
        	sb.append("\n");
        }
        System.out.println(sb);
    }
}
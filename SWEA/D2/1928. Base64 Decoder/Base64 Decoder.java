import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Base64;

/**
 * 1. Base64 Encoding된 문자열을 Decoding한다.
 * 2. Base64 라이브러리를 활용하여 디코딩한다.
 */
public class Solution {
    public static BufferedReader br;
    public static StringBuilder sb;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        int testCase = Integer.parseInt(br.readLine().trim());
        
        for (int tc = 1; tc <= testCase; tc++) {
            String line = br.readLine().trim();
            
            // 입력받은 문자열을 디코딩한다
            byte[] decodeResult = Base64.getDecoder().decode(line);
            // 디코딩 결과를 문자열로 변환하여 출력한다
            sb.append("#").append(tc).append(" ").append(new String(decodeResult)).append("\n");
        }
        System.out.println(sb);
    }
}
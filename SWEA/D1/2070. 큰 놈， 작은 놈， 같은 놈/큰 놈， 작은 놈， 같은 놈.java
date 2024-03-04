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
			
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			
			sb.append("#").append(tc).append(" ");
			
			if (num1 > num2) {
				sb.append(">").append("\n");
			} else if (num1 < num2) {
				sb.append("<").append("\n");
			} else {
				sb.append("=").append("\n");
			}
		}
		
		System.out.println(sb);
	}
}
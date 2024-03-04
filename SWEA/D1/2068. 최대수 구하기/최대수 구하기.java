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
			int maxNum = 0;
			st = new StringTokenizer(br.readLine().trim());
			
			for (int idx = 0; idx < 10; idx ++) {
				maxNum = Math.max(maxNum, Integer.parseInt(st.nextToken()));
			}
			
			sb.append("#").append(tc).append(" ").append(maxNum).append("\n");
		}
		System.out.println(sb);
	}
}
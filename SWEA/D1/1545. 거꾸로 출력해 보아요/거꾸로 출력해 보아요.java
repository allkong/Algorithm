import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static BufferedReader br;
	public static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		int num = Integer.parseInt(br.readLine().trim());
		
		for (int idx = num; idx >= 0; idx--) {
			sb.append(idx).append(" ");
		}
		
		System.out.println(sb);
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static BufferedReader br;
	public static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		String line = br.readLine().trim();
		
		for (int idx = 0; idx < line.length(); idx++) {
			sb.append(line.charAt(idx) - 64).append(" ");
		}
		
		System.out.println(sb);
	}
}
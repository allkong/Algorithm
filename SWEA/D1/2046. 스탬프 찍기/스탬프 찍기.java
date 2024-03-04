import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static BufferedReader br;
	public static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		int count = Integer.parseInt(br.readLine().trim());
		
		for (int idx = 0; idx < count; idx++) {
			sb.append("#");
		}
		System.out.println(sb);
	}
}
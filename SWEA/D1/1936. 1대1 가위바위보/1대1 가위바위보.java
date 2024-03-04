import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1: 가위, 2: 바위, 3: 보
 * B가 이기는 경우: (1, 2), (2, 3), (3, 1)
 */
public class Solution {
	public static BufferedReader br;
	public static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine().trim());
		
		int one = Integer.parseInt(st.nextToken());
		int other = Integer.parseInt(st.nextToken());
		
		System.out.println(one % 3 == (other + 1) % 3 ? 'A' : 'B');
	}
}
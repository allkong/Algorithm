import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1: 가위, 2: 바위, 3: 보
 * 
 * 1. A가 이기는 경우: (2, 1) (3, 2) (1, 3) 
 * 2. B가 이기는 경우: (1, 2), (2, 3), (3, 1)
 * 3. A가 이기는 경우를 보면 규칙적인 숫자이므로 A의 숫자에 +1을 하고, B의 숫자 + 1을 한 다음에 % 3을 해주면 같아진다.
 *    3-1. 위 계산을 통해 같으면 A가 승리, 같지 않으면 B가 승리이다. (비겼을 때는 고려하지 않는다)
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

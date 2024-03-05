import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1. 1부터 입력받은 숫자까지의 합을 구한다.
 * 2. 합 공식을 활용해 계산한다.
 *    2-1. 1부터 n까지의 합은 2분의 n*(n+1)이다.
 * @author SSAFY
 *
 */
public class Solution {
	public static BufferedReader br;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine().trim());
		System.out.println(num * (num + 1) / 2);
	}
}

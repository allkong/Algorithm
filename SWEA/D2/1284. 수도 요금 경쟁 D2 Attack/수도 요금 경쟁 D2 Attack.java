import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

/**
 * A사: 1리터당 P원
 * B사: 기본 요금 Q원 + R리터 초과하면 1리터당 S원
 * 종민이의 한 달간 사용하는 수도의 양: W리터
 * 1. 요금이 더 저렴한 회사를 골라야 한다.
 * 2. A사의 요금과 B사의 요금을 계산한다.
 * 3. 둘 중 요금이 더 낮은 회사를 선택하여 요금을 출력한다.
 */
public class Solution {
	public static BufferedReader br;
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static int rowCount; // 행 수
	public static List<Integer>[] triangle; // 파스칼의 삼각형
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		int testCase = Integer.parseInt(br.readLine().trim());
		
		for (int tc = 1; tc <= testCase; tc++) {
			st = new StringTokenizer(br.readLine().trim());
			
			int P = Integer.parseInt(st.nextToken());
			int Q = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int S = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			
			// A사: 1리터당 P원
			int costA = P * W;
			// B사: 기본 요금 Q원 + R리터 초과하면 1리터당 S원
			int costB = W > R ? Q + (W - R) * S : Q;
			
			// 둘 중 요금이 더 낮은 회사의 요금을 넣는다
			sb.append("#").append(tc).append(" ").append(Math.min(costA, costB)).append("\n");
		}
		System.out.println(sb);
	}
}
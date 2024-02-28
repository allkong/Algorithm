import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/** 
 * 1. 동쪽에서 서쪽 사이트 개수만큼 먼저 뽑으면, 서쪽 사이트는 위에서부터 선택된 동쪽 사이트와 연결하면 된다.
 * 2. 즉, 동쪽 사이트 개수 중에서 서쪽 사이트 개수만큼 순서 없이 뽑으면 된다. (조합: nCk) 
 */
public class Main {
	public static BufferedReader br;
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static int westCount; // 서쪽의 사이트 개수
	public static int eastCount; // 동쪽의 사이트 개수
	public static int[][] count; // 사이트의 개수를 구하기 위한 DP 배열

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		int testCase = Integer.parseInt(br.readLine().trim());
		
		for (int tc = 0; tc < testCase; tc++) {
			st = new StringTokenizer(br.readLine().trim());
			westCount = Integer.parseInt(st.nextToken());
			eastCount = Integer.parseInt(st.nextToken());
			
			count = new int[eastCount + 1][westCount + 1];
			
			// nCk에서 n이 왼쪽(left), k가 오른쪽(right)
			for (int left = 0; left <= eastCount; left++) {
				int end = Math.min(left, westCount);
				for (int right = 0; right <= end; right++) {
					// 안뽑거나 다 뽑으면 1 (nC0과 nCn은 1)
					if (right == 0 || right == left) {
						count[left][right] = 1;
					} else {
						// nCk = n-1Ck-1 + n-1Ck
						count[left][right] = count[left - 1][right - 1] + count[left - 1][right];
					}
				}
			}
			sb.append(count[eastCount][westCount]).append("\n");
		}
		System.out.println(sb);
	}
}
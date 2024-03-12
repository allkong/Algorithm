import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 테스트 케이스를 입력받는다.
 * 2. 블록의 개수를 입력받는다.
 * 3. 블록들의 높이를 입력받는다.
 * 3. 현재 블록에서 한 칸씩 올라가거나 내려간다.
 *    3-1. 현재 블록보다 다음 블록이 더 높으면 올라간다.
 *    3-2. 현재 블록보다 다음 블록이 더 낮으면 내려간다.
 * 4. 현재 블록과 다음 블록의 높이 차를 구해서 이미 저장되어 있는 난이도와 비교한다.
 *    4-1. 올라가는 거라면 maxUpBlocks와 비교하고, 내려가는 거라면 maxDownBlocks와 비교한다.
 *    4-2. 현재 난이도가 더 크면 갱신한다.
 */
public class Solution {
	public static BufferedReader br;
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static int blockCount; // 블록 개수
	public static int[] blocks; // 블록들의 높이 배열
	public static int maxUpBlocks; // 올라가기의 최대 난이도
	public static int maxDownBlocks; // 내려가기의 최대 난이도
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		int testCase = Integer.parseInt(br.readLine().trim());
		
		for (int tc = 1; tc <= testCase; tc++) {
			blockCount = Integer.parseInt(br.readLine().trim());
			blocks = new int[blockCount];
			maxUpBlocks = 0;
			maxDownBlocks = 0;
			
			st = new StringTokenizer(br.readLine().trim());
			for (int idx = 0; idx < blockCount; idx++) {
				blocks[idx] = Integer.parseInt(st.nextToken());
			}
			
			for (int idx = 0; idx < blockCount - 1; idx++) {
				// 현재 블록보다 다음 블록이 더 높으면 올라간다
				if (blocks[idx] < blocks[idx+1]) {
					maxUpBlocks = Math.max(maxUpBlocks, blocks[idx+1] - blocks[idx]);
				}
				// 현재 블록보다 다음 블록이 더 낮으면 내려간다
				else if (blocks[idx] > blocks[idx+1]) {
					maxDownBlocks = Math.max(maxDownBlocks, blocks[idx] - blocks[idx+1]);
				}
			}
			
			sb.append("#").append(tc).append(" ").append(maxUpBlocks).append(" ").append(maxDownBlocks).append("\n");
		}
		System.out.println(sb);
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 1. 테스트 케이스 개수를 입력받는다.
 * 2. 과자의 봉지 개수와 무게 합 제한을 입력받는다.
 * 3. 과자 봉지들의 무게를 입력받는다.
 * 4. 두 개의 과자 봉지 합이 무게 합 제한 이하라면 무게 합 최댓값을 갱신한다.
 */
public class Solution {
    public static BufferedReader br;
    public static StringBuilder sb;
    public static StringTokenizer st;
    
    public static int snackCount; // 과자 봉지 개수
    public static int limitWeight; // 무게 합 제한
    public static int[] snackWeight; // 과자 봉지들의 무게를 저장하는 배열
    public static int maxWeight; // 과자 봉지의 무게 합 최대
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        int testCase = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= testCase; tc++) {
        	st = new StringTokenizer(br.readLine().trim());
        	snackCount = Integer.parseInt(st.nextToken());
        	limitWeight = Integer.parseInt(st.nextToken());

        	snackWeight = new int[snackCount];
        	st = new StringTokenizer(br.readLine().trim());
        	for (int idx = 0; idx < snackCount; idx++) {
        		snackWeight[idx] = Integer.parseInt(st.nextToken());
        	}
        	
        	maxWeight = -1;
        	// 두 개의 과자 봉지 합이 무게 합 제한 이하라면 무게 합 최댓값을 갱신한다
        	for (int snackIdx = 0; snackIdx < snackCount - 1; snackIdx++) {
        		for (int otherSnackIdx = snackIdx + 1; otherSnackIdx < snackCount; otherSnackIdx++) {
        			if (snackWeight[snackIdx] + snackWeight[otherSnackIdx] <= limitWeight) {
        				maxWeight = Math.max(maxWeight, snackWeight[snackIdx] + snackWeight[otherSnackIdx]);
        			}
        		}
        	}
        	sb.append("#").append(tc).append(" ").append(maxWeight).append("\n");
        }
        System.out.println(sb);        
    }
}
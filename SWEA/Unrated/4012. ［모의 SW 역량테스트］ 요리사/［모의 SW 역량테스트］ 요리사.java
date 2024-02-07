import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 테스트 케이스를 입력받는다.
 * 2. 식재료의 수를 입력받는다.
 * 3. 시너지 값들을 입력받아 배열에 저장한다.
 * 4. 식재료들을 절반으로 분할한다.
 *    4-1. 조합으로 식재료의 수 중 (식재료의 수 / 2)만큼 뽑는다.
 * 5. 선택한 재료들의 시너지를 구한다.
 *    5-1. 시너지[식재료1][식재료2] + 시너지[식재료2][식재료1]
 * 6. 선택하지 않은 재료들의 시너지를 구한다.
 * 7. 5번과 6번의 차를 구한다.
 * 8. 7번의 값이 가장 작은 경우를 출력한다.
 */
public class Solution {
    public static BufferedReader br;
    public static StringBuilder sb;
    public static StringTokenizer st;    
    
    public static int size; // 식재료의 수
    public static int[][] synergy; // 시너지
    public static boolean[] selectSynergy; // 선택한 재료들의 시너지
    public static int minDiff; // 맛의 차이가 최소인 경우의 차
    
    public static void combination(int selectIdx, int ingredientIdx) {
    	// 조합으로 식재료의 수 중 (식재료의 수 / 2)만큼 뽑는다
    	if (selectIdx == size >> 1) {
    		int foodA = 0; // 선택한 재료들의 시너지 합
    		int foodB = 0; // 선택하지 않은 재료들의 시너지 합
    		for (int row = 0; row < size - 1; row++) {
    			for (int col = row + 1; col < size; col++) {
    				// 선택한 재료인지 확인한다
    				if (selectSynergy[row] && selectSynergy[col]) {
    					foodA += synergy[row][col] + synergy[col][row];
    				// 선택하지 않은 재료인지 확인한다
    				} else if (!selectSynergy[row] && !selectSynergy[col]) {
    					foodB += synergy[row][col] + synergy[col][row];
    				}
    			}
    		}
    		minDiff = Math.min(minDiff, Math.abs(foodA - foodB));
    		return;
    	}
    	
    	if (ingredientIdx == size) {
    		return;
    	}
    	
    	selectSynergy[ingredientIdx] = true;
    	combination(selectIdx + 1, ingredientIdx + 1);
    	selectSynergy[ingredientIdx] = false;
    	combination(selectIdx, ingredientIdx + 1);    	
    }
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        int testCase = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= testCase; tc++) {
            size = Integer.parseInt(br.readLine().trim());
            synergy = new int[size][size];
            minDiff = Integer.MAX_VALUE;
            
            for (int row = 0; row < size; row++) {
                st = new StringTokenizer(br.readLine().trim());
                for (int col = 0; col < size; col++) {
                    synergy[row][col] = Integer.parseInt(st.nextToken());
                }
            }
            
            selectSynergy = new boolean[size];
            combination(0, 0);
            sb.append("#").append(tc).append(" ").append(minDiff).append("\n");
        }
        System.out.println(sb);
    }
}
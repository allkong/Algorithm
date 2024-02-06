import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 테스트 케이스를 입력받는다.
 * 2. 재료의 수와 제한 칼로리를 입력받는다.
 * 3. 재료의 수만큼 각 맛에 대한 점수와 칼로리를 입력받아 배열에 저장한다.
 * 4. 재료 배열에서 재료를 1개 선택하는 경우부터 모두 선택하는 경우까지 각 경우의 조합을 구한다.
 * 5. 각 조합의 재료들을 더했을 때 최대 칼로리 이하인지 확인한다.
 * 6. 이하라면 가장 점수가 높은 재료 부분집합의 점수를 구한다.
 */
public class Solution {
    public static BufferedReader br;
    public static StringBuilder sb;
    public static StringTokenizer st;    
    
    public static int ingredientCount; // 재료의 수
    public static int maxCalorie; // 제한 칼로리
    public static int totalCalorie; // 칼로리의 합
    public static int maxScore; // 가장 높은 햄버거의 점수
    public static int totalScore; // 점수의 합
    public static int[][] ingredients; // 햄버거 맛 점수와 칼로리를 저장하는 배열
    public static int[] selectIngredients; // 선택한 재료의 재료 index를 저장하는 배열
    
    // 재료 배열에서 조합을 구한다
    public static void combination(int selectIdx, int ingredientIdx, int selectCount) {
    	// 다 선택했으면 해당 조합의 재료 조합을 살펴본다
    	if (selectIdx == selectCount) {
    		totalCalorie = 0;
    		totalScore = 0;
    		for (int idx = 0; idx < selectCount; idx++) {
    			totalCalorie += ingredients[selectIngredients[idx]][1];
				totalScore += ingredients[selectIngredients[idx]][0];
    		}
    		// 각 부분집합의 재료들을 더했을 때 최대 칼로리 이하인지 확인한다
    		if (totalCalorie <= maxCalorie) {
    			// 이하라면 가장 점수가 높은 재료 부분집합의 점수를 구한다
    			maxScore = Math.max(maxScore, totalScore);
    		}
    		return;
    	}
    	
    	if (ingredientIdx == ingredientCount) {
    		return;
    	}
    	// 선택한 재료 배열에 방금 선택한 재료의 index를 저장한다
    	selectIngredients[selectIdx] = ingredientIdx;
    	combination(selectIdx + 1, ingredientIdx + 1, selectCount);
    	selectIngredients[selectIdx] = 0;
    	combination(selectIdx, ingredientIdx + 1, selectCount);
    }
   
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        int testCase = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= testCase; tc++) {
        	st = new StringTokenizer(br.readLine().trim());
        	ingredientCount = Integer.parseInt(st.nextToken());
        	maxCalorie = Integer.parseInt(st.nextToken());
        	ingredients = new int[ingredientCount][2];
        	maxScore = 0;
        	
        	// 재료의 수만큼 각 맛에 대한 점수와 칼로리를 입력받아 배열에 저장한다
        	for (int idx = 0; idx < ingredientCount; idx++) {
        		st = new StringTokenizer(br.readLine().trim());
        		ingredients[idx][0] = Integer.parseInt(st.nextToken()); // 맛 점수
        		ingredients[idx][1] = Integer.parseInt(st.nextToken()); // 칼로리       		
        	}
        	
        	// 재료를 1개 선택하는 경우부터 재료를 모두 선택하는 경우까지 탐색
        	// 재료 배열에서 조합을 구하는 메서드 호출
        	for (int selectCount = 1; selectCount <= ingredientCount; selectCount++) {
        		selectIngredients = new int[selectCount];
        		combination(0, 0, selectCount);
        	}
        	
        	sb.append("#").append(tc).append(" ").append(maxScore).append("\n");
        }
        System.out.println(sb);
    }
}

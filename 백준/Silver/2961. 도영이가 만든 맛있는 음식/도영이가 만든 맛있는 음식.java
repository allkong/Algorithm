import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 재료 개수를 입력받는다.
 * 2. 각 재료의 신맛과 쓴 맛을 입력받는다.
 *    2-1. 배열을 선언해서 그 안에 저장한다.
 * 3. 재료 배열의 부분집합을 구한다.
 * 4. 각 부분집합의 신맛과 쓴맛을 계산한다.
 *    4-1. 신맛은 신맛끼리 곱하고, 쓴맛은 쓴맛끼리 더한다.
 *    4-2. 재료를 하나도 사용하지 않았을 때는 계산하지 않는다.
 * 5. 계산한 신맛과 계산한 쓴맛의 차를 구한다.
 * 6. 각 부분집합 중 5번에서 계산한 값이 가장 작은 값을 출력한다. * 
 */
public class Main {
	public static BufferedReader br;
	public static StringTokenizer st;
	
	public static final int flaverCount = 2; // 맛의 개수
	public static final int sournessIdx = 0; // 신맛의 index
	public static final int bitternessIdx = 1; // 쓴맛의 index
	
	public static int ingredientCount; // 재료 개수
	public static int sourness; // 신맛 계산값
	public static int bitterness; // 쓴맛 계산값
	public static int diff; // 신맛과 쓴맛의 차이
	public static int[][] ingredient; // 재료 배열
	public static boolean[] ingredientUsedCheckList; // 재료를 사용했는지 안했는지 체크하는 배열
	
	public static void powerSet(int selectIdx) {
		// 기저 조건
		// 선택을 완료했으면 해당 부분집합의 신맛과 쓴맛을 계산한다
		if (selectIdx == ingredientCount) {			
			// 재료를 하나도 사용하지 않았을 때는 계산하지 않는다
			int selectCount = 0;
			for (int idx = 0; idx < ingredientCount; idx++) {
				if (ingredientUsedCheckList[idx]) {
					selectCount++;
				}
			}
			if (selectCount > 0) {
				// 신맛은 곱이니 1로 초기화하고, 쓴맛은 합이니 0으로 초기화한다
				sourness = 1;
				bitterness = 0;
				
				for (int idx = 0; idx < ingredientCount; idx++) {
					if (ingredientUsedCheckList[idx]) {
						// 신맛은 신맛끼리 곱하고, 쓴맛은 쓴맛끼리 더한다
						sourness *= ingredient[idx][sournessIdx];
						bitterness += ingredient[idx][bitternessIdx];
					}
				}
				// 계산한 신맛과 계산한 쓴맛의 가장 작은 차를 구한다
				diff = Math.min(diff, Math.abs(sourness - bitterness));
				return;
			}
			return;
		}
		
		ingredientUsedCheckList[selectIdx] = true;
		powerSet(selectIdx + 1);
		
		ingredientUsedCheckList[selectIdx] = false;
		powerSet(selectIdx + 1);
	}

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));

		ingredientCount = Integer.parseInt(br.readLine()); // 재료 개수
		diff = Integer.MAX_VALUE;
		ingredient = new int[ingredientCount][flaverCount];
		ingredientUsedCheckList = new boolean[ingredientCount];
		
		// 각 재료의 신맛과 쓴맛을 입력받는다
		for (int ingredientIdx = 0; ingredientIdx < ingredientCount; ingredientIdx++) {
			st = new StringTokenizer(br.readLine().trim());
			ingredient[ingredientIdx][sournessIdx] = Integer.parseInt(st.nextToken()); // 신맛
			ingredient[ingredientIdx][bitternessIdx] = Integer.parseInt(st.nextToken()); // 쓴맛
		}
		
		// 재료들의 부분집합을 구한다
		powerSet(0);
		
		System.out.println(diff);
	}
}
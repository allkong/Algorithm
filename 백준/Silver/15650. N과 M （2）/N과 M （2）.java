import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 조합을 구현한다
 * 
 * 1. element 개수와 select 개수를 입력받는다
 * 2. 중복 없이 선택한다.
 */
public class Main {
	public static BufferedReader br;
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static int[] elementList; // 전체 원소를 담아줄 배열
	public static int[] selectElementList; // 선택한 원소를 담아줄 배열
	
	public static int elementCount;
	public static int selectCount;
	
	public static void combination(int selectIdx, int elementIdx) {
		// 1. 기저 조건
		// 조합의 기조 조건은 두 개이다
		// 원소를 다 뽑았을 때
		if (selectIdx == selectCount) {
			for (int idx = 0; idx < selectCount; idx++) {
				System.out.print(selectElementList[idx] + " ");
			}
			System.out.println();
			return;
		}
		
		// 모든 원소를 다 체크했을 때
		if (elementIdx == elementCount) {
			return;
		}
		
		// 2. 전처리 로직
		selectElementList[selectIdx] = elementList[elementIdx];
		
		// 3. 재귀 호출
		combination(selectIdx + 1, elementIdx + 1);
		
		// 2. 전처리 로직
		selectElementList[selectIdx] = 0;
		
		// 4. 재귀 호출
		combination(selectIdx, elementIdx + 1);
		
	}

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine().trim());
		// 원소 전체 개수와 선택할 원소 개수를 입력받는다
		elementCount = Integer.parseInt(st.nextToken());
		selectCount = Integer.parseInt(st.nextToken());
		
		elementList = new int[elementCount];
		selectElementList = new int[selectCount];
		
		// 전체 원소 배열에 입력받은 개수만큼 원소를 저장한다
		for (int idx = 0; idx < elementCount; idx++) {
			elementList[idx] = idx + 1;
		}
		
		// 조합 메서드 호출
		combination(0, 0);
	}
}
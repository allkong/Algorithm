import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br;
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static int[] elementList; // 전체 원소를 담아줄 배열
	public static int[] selectElementList; // 선택한 원소를 담아줄 배열
	public static boolean[] elementUsedCheckList; //  원소를 사용했는지 안했는지 체크하는 배열
	
	public static int elementCount;
	public static int selectCount;
	
	public static void permutation(int selectIdx) {
		// 1. 기저 조건
		// 숫자를 다 뽑으면 종료
		if (selectIdx == selectCount) {
			for (int idx = 0; idx < selectCount; idx++) {
				System.out.print(selectElementList[idx] + " ");
			}
			System.out.println();
			return;
		}
		
		// 2. 전처리 로직
		// 아직 다 뽑지 않았을 때
		for (int elementIdx = 0; elementIdx < elementCount; elementIdx++) {
			// 이미 선택한 숫자라면 패스
			if (elementUsedCheckList[elementIdx]) {
				continue;
			}
			
			// 아직 선택하지 않았다면
			elementUsedCheckList[elementIdx] = true;
			selectElementList[selectIdx] = elementList[elementIdx]; // select는 select끼리 element는 element끼리
			
			// 3. 재귀 호출
			permutation(selectIdx + 1);
			
			// 4. 후처리 로직
			// 다음 depth에서 쓸 수 있도록 다시 false로 초기화
			elementUsedCheckList[elementIdx] = false;
		}
	}

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		st = new StringTokenizer(br.readLine().trim());
		
		elementCount = Integer.parseInt(st.nextToken()); // 전체 개수
		selectCount = Integer.parseInt(st.nextToken()); // 뽑을 개수
		
		// 전체 개수만큼 초기화해서 해당 숫자들 배열에 담기
		elementList = new int[elementCount];
		for (int idx = 0; idx < elementCount; idx++) {
			elementList[idx] = idx + 1;
		}
		selectElementList = new int[selectCount];
		elementUsedCheckList = new boolean[elementCount];
		
		permutation(0);
	}
}
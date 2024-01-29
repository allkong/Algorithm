import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1. 종료 조건
 *    현재 depth가 입력받은 depth와 같아지면 종료한다.
 * 2. 전처리 로직
 *    "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다." 문장을 출력한다.
 * 3. 재귀 호출
 *    "재귀함수가 뭔가요?" 문장부터 "그런데 어느 날~" 문장까지 출력한다.
 * 4. 후처리 로직
 */
public class Main {
	static int depth;
	
	public static void getTab(int currentDepth) {
		// 현재 깊이만큼 "----"를 출력한다.
		for (int depth = 0; depth < currentDepth; depth++) {
			System.out.print("____");
		}
	}
	
	public static void recursive(int currentDepth) {
		getTab(currentDepth);
		System.out.println("\"재귀함수가 뭔가요?\"");
		
		// 종료 조건
		if (currentDepth == depth) {
			getTab(currentDepth);
			System.out.println("\"재귀함수는 자기 자신을 호출하는 함수라네\"");
			return;
		}
		
		// 전처리 로직
		getTab(currentDepth);
		System.out.println("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");
		getTab(currentDepth);
		System.out.println("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.");
		getTab(currentDepth);
		System.out.println("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");
		
		// 재귀 호출
		// 깊이를 증가시켜서 재귀 함수를 호출한다.
		recursive(currentDepth + 1);
		
		// 후처리 로직
		getTab(currentDepth + 1);
		System.out.println("라고 답변하였지.");
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 재귀 호출 횟수를 입력받는다.
		depth = Integer.parseInt(br.readLine());
		
		// 첫 문장을 출력한다.
		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		
		// 처음 깊이인 0으로 재귀 함수를 호출한다.
		recursive(0);
		
		// 마지막 문장을 출력한다.
		System.out.println("라고 답변하였지.");
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 1. 탑의 개수를 입력받는다.
 * 2. 탑들의 높이를 입력받는다.
 *    2-1. 배열을 선언하여 저장한다.
 * 3. 스택을 선언한다.
 * 4. tower 배열을 하나씩 탐색한다.
 * 5. 스택에 원소가 없다면 tower 원소를 push한다.
 * 6. 스택에 원소가 있다면 스택의 top과 비교한다.
 *    6-1. tower 원소가 스택의 top보다 작으면 스택의 top에 해당하는 lazer에 +1을 해준다.
 *    6-2. tower 원소가 스택의 top보다 더 크면 pop한다.
 */
public class Main {
	public static BufferedReader br;
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static int size; // 탑의 개수
	public static int[] tower; // 탑들의 높이를 저장하는 배열
	public static Stack<int[]> stack;
	public static int[] lazer; // 각각의 탑이 수신하는 레이저 신호 개수

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		size = Integer.parseInt(br.readLine().trim());
		tower = new int[size];
		st = new StringTokenizer(br.readLine().trim());
		for (int idx = 0; idx < size; idx++) {
			tower[idx] = Integer.parseInt(st.nextToken());
		}
		stack = new Stack<>();
		lazer = new int[size];
		
		// 스택에 원소가 있다면 스택의 top과 비교한다
		for (int idx = 0; idx < size; idx++) {
			// tower 배열을 하나씩 탐색하며 스택의 top과 비교한다
			while (stack.size() > 0) {
				// tower 원소가 스택의 top보다 작으면 스택의 top에 해당하는 lazer에 +1을 해준다
				if (tower[idx] < stack.peek()[1]) {
					lazer[idx] = stack.peek()[0] + 1;
					break;
				} else {
					// tower 원소가 스택의 top보다 더 크면 pop한다
					stack.pop();
				}
			}
			// 스택에 원소가 있다면 스택의 top과 비교한다
			stack.push(new int[] {idx, tower[idx]});
		}
		
		for (int count : lazer) {
			sb.append(count).append(" ");
		}
		System.out.println(sb);
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1. 카드 장수를 입력받는다.
 * 2. 제일 위에 있는 카드를 버린다.
 * 3. 제일 위에 있는 카드를 제일 아래에 있는 카드 밑으로 옮긴다.
 * 4. 2~3을 반복했을 때, 제일 마지막에 남는 카드를 출력한다.
 */
public class Main {
	public static BufferedReader br;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		int cardCount = Integer.parseInt(br.readLine().trim()); // 카드 장수
		
		Deque<Integer> deque = new ArrayDeque<>();
		
		for (int idx = 1; idx <= cardCount; idx++) {
			// 카드 큐에 숫자 카드를 삽입한다
			deque.offerLast(idx);
		}
		
		// 카드가 한 장 남을 때까지 반복한다
		while (deque.size() > 1) {
			// 카드 큐의 front 카드를 버린다
			deque.poll();
			// 카드 큐의 front 카드를 빼고 rear에 삽입한다
			deque.offerLast(deque.poll());
		}
		
		// 마지막 한 장을 출력한다
		System.out.println(deque.peek());
	}
}
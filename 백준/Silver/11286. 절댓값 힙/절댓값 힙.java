import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * 1. 연산의 개수를 입력받는다.
 * 2. 연산에 대한 정보를 입력받는다.
 * 3. 연산 정보가 0이 아니면 해당 값을 배열에 넣는다.
 * 4. 연산 정보가 0이면 배열에서 절댓값이 가장 작은 값을 배열에서 출력하고 제거한다. (최소 힙)
 *    4-1. 절댓값이 가장 작은 값이 여러 개이면 가장 작은 수를 출력한다.
 *    4-2. 배열이 비어있다면 0을 출력한다.
 */
public class Main {
	public static BufferedReader br;
	public static StringBuilder sb;
	
	public static PriorityQueue<Integer> minHeap;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		int calculationCount = Integer.parseInt(br.readLine().trim());
		// 최소 힙을 사용하기 위해 우선순위 큐를 선언한다
		// 우선순위 큐의 매개변수로 Comparator를 사용하여 절댓값 정렬을 한다
		minHeap = new PriorityQueue<>((o1, o2) -> {
			// 절댓값 값이 같으면 더 작은 수를 반환한다
			if (Math.abs(o1) == Math.abs(o2)) {
				return o1 - o2;
			}
			// 절댓값이 더 작은 수를 반환한다
			return Math.abs(o1) - Math.abs(o2);
		});
		
		for (int count = 0; count < calculationCount; count++) {
			int element = Integer.parseInt(br.readLine().trim());
			
			if (element == 0) {
				// 배열이 비어있다면 0을 출력한다
				if (minHeap.isEmpty()) {
					sb.append(0).append("\n");
				} else {
					// 배열에서 절댓값이 가장 작은 값을 배열에서 출력하고 제거한다
					sb.append(minHeap.poll()).append("\n");
				}
			} else {
				// 연산 정보가 0이 아니면 해당 값을 배열에 넣는다
				minHeap.offer(element);
			}
		}
		System.out.println(sb);
	}
}
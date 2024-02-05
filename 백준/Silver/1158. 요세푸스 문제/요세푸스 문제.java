import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 1. 인원 수와 타겟 숫자를 입력받는다.
 * 2. 인원 수대로 큐를 구현한다.
 * 3. 타겟 숫자만큼 poll한 값을 offer하는 걸 반복한다.
 */
public class Main {
	public static BufferedReader br;
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static Deque<Integer> que;
	public static int size; // 인원 수
	public static int target; // 타겟 숫자
	

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine().trim());
		size = Integer.parseInt(st.nextToken());
		target = Integer.parseInt(st.nextToken());
		// 인원 수대로 큐를 구현한다
		que = new ArrayDeque<>();
		for (int num = 1; num <= size; num++) {
			que.offer(num);
		}
		
		sb.append("<");
		// 타겟 숫자만큼 poll한 값을 offer하는 걸 반복한다
		while (que.size() > 0) {
			for (int idx = 0; idx < target - 1; idx++) {
				que.offer(que.poll());
			}
			sb.append(que.poll());
			if (que.size() > 0) {
				sb.append(", ");
			}
		}
		sb.append(">");
		System.out.println(sb);		
	}
}
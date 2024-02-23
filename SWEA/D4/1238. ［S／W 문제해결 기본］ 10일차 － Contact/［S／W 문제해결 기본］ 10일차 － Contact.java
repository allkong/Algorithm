import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 데이터의 길이와 시작점을 입력받는다.
 * 2. from(연락을 시작하는 당번), to(연락을 받을 수 있는 사람) 순으로 반복한 데이터를 입력받는다.
 * 3. 리스트의 from 인덱스에 to 값을 저장한다.
 * 4. 시작점을 큐에 넣는다.
 * 5. 현재 탐색하는 당번과 from-to 관계로 연결된 사람이 있으면 모두 큐에 넣는다.
 *    5-1. 이미 전화를 걸었던 사람이면 걸지 않는다.
 * 6. 큐가 공백 상태가 될 때까지 반복한다. 
 */
public class Solution {
	public static BufferedReader br;
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static final int TEST_CASE = 10;
	public static final int MAX_CONTACT = 100; // 연락 최대 인원
	
	public static int size; // 입력받는 데이터의 길이
	public static int maxCount;
	public static int maxLastCall; // 마지막으로 연락을 받는 사람 중 가장 번호가 큰 사람
	public static ArrayList<Integer>[] contact; // 연락 당번 정보
	public static boolean[] called; // 전화를 받은 사람을 체크한다
	public static Queue<Duty> queue;
	
	public static class Duty { // 당번
		int node;
		int count;
		
		public Duty(int node, int count) {
			this.node = node; // 사람의 번호
			this.count = count; // 전화 횟수
		}
	}
	
	public static void call(int start) {
		queue = new ArrayDeque<Duty>();
		called = new boolean[MAX_CONTACT + 1];
		
		queue.offer(new Duty(start, 0));
		called[start] = true;
		maxCount = 0;
		maxLastCall = 0;
		 
		while (!queue.isEmpty()) {
			Duty current = queue.poll();
			
			// 현재 저장한 전화 횟수보다 탐색하는 사람의 전화 횟수가 더 나중이면
			// 마지막으로 전화받은 사람과 전화 횟수를 갱신한다
			if (maxCount < current.count) {
				maxLastCall = current.node;
				maxCount = current.count;
			}
			// 전화 횟수는 같지만 탐색하는 사람의 번호가 더 크면 갱신한다
			else if (maxCount == current.count && maxLastCall < current.node) {
				maxLastCall = current.node;
			}
			
			// 탐색 중인 사람이 다음에 전화 걸 수 있는 사람들을 살펴본다
			for (int next : contact[current.node]) {			
				// 아직 전화를 건 적 없는 사람이면 다음 탐색을 위해 큐에 넣는다
				if (!called[next]) {
					queue.offer(new Duty(next, current.count + 1));
					called[next] = true;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		for (int tc = 1; tc <= TEST_CASE; tc++) {
			 st = new StringTokenizer(br.readLine().trim());
			 size = Integer.parseInt(st.nextToken());
			 int start = Integer.parseInt(st.nextToken());
			 
			 contact = new ArrayList[MAX_CONTACT + 1];
			 for (int idx = 1; idx <= MAX_CONTACT; idx++) {
		        	contact[idx] = new ArrayList<Integer>();
		        }
			 
			 st = new StringTokenizer(br.readLine().trim());
			 for (int idx = 0; idx < size / 2; idx++) {
				 int one = Integer.parseInt(st.nextToken());
				 int other = Integer.parseInt(st.nextToken());
				 
				 contact[one].add(other);
			 }
			 
			 call(start);
			 sb.append("#").append(tc).append(" ").append(maxLastCall).append("\n");
		}
		System.out.println(sb);
	}
}
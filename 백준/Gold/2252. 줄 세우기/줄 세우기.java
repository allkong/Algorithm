import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 학생의 수와 키를 비교한 횟수를 입력받는다.
 * 2. 두 학생(front, back)의 번호를 입력받는다.
 * 3. students 리스트의 front 인덱스에 back을 값으로 저장한다.
 *    3-1. back의 진입 차수를 1 증가시킨다.
 * 4. 진입 차수가 0인 학생들을 큐에 모두 넣는다.
 * 5. 현재 탐색하는 학생과 인접한 학생의 간선을 제거한다.
 *    5-1. 인접한 학생의 진입 차수도 1 감소시킨다.
 * 6. 간선 제거 후 진입 차수가 0이 된 학생을 큐에 넣는다
 * 7. 큐가 공백 상태가 될 때까지 5~6번을 반복한다.
 */
public class Main {	
    public static BufferedReader br;
    public static StringBuilder sb;
    public static StringTokenizer st;
    
    public static int studentCount; // 학생 수
    public static int compareCount; // 비교 횟수
    public static ArrayList<Integer>[] students; // 학생 리스트
    public static int[] studentDegree; // 학생 진입 차수
    public static Queue<Integer> queue;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        st = new StringTokenizer(br.readLine().trim());
        studentCount = Integer.parseInt(st.nextToken());
        compareCount = Integer.parseInt(st.nextToken());
        
        students = new ArrayList[studentCount + 1];
        studentDegree = new int[studentCount + 1];
        for (int idx = 1; idx <= studentCount; idx++) {
        	students[idx] = new ArrayList<Integer>();
        }
        
        for (int count = 0; count < compareCount; count++) {
        	st = new StringTokenizer(br.readLine().toLowerCase());
        	int front = Integer.parseInt(st.nextToken()); // 앞에 오는 학생
        	int back = Integer.parseInt(st.nextToken()); // 뒤에 오는 학생
        	students[front].add(back); // front 학생 뒤에 back 학생 연결
        	studentDegree[back]++; // back 학생의 진입 차수 증가
        }
        
        queue = new ArrayDeque<>();
        
        // 진입 차수가 0인 학생을 큐에 모두 넣는다
        for (int idx = 1; idx <= studentCount; idx++) {
        	if (studentDegree[idx] == 0) {
        		queue.offer(idx);
        	}
        }

        while (!queue.isEmpty()) {
        	int current = queue.poll();
        	sb.append(current).append(" ");

        	for (int next : students[current]) {
        		// current와 인접한 간선을 제거한다
        		studentDegree[next]--;
        		
        		// 간선 제거 후 진입 차수가 0이 된 학생을 큐에 넣는다
        		if (studentDegree[next] == 0) {
        			queue.offer(next);
        		}
        	}
        }
        System.out.println(sb);
    }
}
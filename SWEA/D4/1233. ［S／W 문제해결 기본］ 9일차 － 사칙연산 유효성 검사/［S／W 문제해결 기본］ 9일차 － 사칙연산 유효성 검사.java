import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 10개의 테스트 케이스만큼 반복한다.
 * 2. 트리가 갖는 정점의 총 수를 입력받는다.
 * 3. 각 정점의 이웃한 숫자 또는 연산자, 자식 정점의 번호를 입력받는다.
 * 4. 정점이 리프 노드이면 무조건 숫자여야 하고, 리프 노드가 아니면 무조건 연산자여야 한다.
 *    4-1. 자식 노드가 있다면 리프 노드가 아니다.
 * 5. 계산하는 것이 아닌 리프 노드인지 아니지만 확인하면 되므로 bfs 탐색을 진행한다.
 * 6. 식이 유효하다면 1을, 유효하지 않다면 0을 출력한다.
 */
public class Solution {
    public static BufferedReader br;
    public static StringBuilder sb;
    public static StringTokenizer st;
    
    public static final int testCase = 10;
    public static int nodeCount; // 정점의 총 수
    public static int current; // 현재 노드
    public static char oper; // 연산자 혹은 피연산자
    public static int valid; // 유효성

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        for (int tc = 1; tc <= testCase; tc++) {
        	nodeCount = Integer.parseInt(br.readLine().trim());
        	valid = 1;
        	for (int node = 0; node < nodeCount; node++) {
        		st = new StringTokenizer(br.readLine().trim());
        		
        		current = Integer.parseInt(st.nextToken());
        		oper = st.nextToken().charAt(0);
        		
        		// current의 자식 노드가 존재한다면
        		if (current * 2 <= nodeCount) {
        			// 자식 노드가 존재하면 리프 노드가 아니므로
        			// 연산자인지 확인한다
        			if (oper == '+' || oper == '-' || oper == '*' || oper == '/') {
        				continue;
        			} else {
        				valid = 0;
        			}
        		} else {
        			// current의 자식 노드가 존재하지 않는다면
        			// 리프 노드이므로 피연산자(숫자)인지 확인한다
        			if (Character.isDigit(oper)) {
        				continue;
        			} else {
        				valid = 0;
        			}
        		}
        	}
        	sb.append("#").append(tc).append(" ").append(valid).append("\n");
        }
        System.out.println(sb);
    }
}
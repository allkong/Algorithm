import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 1. 테스트 케이스 10번 반복한다.
 * 2. 각 테스트 케이스의 번호를 입력받는다.
 * 3. 8개의 숫자를 입력받아 저장한다.
 *    3-1. 덱으로 구현한다.
 * 4. 카드 덱으로 한 사이클을 돌린다.
 * 	  4-1. 첫 번째 숫자를 삭제하고 1 감소하여 맨 뒤로 삽입한다.
 *    4-2. 다음 첫 번째 숫자를 삭제하고 2 감소하여 맨 뒤로 삽입한다.
 *    4-3. 5까지 수행한다.
 * 5 숫자가 0보다 작아질 때까지 4번의 한 사이클을 반복한다.
 *    6-1. 0보다 작아지는 경우 0으로 유지한다.
 */
public class Solution {
    public static BufferedReader br;
    public static StringBuilder sb;
    public static StringTokenizer st;
    
    public static final int testCase = 10;
    public static final int passwordLength = 8;
    
    public static Deque<Integer> deque;
    
    public static void runCycle() {    	
    	// 카드 덱으로 한 사이클을 돌린다
    	for (int subtract = 1; subtract <= 5; subtract++) {
    		int targetNum = deque.poll() - subtract;
    		
    		// 기저 조건
        	// 타겟 숫자가 0보다 작아지면 종료한다
    		if (targetNum <= 0) {
        		targetNum = 0;
        		deque.offerLast(targetNum);
        		return;
        	}
    		deque.offerLast(targetNum);
    	}
    	// 기저 조건에 해당하지 않으면 한 사이클을 더 돌린다
    	runCycle();
    }
   
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        // 테스트 케이스만큼 반복한다
        for (int tc = 1; tc <= testCase; tc++) {
        	br.readLine();
        	
        	// 숫자를 저장할 덱을 선언한다
        	deque = new ArrayDeque<>();
        	
        	// 8개의 숫자를 입력받아 저장한다
        	st = new StringTokenizer(br.readLine().trim());
            for (int idx = 0; idx < passwordLength; idx++) {
            	deque.offer(Integer.parseInt(st.nextToken()));
            }
            
            // 사이클을 돌린다
            runCycle();

            sb.append("#").append(tc).append(" ");
            for (int idx = 0; idx < passwordLength; idx++) {
            	sb.append(deque.poll()).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
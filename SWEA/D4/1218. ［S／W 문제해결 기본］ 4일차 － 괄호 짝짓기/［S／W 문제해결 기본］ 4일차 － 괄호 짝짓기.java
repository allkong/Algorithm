import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 1. 10개의 테스트 케이스만큼 반복한다.
 * 2. 괄호의 개수를 입력받는다.
 * 3. 괄호 문자열을 입력받고 하나씩 살펴본다.
 * 4. 여는 괄호이면 스택에 삽입한다.
 * 5. 닫는 괄호이면 스택의 top을 확인한다.
 *    5-1. top이 같은 종류의 여는 괄호라면 pop한다.
 *    5-2. 아니라면 닫는 괄호도 스택에 삽입한다.
 * 6. 모든 괄호를 4~5를 반복하여 살펴본다.
 * 7. 스택에 남아있는 괄호가 없다면 1을 출력하고 있다면 0을 출력한다.
 */
public class Solution {
    public static BufferedReader br;
    public static StringBuilder sb;
    
    public static final int testCase = 10; // 테스트 케이스
    
    public static int bracketSize; // 괄호의 개수
    public static String bracketString; // 괄호 문자열
    public static Stack<Character> stack;
    
    public static char checkBracket(char bracket) {
        // 같은 괄호 한 쌍인지 확인한다
    	switch (bracket) {
    	case ')':
    		return '(';
    	case ']':
    		return '[';
    	case '}':
    		return '{';
    	case '>':
    		return '<';
    	}
		return bracket;
    }
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        for (int tc = 1; tc <= testCase; tc++) {
        	bracketSize = Integer.parseInt(br.readLine().trim());
        	stack = new Stack<>();
        	
        	bracketString = br.readLine();
        	for (int idx = 0; idx < bracketSize; idx++) {
        		char bracket = bracketString.charAt(idx);
        		// 여는 괄호이면 스택에 삽입한다
        		if (bracket == '(' || bracket == '[' || bracket == '{' || bracket == '<') {
        			stack.push(bracket);
        		} else {
        			// 닫는 괄호이면 스택의 top을 확인한다
        			// top이 같은 종류의 여는 괄호라면 pop한다
        			if (stack.peek() == checkBracket(bracket)) {
        				stack.pop();
        			} else {
        				// 아니라면 닫는 괄호도 스택에 삽입한다
        				stack.push(bracket);
        			}
        		}
        	}
        	// 스택에 남아있는 괄호가 없다면 1을 출력하고 있다면 0을 출력한다
        	sb.append("#").append(tc).append(" ").append((stack.size() == 0) ? 1 : 0).append("\n");	
        }
        System.out.println(sb);
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 1. 10개의 테스트 케이스만큼 반복한다.
 * 2. 원본 암호문의 길이를 입력받는다.
 * 3. 원본 암호문을 입력받는다.
 *    3-1. 연결리스트로 선언하고 저장한다.
 * 4. 명령어의 개수를 입력받는다.
 * 5. 명령어의 개수만큼 반복한다.
 * 6. I(삽입), 삽입할 위치, 삽입할 개수, 덧붙일 숫자들을 입력받는다.
 * 7. 삽입 연산을 한다.
 *    7-1. 원본 암호문 연결 리스트의 index(삽입할 위치)에 덧붙일 숫자들을 추가한다.
 *    7-2. 삽입할 개수만큼 붙인다.
 */
public class Solution {
    public static BufferedReader br;
    public static StringBuilder sb;
    public static StringTokenizer st;
    
    public static final int testCase = 10;
    public static int ciphertextLength; // 원본 암호문의 길이
    public static LinkedList<String> ciphertext; // 원본 암호문
    public static int commandCount; // 명령어 개수
    public static String[] command; // 명령어
    public static int position; // 삽입 연산을 할 때 삽입할 위치
    public static int insertCount; // 삽입 연산을 할 때 삽입할 개수
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        for (int tc = 1; tc <= testCase; tc++) {
        	// 원본 암호문의 길이와 원본 암호문을 입력받는다
            // 원본 암호문은 연결리스트에 저장한다
            ciphertextLength = Integer.parseInt(br.readLine().trim());
            ciphertext = new LinkedList<>();
            st = new StringTokenizer(br.readLine().trim());
            for (int idx = 0; idx < ciphertextLength; idx++) {
            	ciphertext.add(st.nextToken());
            }
            
            // 명령어 개수와 명령어를 입력받는다
            commandCount = Integer.parseInt(br.readLine().trim());
            command = new String[commandCount];
            st = new StringTokenizer(br.readLine().trim());
            for (int idx = 0; idx < commandCount; idx++) {
            	// I가 나오면 삽입 연산을 시작한다
            	if (st.nextToken().equals("I")) {
            		position = Integer.parseInt(st.nextToken());
            		insertCount = Integer.parseInt(st.nextToken());
            		
            		// 원본 암호문 연결 리스트의 index(삽입할 위치)에 덧붙일 숫자들을 추가한다
            		for (int count = 0; count < insertCount; count++) {
            			ciphertext.add(position, st.nextToken());
            			position++;
            		}
            	}
            }
            sb.append("#").append(tc).append(" ");
            // 처음 10개 항만 출력한다
            for (int idx = 0; idx < 10; idx++) {
            	sb.append(ciphertext.removeFirst()).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
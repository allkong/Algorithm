import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
/**
 * 1. 10개의 테스트 케이스만큼 반복한다.
 * 2. 덤프 횟수를 입력받는다.
 * 3. 각 상자의 높이 값을 입력받는다. 
 *    3-1. 각 상자 높이 값을 저장할 배열을 선언한다.
 * 4. 상자 높이 배열을 정렬한다.
 * 5. 가장 마지막 박스에서 가장 첫 번째 박스로 덤프한다.
 *    5-1. 덤프 횟수를 감소시킨다.
 * 6. 마지막 박스와 첫 번째 박스의 높이 차이가 1 이하일 때까지 4~5를 반복한다.
 * 7. 만약 도중에 덤프 횟수가 0이 되면 멈추고 높이 차를 반환한다.
 */
public class Solution {
    public static BufferedReader br;
    public static StringBuilder sb;
    public static StringTokenizer st;
     
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
         
        int testCase = 10; // 테스트 케이스는 10으로 고정
         
        // 테스트 케이스만큼 반복한다
        for (int tc = 1; tc <= testCase; tc++) {
            int dump = Integer.parseInt(br.readLine().trim()); // 덤프 횟수
            int size = 100; // 가로 길이 고정
            int [] boxes = new int[size]; // 상자 높이 값을 담을 배열
             
            // 각 상자의 높이 값을 입력받아서 배열에 저장한다
            st = new StringTokenizer(br.readLine().trim());
            for (int idx = 0; idx < size; idx++) {
                boxes[idx] = Integer.parseInt(st.nextToken());
            }
             
            // 상자 높이 배열을 정렬한다
            Arrays.sort(boxes);
             
            while (dump > 0) {
                // 가장 마지막 박스에서 가장 첫 번째 박스로 덤프한다.
                boxes[size - 1] -= 1;
                boxes[0] += 1;          
                 
                // 덤프했으면 덤프 횟수를 감소시킨다.
                dump -= 1;
                 
                // 덤프했으니 다시 정렬한다.
                Arrays.sort(boxes);
            }
            sb.append("#").append(tc).append(" ").append(boxes[size - 1] - boxes[0]).append("\n");
        }
        System.out.println(sb); 
    }
}
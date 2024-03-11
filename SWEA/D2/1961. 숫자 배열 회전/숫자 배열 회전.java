import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 1. 테스트 케이스를 입력받는다.
 * 2. 배열의 사이즈를 입력받는다.
 * 3. 각 행의 자리를 기준으로 90도, 180도, 270도 회전한 모양을 출력한다.
 *    3-1. 먼저  배열 전체를 90도로 회전시킨다.
 *    3-2. 회전시킨 배열의 각 행을 결과 배열의 각 행에 저장한다.
 *    3-3. 180도, 270도도 마찬가지로 진행한다.
 *         3-3-1. 180도는 90도 회전시킨 배열을 90도로 한 번 더 회전시키고, 270도는 두 번 더 회전시킨다.
 */
public class Solution {
    public static BufferedReader br;
    public static StringBuilder sb;
    public static StringTokenizer st;
    
    public static int size; // 배열의 크기
    public static int[][] beginArr; // 처음 숫자 배열
    public static int[][] rotateArr; // 회전한 숫자 배열
    public static List<String>[] resultArr; // 90도 , 180도, 270도 회전한 모양을 저장하는 배열
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        int testCase = Integer.parseInt(br.readLine().trim());
        
        for (int tc = 1; tc <= testCase; tc++) {
            size = Integer.parseInt(br.readLine().trim());
            beginArr = new int[size][size];
            
            for (int row = 0; row < size; row++) {
                st = new StringTokenizer(br.readLine().trim());
                for (int col = 0; col < size; col++) {
                    beginArr[row][col] = Integer.parseInt(st.nextToken());
                }
            }
            
            // resultArr 배열 안에 LinkedList 선언
            resultArr = new List[size];
            for (int row = 0; row < size; row++) {
            	resultArr[row] = new LinkedList<String>();
            }
            
            // 3번 회전 (90도, 180도, 270도)
            for (int count = 0; count < 3; count++) {
            	// 배열을 90도로 한 번 회전시킨다
                rotateArr = new int[size][size]; // 회전한 배열을 저장할 배열
                for (int row = 0; row < size; row++) {
                    for (int col = 0; col < size; col++) {
                        rotateArr[row][col] = beginArr[size - 1 - col][row];
                    }
                }
                                
                // 각 회전시킨 모양을 resultArr에 저장한다
                for (int row = 0; row < size; row++) {
                	String strNum = "";
                    for (int col = 0; col < size; col++) {
                        strNum += String.valueOf(rotateArr[row][col]);
                    }
                    resultArr[row].add(strNum);
                }
                
                // 또 회전시키기 위해 시작 배열을 회전시킨 배열로 갱신한다
                beginArr = rotateArr;
            }
            
            // 출력
            sb.append("#").append(tc).append("\n");
            for (int row = 0; row < size; row++) {
                for (int col = 0; col < 3; col++) {
                	sb.append(resultArr[row].get(col)).append(" ");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}
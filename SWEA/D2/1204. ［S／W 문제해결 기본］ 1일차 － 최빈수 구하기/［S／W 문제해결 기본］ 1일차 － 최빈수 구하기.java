import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 1점부터 100점까지의 횟수를 저장하는 배열을 선언한다.
 * 2. 1000명의 수학 성적을 입력받는다.
 * 3. 성적 배열에서 입력받은 성적을 인덱스로 하는 값에 +1 해준다.
 * 4. 모두 입력받은 후, 반복문을 돌려서 배열에서 가장 큰 값의 인덱스를 출력한다.
 *    4-1. 최빈수가 여러 개라면 가장 큰 점수를 출력한다.
 */
public class Solution {
	public static BufferedReader br;
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static final int COUNT = 1000; // 학생 수
	public static int mode; // 최빈수
	public static int[] grades; // 학생들의 성적(index가 성적)
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		int testCase = Integer.parseInt(br.readLine().trim());
		
		for (int tc = 1; tc <= testCase; tc++) {
			br.readLine();
			
			mode = 0;
			grades = new int[COUNT + 1];
			
			st = new StringTokenizer(br.readLine().trim());
			for (int idx = 1; idx <= COUNT; idx++) {
				int studentGrade = Integer.parseInt(st.nextToken());
				grades[studentGrade]++;
			}
			
			for (int idx = 1; idx <= COUNT; idx++) {
				// 최빈수를 찾는다
				// 최빈수가 여러 개라면 가장 큰 점수를 저장한다 (앞에서부터 살펴보므로 무조건 idx가 더 크다)
				if (grades[mode] <= grades[idx]) {
					mode = idx;
				}
			}
			
			sb.append("#").append(tc).append(" ").append(mode).append("\n");
		}
		System.out.println(sb);
	}
}
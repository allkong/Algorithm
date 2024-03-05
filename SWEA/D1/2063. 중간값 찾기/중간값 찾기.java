import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 1. 여러 숫자들을 입력받아 리스트에 저장한다.
 * 2. 숫자 리스트를 정렬한다.
 * 3. 정렬한 리스트의 가운데 값(index: size/2)을 출력한다.
 */
public class Solution {
	public static BufferedReader br;
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		int size = Integer.parseInt(br.readLine().trim());
		ArrayList<Integer> nums = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine().trim());
		for (int idx = 0; idx < size; idx++) {
			nums.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(nums); // 리스트 정렬
		
		System.out.println(nums.get(size / 2));
	}
}

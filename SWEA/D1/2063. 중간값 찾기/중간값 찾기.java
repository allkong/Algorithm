import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

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
		
		Collections.sort(nums);
		
		System.out.println(nums.get(size / 2));
	}
}
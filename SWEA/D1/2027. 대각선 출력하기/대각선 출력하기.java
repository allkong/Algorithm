public class Solution {
	public static StringBuilder sb;
	
	public static void main(String[] args) {
		for (int idx = 0; idx < 5; idx++) {
			sb = new StringBuilder();
			
			sb.append("++++");
			sb.insert(idx, '#');
			
			System.out.println(sb);
		}
	}
}
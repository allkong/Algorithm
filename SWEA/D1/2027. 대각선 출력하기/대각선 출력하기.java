public class Solution {
	public static void main(String[] args) {
		for (int idx = 0; idx < 5; idx++) {
			StringBuffer sb = new StringBuffer();
			
			sb.append("++++");
			sb.insert(idx, "#");
			
			System.out.println(sb);
		}
	}
}
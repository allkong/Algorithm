/**
 * 1. StringBuilder에 "++++"를 넣는다.
 * 2. 반복문을 활용해 StringBuilder 중간에 '#'을 삽입한다.
 *    2-1. 반복문 index를 통해 삽입할 위치를 정한다.
 */
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

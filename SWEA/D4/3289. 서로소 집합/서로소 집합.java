import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 테스트 케이스를 입력받는다.
 * 2. 초기 집합의 개수, 연산의 개수를 입력받는다.
 * 3. 연산을 입력받는다.
 *    3-1. 0 a b: 두 집합을 합친다. (union)
 *    3-2. 1 a b: 두 원소가 같은 집합에 포함되어 있는지 확인한다. (find)
 * 4. union: 랭크가 더 높은 집합에 랭크가 더 낮은 집합을 붙인다.
 * 5. find: 두 원소의 부모가 같은지 확인한다.
 */
public class Solution {
	public static BufferedReader br;
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static int elementCount; // 원소의 개수
	public static int operationCount; // 연산의 개수
	public static int[] parentList;
	public static int[] rankList;
	
	public static final int UNION = 0;
	public static final int FIND = 1;
	
	public static void union(int one, int other) {
		int oneParent = find(one);
		int otherParent = find(other);
		
		if (oneParent == otherParent) {
			return;
		}
		
		if (rankList[oneParent] > rankList[otherParent]) {
			parentList[otherParent] = oneParent;
			return;
		}
		
		parentList[oneParent] = otherParent;
		
		if (rankList[oneParent] == rankList[otherParent]) {
			rankList[otherParent]++;
		}
	}
	
	public static int find(int one) {
		if (parentList[one] == one) {
			return one;
		}
		
		return parentList[one] = find(parentList[one]);
	}
	
	public static void make() {
		parentList = new int[elementCount + 1];
		rankList = new int[elementCount + 1];
		
		for (int idx = 0; idx < elementCount + 1; idx++) {
			parentList[idx] = idx;
			rankList[idx] = 0;
		}
	}
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		int testCase = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= testCase; tc++) {
			st = new StringTokenizer(br.readLine().trim());
			elementCount = Integer.parseInt(st.nextToken());
			operationCount = Integer.parseInt(st.nextToken());
			
			make();
			
			sb.append("#").append(tc).append(" ");
			for (int count = 0; count < operationCount; count++) {
				st = new StringTokenizer(br.readLine().trim());
				int operationType = Integer.parseInt(st.nextToken()); // 연산 종류
				int one = Integer.parseInt(st.nextToken()); // 요소 1
				int other = Integer.parseInt(st.nextToken()); // 요소 2
				
				if (operationType == UNION) {
					union(one, other);
				} else if (operationType == FIND) {
					// 두 원소의 부모가 같다면 같은 집합에 속하는 것이다
					if (find(one) == find(other)) {
						sb.append(1);
					} else {
						sb.append(0);
					}
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
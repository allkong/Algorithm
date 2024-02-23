import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 서로소 집합을 이용해 크루스칼 알고리즘으로 구현한다.
 */
public class Solution {
	public static BufferedReader br;
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static int islandCount; // 섬(정점)의 개수
	public static int edgeCount; // 해저터널(간선)의 개수
	public static double taxRate; // 해저터널 건설의 환경 부담 세율
	public static int[] islandPositionX;
	public static int[] islandPositionY;
	public static ArrayList<Edge> edgeList; // 간선의 정보
	public static int[] parents; // 부모 정보
	public static int[] ranks; // 랭크 정보
	
	public static class Edge implements Comparable<Edge> {
		int from;
		int to;
		double weight;
		
		public Edge(int from, int to, double weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
		// 간선의 가중치가 낮은 순으로 정렬한다
		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.weight, o.weight);
		}
	}
	
	public static boolean union(int element1, int element2) {
		int e1Parent = find(element1);
		int e2Parent = find(element2);
		
		// 이미 같은 집합이다
		if (e1Parent == e2Parent) {
			return false;
		}
		
		// 두 집합의 랭크가 다른 경우
		// e1Parent의 랭크가 더 높다
		if (ranks[e1Parent] > ranks[e2Parent]) {
			parents[e2Parent] = e1Parent;
			return true;
		}
		
		// e2Parent의 랭크가 더 높다
		parents[e1Parent] = e2Parent;
		
		// 두 집합의 랭크가 같은 경우
		if (ranks[e1Parent] == ranks[e2Parent]) {
			ranks[e2Parent]++;
		}
		return true;
	}
	
	public static int find(int element) {
		// 자신이 부모일 때는 그대로 반환
		if (element == parents[element]) {
			return element;
		}
		
		return parents[element] = find(parents[element]); // 부모를 찾아서 갱신
	}
	
	public static void makeSet() {
		parents = new int[islandCount + 1];
		ranks = new int[islandCount + 1];
		
		// 자신을 부모로 설정
		for (int idx = 1; idx < islandCount + 1; idx++) {
			parents[idx] = idx;
			ranks[idx] = 0;
		}
	}
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		int testCase = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= testCase; tc++) {
			islandCount = Integer.parseInt(br.readLine().trim());
			
			edgeCount = islandCount * (islandCount - 1) / 2;
			islandPositionX = new int[islandCount];
			islandPositionY = new int[islandCount];
			edgeList = new ArrayList<>();
			
			// 섬들의 X 좌표 저장
			st = new StringTokenizer(br.readLine().trim());
			for (int islandIdx = 0; islandIdx < islandCount; islandIdx++) {
				islandPositionX[islandIdx] = Integer.parseInt(st.nextToken());
			}
			
			// 섬들의 Y 좌표 저장
			st = new StringTokenizer(br.readLine().trim());
			for (int islandIdx = 0; islandIdx < islandCount; islandIdx++) {
				islandPositionY[islandIdx] = Integer.parseInt(st.nextToken());
			}
			
			taxRate = Double.parseDouble(br.readLine().trim());
			
			for (int island1 = 0; island1 < islandCount - 1; island1++) {
				for (int island2 = island1 + 1; island2 < islandCount; island2++) {
					// 터널의 길이 구하기
					double tunnel = Math.pow(islandPositionX[island1] - islandPositionX[island2], 2) + Math.pow(islandPositionY[island1] - islandPositionY[island2], 2);
					double weight = taxRate * tunnel;
					edgeList.add(new Edge(island1, island2, weight));
				}
			}
			
			// 간선 리스트 오름차순 정렬
			Collections.sort(edgeList);
			
			makeSet();
			
			// 간선을 하나씩 꺼내서 신장 트리를 생성한다
			double totalWeight = 0;
			int count = 0;
			
			for (Edge edge: edgeList) {
				// 이미 같은 집합이므로 간선을 추가하면 사이클이 발생하게 된다 
				if (!union(edge.from, edge.to)) {
					continue;
				}
				
				// 추가할 간선의 가중치를 더한다
				totalWeight += edge.weight;
				count++;
				
				// 최소 신장 트리가 완성되면 종료한다
				if (count == islandCount - 1) {
					break;
				}
			}
			
			sb.append("#").append(tc).append(" ").append(Math.round(totalWeight)).append("\n");
		}
		System.out.println(sb);
	}
}
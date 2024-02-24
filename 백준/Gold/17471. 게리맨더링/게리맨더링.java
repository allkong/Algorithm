import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 각 구역에 연결된 구역들을 저장하는 구역 그래프를 만든다.
 * 2. 부분집합을 활용해 구역들을 두 집합으로 나눈다.
 *    2-1. selected 배열을 활용해 방문 처리가 true인 집합과 false인 집합으로 나눈다.
 * 3. 두 집합이 가능한 방법인지 확인한다.
 *    3-1. 한 집합 내에 연결되어 있지 않은 구역이 있다면 불가능한 방법이다.
 * 4. 두 집합의 인구 수와 그 차를 구해서 인구 차이의 최솟값을 저장한다.
 */
public class Main {
    public static BufferedReader br;
    public static StringTokenizer st;
    
    public static int areaCount; // 구역 개수
    public static int minPopulationDiff; // 두 집합의 인구 차이 최솟값
    
    public static int[] population; // 각 구역의 인구 수
    public static int[][] adjacentArea; // 각 구역과 인접한 구역들 저장
    public static boolean[] selected; // 부분집합을 뽑을 때 방문(선택) 처리하는 배열
    public static boolean[] visited; // 한 집합 내 모든 구역이 인접한지 확인할 때 방문 처리하는 배열
    
    /** 두 집합의 인구 수와 구해서 차를 계산하는 메소드 */
    public static void getPopulationDiff () {
    	int trueSetPopulation = 0; // selected 배열에서 true인 집합의 인구 수
    	int falseSetPopulation = 0; // selected 배열에서 false인 집합의 인구 수
    	
    	for (int idx = 0; idx < areaCount; idx++) {
    		if (selected[idx]) {
    			trueSetPopulation += population[idx];
    		} else {
    			falseSetPopulation += population[idx];
    		}
    	}
    	
    	minPopulationDiff = Math.min(minPopulationDiff, Math.abs(trueSetPopulation - falseSetPopulation));
    }
    
    /** 한 집합 내에 모든 구역이 인접한지 확인하는 메소드 */
    public static boolean isAdjacent(List<Integer> areaSet) {
    	Queue<Integer> queue = new ArrayDeque<>();
    	visited = new boolean[areaCount];
    	
    	queue.offer(areaSet.get(0));
    	visited[areaSet.get(0)] = true;
    	int searchCount = 1;
    	
    	while (!queue.isEmpty()) {
    		int current = queue.poll();
    		
    		// 현재 구역과 인접한 구역들을 살펴본다
    		for (int next : adjacentArea[current]) {
    			// 인접한 구역이 같은 집합에 속하는 구역이면 계속 탐색한다
    			if (areaSet.contains(next) && !visited[next]) {
    				queue.offer(next);
    				visited[next] = true;
    				searchCount++;
    			}
    		}
    	}
    	
    	// 현재 집합에 있는 구역들을 모두 탐색했다면 가능한 방법이다
    	if (searchCount == areaSet.size()) {
    		return true;
    	}
    	return false;    	
    }
    
    /** 구역들을 두 집합으로 나누기 위한 메소드 */
    public static void selectArea(int selectIdx) {
    	// 다 선택했다면 두 집합이 가능한 방법인지 확인한다
    	if (selectIdx == areaCount) {
    		List<Integer> trueSet = new LinkedList<>(); // selected 배열에서 true인 구역들의 집합
    		List<Integer> falseSet = new LinkedList<>(); // selected 배열에서 false인 구역들의 집합
    		
    		for (int idx = 0; idx < areaCount; idx++) {
    			// 선택 정보가 true인 구역들과 false인 구역들로 나눈다
    			if (selected[idx]) {
    				trueSet.add(idx);
    			} else {
    				falseSet.add(idx);
    			}
    		}
    		
    		// 각 선거구(집합)는 적어도 하나의 구역을 포함해야 하므로
    		// 두 집합 중 구역이 하나도 포함되어 있지 않은 집합이 있다면 돌아간다
    		if (trueSet.size() == 0 || falseSet.size() == 0) {
    			return;
    		}
    		
    		// 두 집합이 가능한 방법인지 확인한다
    		if (isAdjacent(trueSet) && isAdjacent(falseSet)) {
    			// 두 집합의 인구 수를 구한다
    			getPopulationDiff();
    		}
    			
    		return;
    	}
    	
    	selected[selectIdx] = true;
    	selectArea(selectIdx + 1);
    	
    	selected[selectIdx] = false;
    	selectArea(selectIdx + 1);
    }
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        
        areaCount = Integer.parseInt(br.readLine().trim());
        population = new int[areaCount];
        
        // 각 구역의 인구 수를 배열에 저장
        st = new StringTokenizer(br.readLine().trim());
        for (int idx = 0; idx < areaCount; idx++) {
        	population[idx] = Integer.parseInt(st.nextToken());
        }
        
        // 각 구역과 인접한 구역들을 저장하는 그래프를 생성
        adjacentArea = new int[areaCount][];
        for (int areaIdx = 0; areaIdx < areaCount; areaIdx++) {
        	st = new StringTokenizer(br.readLine().trim());
        	int adjacentCount = Integer.parseInt(st.nextToken());
        	
        	adjacentArea[areaIdx] = new int[adjacentCount];
        	for (int adjacentIdx = 0; adjacentIdx < adjacentCount; adjacentIdx++) {
        		adjacentArea[areaIdx][adjacentIdx] = Integer.parseInt(st.nextToken()) - 1;
        	}
        }
        
        selected = new boolean[areaCount];
        minPopulationDiff = Integer.MAX_VALUE;
        
        // 구역들을 둘로 나누기 위한 메소드 호출
        selectArea(0);
        
        System.out.println(minPopulationDiff == Integer.MAX_VALUE? -1 : minPopulationDiff);
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;
    
    static final int maxDistance = 1000; // 한 번에 이동할 수 있는 거리
    static int storeCount; // 편의점 개수
    static Point house; // 상근이네 집 좌표
    static Point festival; // 락 페스티벌 좌표
    static Point[] stores; // 편의점 좌표
    
    static class Point {
    	int row, col;
    	
    	public Point(int row, int col) {
    		this.row = row;
    		this.col = col;
    	}
    }
    
    /* 집에서 페스티벌로 갈 수 있는지 확인하는 메소드 */
    static boolean goFestival() {
    	Queue<Point> queue = new ArrayDeque<>();
    	queue.add(house); // 집에서 출발한다
    	boolean[] visited = new boolean[storeCount]; 
    	
    	while (!queue.isEmpty()) {
    		Point current = queue.poll();
    		
    		// 현재 위치에서 페스티벌까지의 거리가 1000m 이하이면 페스티벌로 이동한다
    		if (Math.abs(current.row - festival.row) + Math.abs(current.col - festival.col) <= maxDistance) {
    			return true;
    		}
    		
    		for (int idx = 0; idx < storeCount; idx++) {
    			// 이미 방문했던 편의점이면 지나친다
    			if (visited[idx]) {
    				continue;
    			}
    			
    			// 현재 위치에서 편의점까지의 거리가 1000m 이하이면 편의점으로 이동할 수 있다
    			if (Math.abs(current.row - stores[idx].row) + Math.abs(current.col - stores[idx].col) <= maxDistance) {
        			// 다음 탐색을 위해 큐에 넣는다
    				queue.offer(new Point(stores[idx].row, stores[idx].col));
        			// 현재 방문한 편의점을 방문 체크한다
    				visited[idx] = true;
        		}
    		}
    	}
    
    	return false;
    }
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        int testCase = Integer.parseInt(br.readLine().trim());
        
        for (int tc = 0; tc < testCase; tc++) {
        	storeCount = Integer.parseInt(br.readLine().trim());
        	stores = new Point[storeCount];
        	
        	st = new StringTokenizer(br.readLine().trim());
        	int x, y;
        	x = Integer.parseInt(st.nextToken());
        	y = Integer.parseInt(st.nextToken());
        	
        	house = new Point(x, y);
        	
        	for (int idx = 0; idx < storeCount; idx++) {
        		st = new StringTokenizer(br.readLine().trim());
        		x = Integer.parseInt(st.nextToken());
            	y = Integer.parseInt(st.nextToken());
            	
            	Point store = new Point(x, y);
            	stores[idx] = store;
        	}
        	
        	st = new StringTokenizer(br.readLine().trim());
    		x = Integer.parseInt(st.nextToken());
        	y = Integer.parseInt(st.nextToken());
        	
        	festival = new Point(x, y);
        	
        	if (goFestival()) {
        		sb.append("happy\n");
        	} else {
        		sb.append("sad\n");
        	}
        }
        System.out.println(sb);
    }
}
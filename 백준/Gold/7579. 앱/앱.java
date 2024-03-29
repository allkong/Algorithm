import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br;
    
    static final int MEMORY = 0;
    static final int COST = 1;
    
    static int appCount; // 앱 개수
    static int minMemory; // 확보해야 하는 최소 메모리
    static int[][] app; // 앱 배열
    static int memories[][]; // dp 배열
    
    /* 모든 앱을 비활성화 했을 경우인 최대 비용을 구하는 메소드 */
    static int getTotalCost() {
    	int total = 0;
    	for (int idx = 1; idx <= appCount; idx++) {
    		total += app[idx][COST];
    	}
    	return total;
    }
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        
        appCount = Integer.parseInt(st.nextToken());
        minMemory = Integer.parseInt(st.nextToken());
        app = new int[appCount + 1][2];
        
        StringTokenizer st1 = new StringTokenizer(br.readLine().trim());
        StringTokenizer st2 = new StringTokenizer(br.readLine().trim());
        for (int idx = 1; idx <= appCount; idx++) {
        	app[idx][MEMORY] = Integer.parseInt(st1.nextToken());
        	app[idx][COST] = Integer.parseInt(st2.nextToken());
        }
        
        int costSize = getTotalCost();
        memories = new int[appCount + 1][costSize + 1];
        
        // 앱을 하나씩 살펴보면서 탐색한다
        for (int idx = 1; idx <= appCount; idx++) {
        	// 비용을 1씩 늘리면서 계산한다
        	for (int cost = 0; cost <= costSize; cost++) {
        		// app[idx]의 비용이 cost보다 작거나 같다면 현재 앱을 비활성화하기 전의 메모리와
        		// 이전 앱은 활성화하고 현재 앱을 비활성화했을 때의 메모리 중 더 큰 값을 저장한다
            	if (app[idx][COST] <= cost) {
            		memories[idx][cost] = Math.max(memories[idx - 1][cost], memories[idx - 1][cost - app[idx][COST]] + app[idx][MEMORY]);
            	} else {
            		// app[idx]의 비용이 cost보다 크다면 이전 값을 그대로 가져간다
            		memories[idx][cost] = memories[idx - 1][cost];
            	}
            }
        }
        
        // 마지막 앱까지 탐색한 결과 중에 확보해야 하는 메모리를 넘은 최소 비용을 찾는다
        for (int costIdx = 0; costIdx <= costSize; costIdx++) {
        	if (memories[appCount][costIdx] >= minMemory) {
        		System.out.println(costIdx);
        		break;
        	}
        }
    }    
}
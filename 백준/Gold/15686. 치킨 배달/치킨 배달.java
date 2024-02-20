import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 1. 배열의 크기와 선택할 치킨집의 개수를 입력받는다.
 * 2. 도시의 정보를 입력받는다.
 *    2-1. 치킨집의 좌표를 따로 저장한다.
 *    2-1. 집의 자표를 따로 저장한다.
 * 3. 치킨집의 개수만큼 치킨집을 탐색한다.
 * 4. 도시의 치킨 거리를 구한다.
 *    4-1. 한 집에서 여러 치킨집의 거리를 계산하여 가장 짧은 거리를 저장한다.
 */
public class Main {
    public static BufferedReader br;
    public static StringTokenizer st;
    
    public static int size; // 배열의 크기
    public static int chickenCount; // 선택할 치킨집의 개수
    public static int houseRow, houseCol, chickenRow, chickenCol; // 집의 좌표, 치킨집의 좌표
    public static int distance, minDistance; // 집에서 치킨집까지의 거리, 집에서 가장 가까운 치킨집과의 거리
    public static int totalDistance, minTotalDistance; // 도시의 치킨 거리, 도시의 치킨 거리의 최솟값
    
    public static int[][] city;
    public static List<int[]> chickenPosition; // 치킨집 좌표 저장
    public static List<int[]> housePosition; // 집 좌표 저장
    public static int[] chickenList; // 선택한 치킨을 저장
    
    public static void calculateDistance() {
    	// 한 집에서 여러 치킨집들과의 거리를 계산한다
    	totalDistance = 0;
    	
    	for (int houseIdx = 0; houseIdx < housePosition.size(); houseIdx++) {
    		houseRow = housePosition.get(houseIdx)[0];
    		houseCol = housePosition.get(houseIdx)[1];
    		
    		minDistance = (size - 1) * 2;
    		
    		for (int chickenIdx = 0; chickenIdx < chickenCount; chickenIdx++) {
    			chickenRow = chickenPosition.get(chickenList[chickenIdx])[0];
    			chickenCol = chickenPosition.get(chickenList[chickenIdx])[1];
    			
    			// 집에서 치킨집까지의 거리 계산
    			distance = Math.abs(houseRow - chickenRow) + Math.abs(houseCol - chickenCol);
    			minDistance = Math.min(minDistance, distance);
    		}
    		totalDistance += minDistance;
    	}
    }
    
    public static void selectChicken(int selectIdx, int chickenIdx) {     
        // 치킨집을 모두 선택하면 거리를 구한다
        if (selectIdx == chickenCount) {
        	calculateDistance();
        	minTotalDistance = Math.min(minTotalDistance, totalDistance);
            return;
        }
        
        // 모든 치킨집을 살펴보면 종료한다
        if (chickenIdx == chickenPosition.size()) {
        	return;
        }
        
        chickenList[selectIdx] = chickenIdx;
        selectChicken(selectIdx + 1, chickenIdx + 1);
        chickenList[selectIdx] = 0;
        selectChicken(selectIdx, chickenIdx + 1);
    }
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        
        st = new StringTokenizer(br.readLine().trim());
        size = Integer.parseInt(st.nextToken());
        chickenCount = Integer.parseInt(st.nextToken());
        
        city = new int[size][size];
        housePosition = new LinkedList<>();
        chickenPosition = new LinkedList<>();
        chickenList = new int[chickenCount];
        minTotalDistance = Integer.MAX_VALUE;
        
        for (int row = 0; row < size; row++) {
            st = new StringTokenizer(br.readLine().trim());
            for (int col = 0; col < size; col++) {
                city[row][col] = Integer.parseInt(st.nextToken());
                
                // 집이거나 치킨집이면 좌표 저장
                if (city[row][col] == 1) { // 집
                    housePosition.add(new int[] {row, col});
                } else if (city[row][col] == 2) { // 치킨집
                    chickenPosition.add(new int[] {row, col});
                }
            }
        }
        // 도시의 치킨 거리가 최소가 되로록 하는 치킨집을 선택한다
        selectChicken(0, 0);
        
        System.out.println(minTotalDistance);
    }
}
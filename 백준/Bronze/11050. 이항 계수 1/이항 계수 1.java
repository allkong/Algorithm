import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 조합
public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    
    static int elementCount; // 전체 원소 개수, nCr의 n
    static int selectCount; // 선택할 원소의 개수, nCr의 r
    static int result;
    
    public static void combination(int selectIdx, int elementIdx) {
    	// 다 선택했다
    	if (selectIdx == selectCount) {
    		result++;
    		return;
    	}
    	
    	// 모든 원소를 다 살펴봤다
    	if (elementIdx == elementCount) {
    		return;
    	}
    	
    	combination(selectIdx + 1, elementIdx + 1);
    	combination(selectIdx, elementIdx + 1);
    }
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        
        st = new StringTokenizer(br.readLine().trim());
        
        elementCount = Integer.parseInt(st.nextToken());
        selectCount = Integer.parseInt(st.nextToken());
        result = 0;
        
        combination(0, 0);
        System.out.println(result);
    }
}
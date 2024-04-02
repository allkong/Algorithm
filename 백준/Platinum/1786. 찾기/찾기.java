import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;
    
    static String text; // 원본 문자열
    static String pattern; // 찾아야 하는 문자열
    static int pi[]; // 패턴 부분 일치 배열
    static List<Integer> patternAppearPosition; // 패턴이 등장한 위치 저장
    
    /* 패턴의 부분 일치 테이블 배열을 구하는 메소드 */
    static void getPI() {
    	// 패턴 길이의 1차원 배열 생성
    	pi = new int[pattern.length()];
    	
    	// pointer: 패턴에서 현재 비교 중인 문자 위치 (접두사)
    	// index: 패턴에서 현재 비교 중인 문자 위치 (접미사)
    	int pointer = 0;
    	
    	// 패턴의 길이를 하나씩 늘리면서 pi 계산
    	for (int index = 1; index < pattern.length(); index++) {
    		// 접두사와 접미사가 일치하지 않으면 포인터의 좌표를 이전 pi 값으로 바꾼다.
    		while (pointer > 0 && pattern.charAt(pointer) != pattern.charAt(index)) {
    			pointer = pi[pointer - 1];
    		}
    		
    		// 두 문자가 같다면 접두사와 접미사가 일치하는 길이가 증가한다
    		if (pattern.charAt(pointer) == pattern.charAt(index)){
    			// 이전 pi 값에서 1 증가시켜 저장한다
    			pi[index] = ++pointer;
    		}
    	}
    }
    
    /* 문자열에서 패턴을 찾는 메소드 */
    static void search() {
    	// patternIdx: 패턴에서 현재 비교 중인 문자 위치
    	// textIdx: 텍스트에서 현재 비교 중인 문자 위치
    	int patternIdx = 0;
    	for (int textIdx = 0; textIdx < text.length(); textIdx++) {
    		
    		// 두 문자가 일치하지 않는다면 패턴의 비교 위치를 옮긴다
    		while (patternIdx > 0 && text.charAt(textIdx) != pattern.charAt(patternIdx)) {
    			patternIdx = pi[patternIdx - 1];
    		}
    		
    		// 두 문자가 같다면 문자열이 다 같은지 이어서 비교해야 한다
    		if (text.charAt(textIdx) == pattern.charAt(patternIdx)) {
    			// 만약 패턴의 길이만큼 비교했다면, 텍스트에서 패턴을 찾은 것이다
    			if (patternIdx == pattern.length() - 1) {
    				// 패턴이 텍스트에서 등장한 좌표를 담는다
    				patternAppearPosition.add(textIdx - pattern.length() + 1);
        			
        			// pi 배열을 활용해 현재 위치(접미사)와 일치하는 접두사로 위치를 옮긴다
        			patternIdx = pi[patternIdx];
    			} else {
    				// 이어서 탐색한다
    				patternIdx++;
    			}    			
    		}
    	}
    }
    
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        text = br.readLine();
        pattern = br.readLine();
        patternAppearPosition = new ArrayList<>();
        
        getPI();
        search();
        
        sb.append(patternAppearPosition.size()).append("\n");
        
        for (int position : patternAppearPosition) {
        	sb.append(position + 1).append(" ");
        }
        
        System.out.println(sb);
	}
}

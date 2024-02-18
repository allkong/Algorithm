import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 테스트 케이스를 입력받는다.
 * 2. 게임 맵의 높이와 너비를 입력받는다.
 * 3. 게임 맵 2차원 배열을 입력받는다.
 *    3-1. 전차의 위치와 방향을 따로 저장한다.
 * 4. 사용자가 넣을 입력의 개수를 입력받는다.
 * 5. 명령어 문자열을 입력받고 하나씩 확인한다.
 * 6. 명령어가 U이면, 전차의 현재 방향을 위로 바꾸고, 위 칸이 평지면 이동한다.
 * 7. 명령어가 D이면, 전차의 현재 방향을 아래로 바꾸고, 아래 칸이 평지면 이동한다.
 * 8. 명령어가 L이면, 전차의 현재 방향을 왼쪽으로 바꾸고, 왼쪽 칸이 평지면 이동한다.
 * 9. 명령어가 R이면, 전차의 현재 방향을 위쪽으로 바꾸고, 오른쪽 칸이 평지면 이동한다.
 * 10. 명령어가 S이면, 전차의 현재 방향으로 포탄을 발사한다.
 *     10-1. 포탄이 벽돌로 만들어진 벽을 만나면 벽이 파괴된다.
 *     10-2. 포탄이 강철로 만들어진 벽을 만나면 아무 일도 일어나지 않는다.
 *     10-3. 포탄이 맵 밖으로 나가면 아무 일도 일어나지 않는다.
 */
public class Solution {
    public static BufferedReader br;
    public static StringBuilder sb;
    public static StringTokenizer st;
    
    public static final int[] deltaRow = {-1, 1, 0, 0}; // 상하좌우
    public static final int[] deltaCol = {0, 0, -1, 1};
    public static final char[] direction = {'^', 'v', '<', '>'};
    
    public static int rowSize; // 게임 맵의 높이
    public static int colSize; // 게임 맵의 너비
    public static char[][] gameMap; // 게임 맵
    public static int trainRow; // 전차 위치 행
    public static int trainCol; // 전차 위치 열
    public static int trainDirection; // 전차 방향 (0: 상, 1: 하, 2: 좌, 3: 우) 
    public static int commandCount; // 명령어 수
    public static String commandLine; // 명령어 문자열
    public static char command; // 명령어
    
    public static int nextRow, nextCol;
    
    public static void moveTrain(int nextRow, int nextCol) {
    	gameMap[trainRow][trainCol] = direction[trainDirection];
    	
    	// 이동할 다음 위치가 게임 맵 범위 안인지 확인한다
    	if (nextRow < 0 || nextCol < 0 || nextRow >= rowSize || nextCol >= colSize) {
    		return;
    	}
    	
    	// 이동할 다음 위치가 평지라면 현재 위치를 평지로 바꾸고 전차는 다음 위치로 이동시킨다
    	if (gameMap[nextRow][nextCol] == '.') {
    		gameMap[trainRow][trainCol] = '.';
    		gameMap[nextRow][nextCol] = direction[trainDirection];
    		trainRow = nextRow;
    		trainCol = nextCol;
    	}
    }
    
    public static void executeCommand(char command) {
        if (command == 'U') {
            // 전차의 방향을 위로 바꾼다
            trainDirection = 0;
            // 위 칸이 게임 맵의 범위 안이고 평지면 이동한다
            moveTrain(trainRow - 1, trainCol);
        } else if (command == 'D') {
            // 전차의 방향을 아래로 바꾼다
            trainDirection = 1;
            // 아래 칸이 게임 맵의 범위 안이고 평지면 이동한다
            moveTrain(trainRow + 1, trainCol);
        } else if (command == 'L') {
            // 전차의 방향을 왼쪽으로 바꾼다
            trainDirection = 2;
            // 왼쪽 칸이 게임 맵의 범위 안이고 평지면 이동한다
            moveTrain(trainRow, trainCol - 1);
        } else if (command == 'R') {
            // 전차의 방향을 오른쪽로 바꾼다
            trainDirection = 3;
            // 위 칸이 게임 맵의 범위 안이고 평지면 이동한다
            moveTrain(trainRow, trainCol + 1);
        } else if (command == 'S') {
            // 전차의 현재 방향으로 포탄을 발사한다
            nextRow = trainRow;
            nextCol = trainCol;
            
            while (true) {
            	nextRow += deltaRow[trainDirection];
            	nextCol += deltaCol[trainDirection];
            	
            	// 전차가 게임 맵 밖으로 나가거나 강철로 만들어진 벽에 부딪히면 포탄은 소멸한다
            	if (nextRow < 0 || nextCol < 0 || nextRow >= rowSize || nextCol >= colSize || gameMap[nextRow][nextCol] == '#') {
            		break;
            	}
            	
            	// 전차가 벽돌 벽과 부딪히면 벽이 파괴되어 평지가 된다
            	if (gameMap[nextRow][nextCol] == '*') {
            		gameMap[nextRow][nextCol] = '.';
            		break;
            	}
            }
        }
    }

    public static boolean isTrain(char gameElement) {
        // 전차이면 전차의 방향을 저장한다
        switch (gameElement) {
            case '^':
                trainDirection = 0;
                break;
            case 'v':
                trainDirection = 1;
                break;
            case '<':
                trainDirection = 2;
                break;
            case '>':
                trainDirection = 3;
                break;
            default:
                return false;
        }
        return true;
    }
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        int testCase = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= testCase; tc++) {
            // 게임 맵의 높이와 너비를 입력받는다
            st = new StringTokenizer(br.readLine().trim());
            rowSize = Integer.parseInt(st.nextToken());
            colSize = Integer.parseInt(st.nextToken());
            
            // 게임 맵 2차원 배열을 입력받는다
            gameMap = new char[rowSize][colSize];
            for (int row = 0; row < rowSize; row++) {
                String line = br.readLine().trim();
                for (int col = 0; col < colSize; col++) {
                    gameMap[row][col] = line.charAt(col);
                    
                    // 전차인지 판단하고 전차이면 위치를 저장한다
                    if (isTrain(gameMap[row][col])) {
                        trainRow = row;
                        trainCol = col;
                    }
                }
            }
            
            // 사용자가 넣을 입력의 개수를 입력받는다
            commandCount = Integer.parseInt(br.readLine().trim());
            // 명령어 문자열을 입력받고 하나씩 확인한다
            commandLine = br.readLine().trim();
            
            for (int idx = 0; idx < commandCount; idx++) {
                command = commandLine.charAt(idx);
                executeCommand(command);                
            }
            
            // 출력 양식에 맞게 출력한다
            sb.append("#").append(tc).append(" ");
            for (int row = 0; row < rowSize; row++) {
                for (int col = 0; col < colSize; col++) {
                	sb.append(gameMap[row][col]);
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}
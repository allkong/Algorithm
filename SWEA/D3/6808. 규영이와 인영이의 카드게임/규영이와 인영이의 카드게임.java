import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 1. 테스트 케이스를 입력받는다.
 * 2. 규영이의 카드 9장에 대한 정보를 입력받는다.
 * 3. 인영이의 카드인 나머지 카드 9장의 정보를 구한다.
 * 4. 인영이가 카드를 낼 수 있는 순서의 경우들을 순열로 구한다.
 * 5. 각 경우마다 규영이와 인영이의 카드를 비교하여 승자를 따진다.
 *    5-1. 높은 수가 적힌 카드를 낸 사람은 두 카드에 적힌 수의 합만큼 점수를 받는다.
 *    5-2. 낮은 수가 적힌 카드를 낸 사람은 아무런 점수도 얻을 수 없다.
 */
public class Solution {
	public static BufferedReader br;
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static final int cardCount = 9; // 한 사람이 가지고 있는 카드 장 수
	public static int[] cards; // 규영이의 카드 정보
	public static boolean[] cardNumCheck; // 18장의 카드 중 규영이의 카드 체크하기
	public static List<Integer> otherCards; // 인영이의 카드 정보
	public static boolean[] cardVisited; // 순열 구할 때 카드 방문 처리할 배열
	public static int[] selectCards; // 인영이가 카드를 내는 순서의 경우
	public static int score; // 규영이의 점수
	public static int otherScore; // 인영이의 점수
	public static int winCount; // 규영이가 이기는 횟수
	public static int defeatCount; //규영이가 지는 횟수
	
	public static void playGame() {
		// 9 라운드 게임 진행
		score = 0;
		otherScore = 0;
		
		for (int idx = 0; idx < cardCount; idx++) {
			if (cards[idx] > selectCards[idx]) {
				// 규영이의 카드 숫자가 인영이의 카드 숫자보다 크다면 규영이의 승리
				score += cards[idx] + selectCards[idx];
			} else {
				// 인영이의 카드 숫자가 규영이의 카드 숫자보다 크다면 인영이의 승리
				otherScore += cards[idx] + selectCards[idx];
			}
		}
		
		// 9 라운드를 끝내고 총점 비교
		if (score > otherScore) {
			winCount++;
		} else {
			defeatCount++;
		}
	}
	
	public static void permutation(int selectIdx) {
		if (selectIdx == cardCount) {
			playGame();
			return;
		}
		
		for (int cardIdx = 0; cardIdx < cardCount; cardIdx++) {
			if (cardVisited[cardIdx]) {
				continue;
			}
			
			cardVisited[cardIdx] = true;
			selectCards[selectIdx] = otherCards.get(cardIdx);
			
			permutation(selectIdx + 1);
			
			cardVisited[cardIdx] = false;			
		}
	}

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		int testCase = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= testCase; tc++) {
			// 규영이의 카드 정보를 입력받는다
			cards = new int[cardCount];
			cardNumCheck = new boolean[cardCount * 2];
			st = new StringTokenizer(br.readLine().trim());
			for (int idx = 0; idx < cardCount; idx++) {
				cards[idx] = Integer.parseInt(st.nextToken());
				// 규영이의 카드이면 해당 카드의 숫자를 방문 처리
				cardNumCheck[cards[idx] - 1] = true;
			}
			
			// 인영이의 카드 정보를 구한다
			otherCards = new LinkedList<>();
			for (int idx = 0; idx < cardCount * 2; idx++) {
				if (cardNumCheck[idx]) {
					continue;
				}
				otherCards.add(idx + 1);
			}
			
			// 인영이가 카드를 낼 수 있는 순서의 경우들을 순열로 구한다
			selectCards = new int[cardCount];
			cardVisited = new boolean[cardCount];
			winCount = 0;
			defeatCount = 0;
			permutation(0);
			sb.append("#").append(tc).append(" ").append(winCount).append(" ").append(defeatCount).append("\n");
		}
		System.out.println(sb);
	}
}
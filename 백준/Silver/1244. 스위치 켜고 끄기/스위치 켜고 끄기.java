import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 스위치 개수, 각 스위치의 상태, 학생 수, 성별, 학생이 받은 수를 입력받는다.
 * 2. 학생들은 자신의 성별과 받은 수에 따라 스위치를 조작한다.
 * 3. 남학생이면 스위치 번호가 자기가 받은 수의 배수일 때 스위치 상태를 바꾼다.
 *    3-1. 스위치가 켜져 있으면 끄고(1 -> 0), 꺼져 있으면 켠다.(0 -> 1)
 * 4. 여학생은 자기가 받은 수와 같은 번호가 붙은 스위치를 중심으로 좌우가 대칭이면서 가장 많은 스위치를 포함하는 구간을 찾는다.
 *    4-1. 해당 구간에 속한 스위치의 상태를 모두 바꾼다.
 *    4-2. 구간에 속한 스위치 개수는 항상 홀수이다.
 */
public class Main {
    public static BufferedReader br;
    public static StringBuilder sb;
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int switchCount = Integer.parseInt(br.readLine()); // 스위치 개수
        int[] power = new int[switchCount + 1]; // 스위치 전원 상태를 저장하는 배열

        // 스위치 전원 상태를 입력받아 저장한다
        st = new StringTokenizer(br.readLine().trim());
        for (int idx = 1; idx <= switchCount; idx++) {
            power[idx] = Integer.parseInt(st.nextToken());
        }

        int studentCount = Integer.parseInt(br.readLine()); // 학생 수

        for (int studentIdx = 0; studentIdx < studentCount; studentIdx++) {
            st = new StringTokenizer(br.readLine().trim());
            int gender = Integer.parseInt(st.nextToken()); // 학생의 성별 (1: 남학생, 2: 여학생)
            int studentNum = Integer.parseInt(st.nextToken()); // 학생이 받은 수

            // 남학생이면 스위치 번호가 자기가 받은 수의 배수일 때 스위치 상태를 바꾼다
            if (gender == 1) {
                for (int switchNum = 0; switchNum <= switchCount; switchNum++) {
                    if ((switchNum) % studentNum == 0) {
                        power[switchNum] = (power[switchNum] + 1) % 2;
                    }
                }
            } else if (gender == 2) {
                // 여학생은 자기가 받은 수와 같은 번호가 붙은 스위치를 중심으로 좌우가 대칭이면서 가장 많은 스위치를 포함하는 구간을 찾는다
                power[studentNum] = (power[studentNum] + 1) % 2; // 받은 수의 스위치 상태를 바꾼다
                for (int diff = 1; diff <= Math.min(studentNum - 1, switchCount - studentNum); diff++) {
                    // 대칭이 아니면 멈춘다
                    if (power[studentNum - diff] != power[studentNum + diff]) {
                       break;
                    }
                    // 대칭이면 스위치 상태를 바꾼다
                    power[studentNum - diff] = (power[studentNum - diff] + 1) % 2;
                    power[studentNum + diff] = (power[studentNum + diff] + 1) % 2;
                }
            }
        }
        for (int idx = 1; idx <= switchCount; idx++) {
            sb.append(power[idx]).append(" ");
            // 스위치는 한 줄에 20개씩 출력한다
            if (idx % 20 == 0) {
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}
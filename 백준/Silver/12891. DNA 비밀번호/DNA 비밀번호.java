import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. DNA 문자열 길이와 비밀번호로 사용할 부분문자열의 길이를 입력받는다.
 * 2. DNA 문자열을 입력받는다.
 * 3.
 *  DNA 문자열에서 슬라이딩 윈도우 기법을 활용해 부분문자열의 길이만큼 체크한다.
 *  부분문자열에서  {‘A’, ‘C’, ‘G’, ‘T’} 문자 개수를 센다.
 *  부분문자열 한 칸 옆으로 가서 맨 앞 문자였던 알파벳 개수를 하나 감소시키고 새로 추가된 문자의 알파벳 개수를 하나 증가시킨다.
 *  모두 만족하면 비밀번호 종류 수를 증가시킨다
 */
public class Main {
    public static BufferedReader br;
    public static StringTokenizer st;

    public static int stringLength; // 문자열 길이
    public static int subStringLength; // 부분 문자열 길이
    public static String dnaString; // DNA 문자열
    public static String subString; // 부분 문자열
    public static int passwordCount; // 비밀번호의 종류 수
    public static char[] dnaCharList = {'A', 'C', 'G', 'T'}; // DNA 문자열의 문자
    public static int dnaCharLength = dnaCharList.length; // DNA 문자열의 길이
    public static int[] charCountList; // password 배열의 각 요소 등장 최소 개수
    public static int[] dnaCountList; // DNA 문자열의 각 문자에 해당되는 개수

    public static int checkCount() {
        for (int charCount = 0; charCount < dnaCharLength; charCount++) {
            if (dnaCountList[charCount] < charCountList[charCount]) {
                return 0;
            }
        }
        return 1;
    }

    public static void checkChar(char alphabet, int sign) {
        // 해당 알파벳이 어떤 DNA 문자열의 문자인지에 따라 더하거나 뺀다
        if (alphabet == dnaCharList[0]) {
            dnaCountList[0]+= sign;
        } else if (alphabet == dnaCharList[1]) {
            dnaCountList[1]+= sign;
        } else if (alphabet == dnaCharList[2]) {
            dnaCountList[2]+= sign;
        } else if (alphabet == dnaCharList[3]) {
            dnaCountList[3]+= sign;
        }
    }

    public static void countDnaChar(String subString) {
        // DNA 문자열의 각 문자 개수를 센다
        for (int idx = 0; idx < subString.length(); idx++) {
            if (subString.charAt(idx) == dnaCharList[0]) {
                dnaCountList[0]++;
            } else if (subString.charAt(idx) == dnaCharList[1]) {
                dnaCountList[1]++;
            } else if (subString.charAt(idx) == dnaCharList[2]) {
                dnaCountList[2]++;
            } else if (subString.charAt(idx) == dnaCharList[3]) {
                dnaCountList[3]++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        // DNA 문자열 길이와 비밀번호로 사용할 부분문자열의 길이를 입력받는다.
        st = new StringTokenizer(br.readLine().trim());
        stringLength = Integer.parseInt(st.nextToken());
        subStringLength = Integer.parseInt(st.nextToken());
        // DNA 문자열을 입력받는다.
        dnaString = br.readLine().trim();
        dnaCountList = new int[dnaCharLength];

        // {‘A’, ‘C’, ‘G’, ‘T’}의 최소 개수를 입력받는다.
        charCountList = new int[dnaCharLength];
        st = new StringTokenizer(br.readLine().trim());
        for (int idx = 0; idx < dnaCharLength; idx++) {
            charCountList[idx] = Integer.parseInt(st.nextToken());
        }

        // 부분 문자열 초기화하고 알파벳 개수를 센다
        subString = dnaString.substring(0, subStringLength);
        countDnaChar(subString);
        passwordCount += checkCount();

        for (int idx = 0; idx < stringLength - subStringLength; idx++) {
            // 삭제할 맨 앞의 원소가 무슨 알파벳인지 확인하고 해당 알파벳 개수를 감소시킨다
            checkChar(dnaString.charAt(idx), -1);
            // 추가할 맨 뒤의 원소가 무슨 알파벳인지 확인하고 해당 알파벳의 개수를 증가시킨다
            checkChar(dnaString.charAt(idx + subStringLength), 1);

            // 현재 subString이 DNA 문자열의 문자 최소 개수 조건을 만족하는지 확인한다
            passwordCount += checkCount();
        }

        System.out.println(passwordCount);
    }
}
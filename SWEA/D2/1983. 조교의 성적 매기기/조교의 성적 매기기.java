import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 1. 테스트 케이스를 입력받는다.
 * 2. 학생 수와 학점을 알고 싶은 학생 번호를 입력받는다.
 * 3. 학생 수만큼 중간고사 점수, 기말고사 점수, 과제 점수를 입력받는다.
 *    3-1. 학생 객체를 생성해서 입력받을 때의 index와 총점을 저장한다.
 *         3-1-1. 총점으로 역순 정렬한다.
 * 4. A+ ~ D0 10개의 학점은 각각 (학생 수 / 10)명으로 끊는다.
 */
public class Solution {
    public static BufferedReader br;
    public static StringBuilder sb;
    public static StringTokenizer st;
    
    public static final String[] grades = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};
    
    public static int numOfStudents; // 학생 수
    public static int targetNum; // 학점을 알고 싶은 학생 번호
    public static List<Student> students;
    
    public static class Student implements Comparable<Student> {
        int num;
        float totalScore;
        
        public Student(int num, float totalScore) {
            this.num = num;
            this.totalScore = totalScore;
        }

        @Override
        public int compareTo(Student otherStuent) {
            // 총점으로 정렬한다
            return Float.compare(this.totalScore, otherStuent.totalScore);
        }
    }
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        int testCase = Integer.parseInt(br.readLine().trim());
        
        for (int tc = 1; tc <= testCase; tc++) {
            st = new StringTokenizer(br.readLine().trim());
            numOfStudents = Integer.parseInt(st.nextToken());
            targetNum = Integer.parseInt(st.nextToken());
            
            students = new ArrayList<>();
            
            for (int idx = 1; idx <= numOfStudents; idx++) {
                st = new StringTokenizer(br.readLine().trim());
                int midtermExam = Integer.parseInt(st.nextToken());
                int finalExam = Integer.parseInt(st.nextToken());
                int assignment = Integer.parseInt(st.nextToken());
                
                float totalScore = (float) (midtermExam * 0.35 + finalExam * 0.45 + assignment * 0.2);
                
                // 학생 객체를 생성해서 idx와 총점을 저장한다
                students.add(new Student(idx, totalScore));
            }
            
            // students 리스트를 totalScore 역순으로 정렬
            Collections.sort(students);
            Collections.reverse(students);
            
            int gradeIdx = 0;
            for (int idx = 1; idx <= numOfStudents; idx++) {
                Student current = students.get(idx - 1);
                // 학점을 알고 싶은 학생의 번호를 찾으면 해당 학생의 학점을 출력한다
                if (current.num == targetNum) {
                    sb.append("#").append(tc).append(" ").append(grades[gradeIdx]).append("\n");
                    break;
                }
                
                // 각 학점의 인원은 (학생 수 / 10)이므로 해당 단위마다 다음 학점 인덱스로 넘긴다
                if (idx % (numOfStudents / 10) == 0) {
                    gradeIdx++;
                }
            }
        }
        System.out.println(sb);
    }
}
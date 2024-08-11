import sys
input = sys.stdin.readline

TEST_CASE = 20
rating = {'A+': 4.5, 'A0': 4.0, 'B+': 3.5, 'B0': 3.5, 'B0': 3.0, 'C+': 2.5, 'C0': 2.0, 'D+': 1.5, 'D0': 1.0, 'F': 0.0}
major_grade = 0
total_credit = 0

for _ in range(TEST_CASE):
    subject, credit, grade = input().split()
    
    # 등급이 P인 과목은 계산에서 제외한다
    if grade == 'P':
        continue

    total_credit += float(credit)
    major_grade += float(credit) * rating[grade]

print(major_grade / total_credit)
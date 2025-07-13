import sys
from collections import deque
input = sys.stdin.readline

n = int(input())
waiting = deque() # 대기줄
max_count = 0 # 대기하는 학생 수가 최대인 수
student_number = 100_000 # 맨 뒤에 줄 서 있는 학생의 번호


for _ in range(n):
    command = input().split()

    if command[0] == '1':
        waiting.append(int(command[1]))

        if len(waiting) == max_count:
            student_number = min(student_number, waiting[-1])
        
        elif len(waiting) > max_count:
            max_count = len(waiting)
            student_number = waiting[-1]
        
    
    elif command[0] == '2':
        waiting.popleft()

print(max_count, student_number)
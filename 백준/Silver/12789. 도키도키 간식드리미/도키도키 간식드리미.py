import sys
input = sys.stdin.readline

n = int(input())
waiting = list(map(int, input().split())) # 줄 서있는 곳
tmp = [] # 임시 대기 공간
target = 1

while waiting:
    # 줄 맨앞에 있는 사람이 타겟 번호라면 간식을 준다
    if waiting[0] == target:
        waiting.pop(0)
        target += 1
    # 줄 맨앞에 있는 사람이 타겟 번호가 아니라면 임시 대기 공간으로 보낸다
    else:
        tmp.append(waiting.pop(0))
    
    # 임시 대기 공간에 학생이 있다면
    while tmp:
        # 임시 대기 공간 top에 있는 사람이 타겟 번호이면 간식을 준다
        if tmp[-1] == target:
            tmp.pop()
            target += 1
        # 임시 대기 공간 top에 있는 사람이 타겟 번호가 아니면 무사히 간식을 받을 수 없다
        else:
            break

print("Nice" if not tmp else "Sad")
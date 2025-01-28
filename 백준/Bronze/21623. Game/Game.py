import sys
input = sys.stdin.readline

k, n = map(int, input().split()) # 수행한 동작 횟수, 라운드 시작 점수
num = list(map(int, input().split()))
cnt = 0 # 라운드 횟수
score = n

for i in range(k):
    if score - num[i] == 0:
        cnt += 1 # 라운드 종료
        # 마지막 동작에서 라운드 종료되면 점수는 0
        if i == k - 1:
            score = 0
            break
        score = n # 점수 초기화
    elif score - num[i] > 0:
        score -= num[i]
    
print(cnt)
print(score)
import sys
input = sys.stdin.readline

k = int(input())
stack = []

for _ in range(k):
    number = int(input())
    
    # 0이 아니면 수를 받아 적는다
    if number:
        stack.append(number)
    # 0을 외치면 가장 최근에 쓴 수를 지운다
    else:
        stack.pop()

# 받아 적은 수의 합을 구한다
print(sum(stack))
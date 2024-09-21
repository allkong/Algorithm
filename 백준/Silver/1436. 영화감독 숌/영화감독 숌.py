import sys
input = sys.stdin.readline

# 666 1666 2666 3666 4666 5666 6660 6661 6662 6663
# 6664 6665 6666 6667 6668 6669 7666 8666 9666 10666 ...
# 위처럼 666의 앞에 1을 붙이고 666을 제외한 앞의 숫자에 1씩 더하다가 6이 되면 맨뒷자리가 0으로 바뀌고 다시 0부터 9가 될 때까지 더한다

idx = int(input())
title = 666
count = 0

while True:
    # 제목에 666이 포함되면 횟수 증가
    if '666' in str(title):
        count += 1
    
    # count == idx가 될 때까지 반복한다
    if count == idx:
        print(title)
        break
    
    # 제목에 666이 포함될 때까지 계속 더한다
    title += 1
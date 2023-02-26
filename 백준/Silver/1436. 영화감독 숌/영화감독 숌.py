n = int(input())
cnt = 0
title = 666

while True:
    if '666' in str(title):
        cnt += 1

    if cnt == n:
        print(title)
        break
    
    title += 1

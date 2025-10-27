import sys
input = sys.stdin.readline

T = int(input())
for _ in range(T):
    num = input().rstrip()
    
    cnt = 0
    while num != '6174':
        min_num = ''.join(sorted(num))
        max_num = min_num[::-1]
        num = str(int(max_num) - int(min_num))

        if len(num) < 4:
            num = '0' * (4 - len(num)) + num

        cnt += 1
    
    print(cnt)
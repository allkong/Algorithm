from collections import deque
import sys
input = sys.stdin.readline

t = int(input())
for _ in range(t):
    p = input().rstrip()
    n = int(input())
    dq = deque(input().rstrip()[1:-1].split(','))
    flag = True
    reverse_count = 0 # 뒤집는 횟수

    # n이 0일 때 빈 문자열이 들어가므로 초기화해준다
    if n == 0:
        dq = deque()

    for command in p:
        # R이면 배열의 수를 뒤집는다
        # -> 뒤집는 횟수를 센다
        if command == 'R':
            reverse_count += 1
        # D이면 첫 번째 수를 버린다
        # -> 뒤집는 횟수가 짝수이면 앞을 버리고, 홀수면 뒤를 버린다
        elif command == 'D':
            if dq:
                if reverse_count % 2 == 0:
                    dq.popleft()
                else:
                    dq.pop()
            # 배열이 비어있는데 D를 사용하면 에러가 발생한다
            else:
                flag = False
                print('error')
                break
    
    if flag:
        # 뒤집는 횟수가 짝수이면 그대로이니 그대로 출력한다
        if reverse_count % 2 == 0:
            print('[' + ','.join(dq) + ']')
        # 뒤집는 횟수가 홀수이면 뒤집어서 출력한다
        else:
            dq.reverse()
            print('[' + ','.join(dq) + ']')
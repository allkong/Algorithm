from collections import deque
import sys
input = sys.stdin.readline

command_count = int(input()) # 명령의 수
queue = deque()
for _ in range(command_count):
    command = input().split()

    # 정수 X를 큐에 넣는 연산이다.
    if command[0] == 'push':
        queue.append(command[1])
    # 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    elif command[0] == 'pop':
        print(queue.popleft() if queue else -1)
    # 큐에 들어있는 정수의 개수를 출력한다.
    elif command[0] == 'size':
        print(len(queue))
    # 큐가 비어있으면 1, 아니면 0을 출력한다.
    elif command[0] == 'empty':
        print(1 if not queue else 0)
    # 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    elif command[0] == 'front':
        print(queue[0] if queue else -1)
    # 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    elif command[0] == 'back':
        print(queue[-1] if queue else -1)
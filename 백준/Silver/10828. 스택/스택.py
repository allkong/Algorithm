import sys
input = sys.stdin.readline

command_count = int(input()) # 명령 개수
stack = [] # 스택

for _ in range(command_count):
    command = input().split() # 명령

    # push X: 정수 X를 스택에 넣는다.
    if command[0] == 'push':
        stack.append(command[1])
    # pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    elif command[0] == 'pop':
        print(stack.pop() if stack else -1)
    # size: 스택에 들어있는 정수의 개수를 출력한다.
    elif command[0] == 'size':
        print(len(stack))
    # empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
    elif command[0] == 'empty':
        print(1 if not stack else 0)
    # top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    elif command[0] == 'top':
        print(stack[-1] if stack else -1)
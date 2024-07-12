import sys
input = sys.stdin.readline

test_case = int(input())
for _ in range(test_case):
    stack = [] # 스택
    parenthesis_string = input() # 괄호 문자열
    
    for parenthesis in parenthesis_string:
        # 여는 괄호면 스택에 삽입한다
        if parenthesis == '(':
            stack.append(parenthesis)
        # 닫는 괄호면 스택이 비어있는지 확인하고
        # 비어있다면 괄호가 완성되지 않으니 멈춘다
        # 비어있지 않다면 스택에서 pop해서 괄호 쌍을 만든다
        elif parenthesis == ')':
            if not stack:
                stack.append(parenthesis)
                break
            else:
                stack.pop()

    # 스택이 비어있다면 모든 괄호쌍이 완성된 것이고
    # 스택에 괄호가 남아있다면 올바른 괄호 문자열이 아니다
    if not stack:
        print("YES")
    else:
        print("NO")
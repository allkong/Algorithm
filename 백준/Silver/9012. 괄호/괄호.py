import sys
input = sys.stdin.readline

test_case = int(input())
for _ in range(test_case):
    parenthesis_string = input().strip() # 괄호 문자열
    stack = [] # 스택

    for parenthesis in parenthesis_string:
        # 여는 괄호라면 스택에 삽입한다
        if parenthesis == '(':
            stack.append(parenthesis)
        # 닫는 괄호라면 스택이 비어있는지 확인한다
        else:
            # 스택이 비어있지 않다면 여는 괄호를 꺼내서 괄호 쌍을 완성시킨다
            if stack:
                stack.pop()
            # 스택이 비어있다면 올바른 괄호 문자열(VPS)이 아니다
            else:
                stack.append(parenthesis)
                break
                
    # 스택이 비어있다면 올바른 괄호 문자열이고, 비어있지 않다면 올바른 괄호 문자열이 아니다
    print("YES" if not stack else "NO")
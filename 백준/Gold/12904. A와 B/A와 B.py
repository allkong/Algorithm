import sys
input = sys.stdin.readline

s = input().rstrip()
t = input().rstrip()

# 반대로 t를 s로 만든다
# 1. 문자열의 뒤에 A를 추가한다.
#    -> 문자열이 A로 끝나면 A를 제거한다.
# 2. 문자열을 뒤집고 뒤에 B를 추가한다.
#    -> 문자열이 B로 끝나면 B를 제거하고 문자열을 뒤집는다.
while t and t != s:
    # 1번 연산 반대로
    if t[-1] == 'A':
        t = t[:-1]
    # 2번 연산 반대로
    elif t[-1] == 'B':
        t = t[-2::-1]

print(1 if s == t else 0)
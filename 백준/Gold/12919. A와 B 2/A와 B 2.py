import sys
input = sys.stdin.readline

def recursion(target):
    # 문자열이 S가 되면 종료한다
    if target == S:
        print(1)
        exit()

    if not target:
        return
    
    # 문자열의 뒤에 A를 추가한다
    # -> 문자열의 뒤에 A를 제거한다
    if (target[-1] == 'A'):
        recursion(target[:-1])

    # 문자열의 뒤에 B를 추가하고 문자열을 뒤집는다
    # -> 문자열을 뒤집고 문자열의 앞에서 B를 제거한다
    if (target[0] == 'B'):
        recursion(target[:0:-1])

# S를 T로 바꾼다
# -> T를 S로 바꾼다
S = input().rstrip()
T = input().rstrip()

recursion(T)
print(0)
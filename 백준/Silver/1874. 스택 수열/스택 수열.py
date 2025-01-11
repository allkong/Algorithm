import sys
input = sys.stdin.readline

n = int(input())
st = []
op = []
cur = 1

for _ in range(n):
    num = int(input())

    # cur이 입력받은 숫자와 작거나 같다면 push
    while cur <= num:
        st.append(cur)
        op.append('+')
        cur += 1
    
    # 스택의 top이 입력받은 숫자와 같다면 pop
    if st[-1] == num:
        st.pop()
        op.append('-')

    else:
        print('NO')
        break
    
if not st:
    print("\n".join(op))
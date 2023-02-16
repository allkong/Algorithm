import sys

n = int(input())
st = []
op = []
cnt = 1

for _ in range(n):
    num = int(sys.stdin.readline())
    while cnt <= num:
        st.append(cnt)
        op.append('+')
        cnt += 1
    
    if st[-1] == num:
        st.pop()
        op.append('-')
    else:
        print('NO')
        break

if not st:
    print(*op, sep = '\n')
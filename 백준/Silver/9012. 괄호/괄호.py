import sys

t = int(input())
for _ in range(t):
    ps = sys.stdin.readline()
    st = []
    
    for p in ps:
        if p == '(':
            st.append(p)
        elif p == ')':
            if not st:
                st.append(p)
                break
            else:
                st.pop()
    if not st:
        print('YES')
    elif st:
        print('NO')
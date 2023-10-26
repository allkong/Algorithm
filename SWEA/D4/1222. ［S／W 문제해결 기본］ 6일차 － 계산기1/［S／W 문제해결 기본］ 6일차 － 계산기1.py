for t in range(1, 11):
    n = int(input())
    infix = list(input())
    postfix = ''
    st = []
    
    for i in infix:
        if i.isdigit():
            postfix += i
        elif i == '+':
            if st:
                postfix += st.pop()
            st.append(i)
    else:
        postfix += st.pop()

    for p in postfix:
        if p.isdigit():
            st.append(int(p))
        elif p == '+':
            a = st.pop()
            b = st.pop()
            st.append(a+b)
    
    print(f'#{t}', st.pop())
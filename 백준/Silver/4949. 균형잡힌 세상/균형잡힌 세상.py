while True:
    sen = input()
    
    if sen == '.':
        break
    
    st = []
    for s in sen:
        if s == '(' or s == '[':
            st.append(s)
        elif s == ')':
            if not st or st[-1] == '[':
                st.append(s)
                break
            else:
                st.pop()
        elif s == ']':
            if not st or st[-1] == '(':
                st.append(s)
                break
            else:
                st.pop()

    if not st:
        print('yes')
    else:
        print('no')
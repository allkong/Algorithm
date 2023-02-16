bar = list(input())
st = []
ans = 0

for i in range(len(bar)):
    if bar[i] == '(':
        st.append('(')

    else:
        if bar[i - 1] == '(': 
            st.pop()
            ans += len(st)

        else:
            st.pop() 
            ans += 1 

print(ans)
str = input()
ans = ""
for s in str:
    if s.isupper():
        ans += s.lower()
    else:
        ans += s.upper()
print(ans)
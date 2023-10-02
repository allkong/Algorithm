s = input()
print(10 + int(s[2:]) if s[1] == '0' else int(s[0]) + int(s[1:]))
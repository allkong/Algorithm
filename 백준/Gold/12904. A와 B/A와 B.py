s = input()
t = input()

while t and s != t:
    if t[-1] == 'A':
        t = t[:-1]
    elif t[-1] == 'B':
        t = t[-2::-1]

print(1 if s == t else 0)
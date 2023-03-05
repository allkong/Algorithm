import sys
input = sys.stdin.readline

while True:
    s = input().rstrip()
    if s == '*':
        break

    check = 1
    for i in range(1, len(s)-1):
        pairs = set()
        for j in range(len(s)-i):
            pair = s[j] + s[j+i]
            if pair in pairs:
                check = 0
                break
            else:
                pairs.add(pair)
    if check:
        print(s, "is surprising.")
    else:
        print(s, "is NOT surprising.")
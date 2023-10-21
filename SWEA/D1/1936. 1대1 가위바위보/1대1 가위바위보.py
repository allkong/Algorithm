a, b = map(int, input().split())
print('A' if a % 3 == (b + 1) % 3 else 'B')
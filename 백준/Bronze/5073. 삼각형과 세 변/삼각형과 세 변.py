import sys
input = sys.stdin.readline

while True:
    a, b, c = map(int, input().split())

    if a == b == c == 0:
        break
    
    if 2 * max(a, b, c) >= a + b + c:
        print("Invalid")
    elif a == b  == c:
        print("Equilateral")
    elif a == b or b == c or c == a:
        print("Isosceles")
    else:
        print("Scalene")
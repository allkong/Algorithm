import sys
input = sys.stdin.readline

def line():
    b = '-'
    for i in range(int(n)):
        b = b + ' ' * len(b) + b
    return b

while True:
    n = input().rstrip()

    if n == '':
        break
    
    elif int(n) == 0:
        print('-')
        continue
  
    print(line())
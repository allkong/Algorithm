import sys
from itertools import permutations
input = sys.stdin.readline

def cal():
    global max_res, min_res
    for t in permutations(op_li, n - 1):
        s = arr[0]
        for k in range(n - 1):
            if t[k] == '+':
                s += arr[k + 1]
            elif t[k] == '-':
                s -= arr[k + 1]
            elif t[k] == '*':
                s *= arr[k + 1]
            elif t[k] == '/':
                s = int(s / arr[k + 1])
        
        max_res = max(s, max_res)
        min_res = min(s, min_res)
            
n = int(input())
arr = list(map(int, input().split()))
op_num = list(map(int, input().split()))
op_symbol = ['+', '-', '*', '/']
op_li = []
max_res = -1e9
min_res = 1e9

for i in range(4):
    for j in range(op_num[i]):
            op_li.append(op_symbol[i])

cal()
print(max_res)
print(min_res)
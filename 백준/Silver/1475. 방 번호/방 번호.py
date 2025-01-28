import sys
import math
input = sys.stdin.readline

nums = input().rstrip()
dic = {i: 0 for i in range(10)}

for num in nums:
    dic[int(num)] += 1

dic[6] = dic[9] = math.ceil((dic[6] + dic[9]) / 2)
print(max(dic.values()))
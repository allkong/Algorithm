import sys
input = sys.stdin.readline

n = int(input())
x = list(map(int, input().split()))

# x[i]를 압축한 값은 x[i]`이다
# x[i]` 값은 X[i] > x[j]를 만족하는 x[j]의 개수이다
# => x[i]` 값은 x[i]보다 작은 수의 개수이다
sorted_x = sorted(list(set(x)))

dic = {}
for i in range(len(sorted_x)):
    dic[sorted_x[i]] = i

for i in x:
    print(dic.get(i), end=' ')
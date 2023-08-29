import sys
input = sys.stdin.readline

n, m = map(int, input().split())
dic = {}
for i in range(1, n+1):
    tmp = input().rstrip()
    dic[i] = tmp
    dic[tmp] = i

for _ in range(m):
    pokemon = input().rstrip()
    print(dic[int(pokemon)] if pokemon.isdigit() else dic[pokemon])
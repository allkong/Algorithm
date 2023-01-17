import sys
num = []
for i in range(5):
    num.append(int(sys.stdin.readline()))
print(int(sum(num)/len(num)), sorted(num)[2], sep='\n')
def draw(n):
    if n == 1:
        return ['*']
    
    star = draw(n//3)
    arr = []

    for s in star:
        arr.append(s * 3)
    for s in star:
        arr.append(s + ' ' * (n//3) + s)
    for s in star:
        arr.append(s * 3)

    return arr

n = int(input())
print(*draw(n), sep='\n')
word = input()
croatia = ['c=', 'c-', 'dz=', 'd-', 'lj', 'nj', 's=', 'z=']
for c in croatia:
    word = word.replace(c, 'a')
print(len(word))
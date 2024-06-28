import sys
input = sys.stdin.readline

head_count = int(input()) # 참가자의 수
tshirts_count = list(map(int, input().split())) # 티셔츠 사이즈별 신청자의 수
tshirts_bundle, pen_bundle = map(int, input().split()) # 티셔츠 묶음 수, 펜의 묶음 수

# 티는 같은 사이즈 묶음으로 주문 가능
# 남아도 되지만 부족해서는 안 됨
min_tshirts_bundle = 0
for tshirts in tshirts_count:
    # 티셔츠가 묶음의 배수만큼 있다면 해당 배수 묶음으로 주문
    if tshirts % tshirts_bundle == 0:
        min_tshirts_bundle += tshirts // tshirts_bundle
    # 티셔츠가 0장이면 고려하지 않음
    elif tshirts != 0:
        min_tshirts_bundle += tshirts // tshirts_bundle + 1

# 펜은 묶음이나 한 자루씩 주문 가능
# 남거나 부족해서는 안 됨
max_pen_bundle = head_count // pen_bundle
pen_count = head_count - (pen_bundle * max_pen_bundle)

# 티셔츠 최소 몇 묶음 주문해야 하는지
print(min_tshirts_bundle)
# 펜을 최대 몇 묶음 주문할 수 있는지, 한 자루씩 몇 개 주문하는지
print(max_pen_bundle, pen_count)
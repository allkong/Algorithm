guitar_strings_count, brand_count = map(int, input().split())
package_price = []
each_price = []
min_cost = 0

for _ in range(brand_count):
    p, e = map(int, input().split())
    package_price.append(p)
    each_price.append(e)

# 여러 브랜드의 패키지 가격과 낱개 가격에서 가장 싼 가격을 구하기 위해 정렬한다
package_price.sort()
each_price.sort()

# 패키지 가격보다 (낱개 가격 * 6)이 더 싸다면 [기타 줄 개수 * 낱개 가격]이 최소 가격이다
if each_price[0] * 6 < package_price[0]:
    min_cost = guitar_strings_count * each_price[0]
# (낱개 가격 * 6)보다 패키지 가격이 더 싸다면 패키지를 우선적으로 구매한다
# 몫만큼 패키지를 구매했으면, 남은 개수는 낱개로 구매하는 게 더 싼지 (개수 딱 맞게 구매)
# 패키지를 하나 더 구매하는 게 더 싼지 (개수 오버해서 구매) 비교한다
else:
    quotient = guitar_strings_count // 6
    min_cost = min((quotient + 1) * package_price[0], quotient * package_price[0] + (guitar_strings_count - quotient * 6) * each_price[0])

print(min_cost)
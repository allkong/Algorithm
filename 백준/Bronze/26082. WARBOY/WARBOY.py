import sys
input = sys.stdin.readline

# 경쟁사 제품의 가격, 경쟁사 제품의 성능, WARBOY의 가격
competitor_price, competitor_performance, warboy_price = map(int, input().split())

# 경쟁사 제품의 가격 대비 성능
competitor_price_performance = competitor_performance // competitor_price

# WARBOY의 가격 대비 성능이 경쟁사 제품의 가격 대비 성능의 3배
warboy_price_performance = 3 * competitor_price_performance

# WARBOY의 성능
warboy_performance = warboy_price_performance * warboy_price

print(warboy_performance)
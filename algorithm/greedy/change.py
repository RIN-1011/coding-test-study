N = int(input())  #거스름돈 입력받기
count = 0  #거슬러 줘야 할 최소 동전 개수

coin_list = [500, 100, 50, 10]  #거스를 동전 종류

for coin in coin_list:
  count += N // coin  #동전 카운트
  N %= coin  #나머지

print(count)
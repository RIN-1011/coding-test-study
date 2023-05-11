##동전 0##

#입력 받기
N, K = map(int, input().split())
data = [input() for _ in range(N)]

result = 0 #최소 동전 개수

data.reverse() #동전 내림차순
for i in data:
    i = int(i)
    if K>=i: #K가 i로 나눌 수 있을 경우
        result += K//i
        K %= i * (K//i) #나머지 반영

#결과 출력
print(result)
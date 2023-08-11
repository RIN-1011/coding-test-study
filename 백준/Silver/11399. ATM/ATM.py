##ATM##

#입력 받기
N = int(input())
data = list(map(int, input().split()))

#시간의 합 최솟값
result = 0

data.sort() #작은 순서대로 리스트 정렬

for i in range(N):
    for j in range(i+1):
        result += data[j] #기다리는 시간 순차 덧셈

#결과 출력
print(result)

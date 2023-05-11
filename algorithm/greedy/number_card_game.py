#입력받기
N, M = map(int, input().split())

result = 0
for i in range(N):
    data = list(map(int, input().split())) #카드 입력 받기
    min_value = min(data) #행 중에서 가장 작은 수 뽑기
    result = max(result, min_value)

#결과 출력
print(result)
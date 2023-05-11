#입력받기
N, K = map(int, input().split())

result = 0 #횟수

#N이 1이 아닐 때까지 반복
while N!=1:
    if N%K != 0: #N이 K로 나누어 떨어지지 않을 경우
        N -= 1 #N에서 1 빼기
        result += 1 #횟수 추가
    else: #N이 K로 나누어 떨어질 경우
        N //= K
        result += 1 #횟수 추가

#결과 출력
print(result)
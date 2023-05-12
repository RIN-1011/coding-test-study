##시각##

#입력 받기
N = int(input())

#결과 변수
result = 0

for h in range(N+1): #시
    for m in range(60): #분
        for s in range(60): #초
            if '3' in str(h) + str(m) + str(s): #3이 포함되어 있을 경우
                result += 1 #카운트 증가

#결과 출력
print(result)
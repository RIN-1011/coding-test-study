#두 개의 숫자열

T = int(input()) #테스트 케이스 개수 입력 받기

for t in range(1, T+1): #입력 받기
    N, M = map(int, input().split())
    a = list(map(int, input().split()))
    b = list(map(int, input().split()))

    max = 0 #최댓값
    if (len(a) > len(b)): #첫번째 리스트 크기가 더 클 경우
        k = N - M #큰 길이에서 작은 길이 뺀 만큼 이동
        for i in range(k + 1):
            temp = 0
            for j in range(M):
                temp += a[j + i] * b[j] #크기 큰 리스트 값 이동
            if (max < temp): max = temp
    elif (len(a) < len(b)): #두번째 리스트 크기가 더 클 경우
        k = M - N #큰 길이에서 작은 길이 뺀 만큼 이동
        for i in range(k + 1):
            temp = 0
            for j in range(N):
                temp += a[j] * b[j + i] #크기 큰 리스트 값 이동
            if (max < temp): max = temp

    else: #두 리스트 길이 같을 경우
        for i in range(N):
            temp += a[i] * b[i] #곱하고 더하기
        max = temp

    print(f'#{t} {max}') #결과 출력
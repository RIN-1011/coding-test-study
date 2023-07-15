#숫자 배열 회전

T = int(input()) #테스트 케이스 수 입력 받기

for t in range(1, T+1):
    N = int(input())  #배열 크기 입력 받기

    arr = []
    for i in range(N):
        arr.append(list(map(int, input().split()))) #배열 입력 받기
        
    #0으로 초기화
    arr90 = [[0 for _ in range(N)] for _ in range(N)]
    arr180 = [[0 for _ in range(N)] for _ in range(N)]
    arr270 = [[0 for _ in range(N)] for _ in range(N)]

    #90도 회전
    for i in range(N):
        for j in range(N):
            arr90[i][j] = arr[N-1-j][i]
    #180도 회전
    for i in range(N):
        for j in range(N):
            arr180[i][j] = arr90[N-1-j][i]
    #270도 회전
    for i in range(N):
        for j in range(N):
            arr270[i][j] = arr180[N-1-j][i]

    #결과 출력
    print(f'#{t}')
    for i in range(N):
        #첫번째 행 결과 출력
        for j in range(N):
            print(arr90[i][j], end='')
        print(end=' ')
        #두번째 행 결과 출력
        for j in range(N):
            print(arr180[i][j], end='')
        print(end=' ')
        #세번째 행 결과 출력
        for j in range(N):
            print(arr270[i][j], end='')
        print(end=' ')
        print()
#파리퇴치3

T=int(input())

def algorithm(arr):
    #직선 상하좌우
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    #대각선
    bx = [-1, -1, 1, 1]
    by = [-1, 1, -1, 1]

    result = 0 #잡을 수 있는 최대 파리수

    for i in range(N):
        for j in range(N):
            cnt1 = arr[i][j] #직선 방향 카운트
            cnt2 = arr[i][j] #대각선 방향 카운트

            for k in range(4): #4방향으로 이동
                for w in range(1, M): #분사 세기
                    # 직선 이동
                    px = i + dx[k] * w
                    py = j + dy[k] * w
                    # 대각선 이동
                    qx = i + bx[k] * w
                    qy = j + by[k] * w
                    if(px<N and px>=0 and py<N and py>=0): #범위 체크
                        cnt1 += arr[px][py] #직선 잡은 파리 수 더하기
                    if(qx<N and qx>=0 and qy<N and qy>=0): #범위 체크
                        cnt2 += arr[qx][qy] #대각선 잡은 파리 수 더하기

            if(result<max(cnt1, cnt2)):
                result = max(cnt1, cnt2)

    return result

for t in range(1, T+1):
    N, M = map(int, input().split()) #배열 크기, 분사 세기 입력받기
    arr=[]
    for i in range(N):
        arr.append(list(map(int, input().split())))

    print(f'#{t} {algorithm(arr)}') #결과 출력


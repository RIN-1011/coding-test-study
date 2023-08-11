### D2 ###
##달팽이 숫자##

def algorithm(n):
    #우, 하, 좌, 상
    dx = [0, 1, 0, -1]
    dy = [1, 0, -1, 0]

    #n*n 배열 초기화
    array = [[0]*n for _ in range(n)]

    #처음 시작 0, 0 / 처음 방향 오른쪽
    x, y, d = 0, 0, 0
    #처음 위치 1 삽입
    array[x][y] = 1
    #배열에 들어갈 숫자
    i = 1
    
    #배열 다 돌때까지 반복
    while True:
        #방향에 맞게 이동
        nx = x + dx[d]
        ny = y + dy[d]

        #범위를 벗어나는 경우
        if nx >= n or nx <= -1 or ny >= n or ny <= -1:
            d += 1 #방향 전환
            if d == 4:
                d = 0
        #이미 결정된 값이 있는 경우
        elif array[nx][ny] != 0:
            d += 1  # 방향 전환
            if d == 4:
                d = 0
        else:
            #배열에 알맞는 숫자 삽입
            i += 1
            array[nx][ny] = i
            #위치 이동
            x = nx
            y = ny

        #배열 다 돌았을 경우 반복문 끝
        if i == n*n:
            break;
    
    return array

##입력 받기##
T = int(input())
for i in range(T):
    n = int(input())

    print('#'+str(i+1))

    array = algorithm(n)

    for row in array:
        print(*row)

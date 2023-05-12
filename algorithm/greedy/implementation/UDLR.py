##상하좌우##

#입력 받기
N = int(input())
data = input().split()

x, y = 1, 1 #첫 시작 좌표 설정

# 좌우상하 이동
dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]
move_str = ['L', 'R', 'U', 'D']

for p in data: #입력 받은 계획서 확인
    for i in range(len(move_str)): #상하좌우 확인
        if p == move_str[i]: #상하좌우 확인 후 이동
            nx = x + dx[i] #x좌표 이동
            ny = y + dy[i] #y좌표 이동
    if nx < 1 or ny < 1 or nx > N or ny > N: #공간 밖으로 벗어나는 경우
        continue #무시
    #좌표 이동
    x = nx
    y = ny

#결과 출력
print(x, y)


##미로 탈출##

from collections import deque

#입력 받기
N, M = map(int, input().split())
gragh = []
for i in range(N):
    gragh.append(list(map(int, input())))

#상하좌우
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

#넓이 우선 탐색
def BFS(x, y):
    queue = deque() #큐 생성
    queue.append((x, y)) #시작 노드 큐 삽입
    
    while queue: #큐가 빌 때까지 반복
        x, y = queue.popleft() #큐 꺼내기
        for i in range(4):  #상하좌우 이동
            nx = x + dx[i]
            ny = y + dy[i]
            if nx <= -1 or nx >= N or ny <= -1 or ny >= M:  #범위 벗어나는 경우
                continue  #패스
            if gragh[nx][ny] == 0:  #괴물 있는 경우
                continue  #패스
            if gragh[nx][ny] == 1:  #방문 안한 경우
                queue.append((nx, ny)) #큐 삽입
                gragh[nx][ny] = gragh[x][y] + 1 #거리 재기

    return gragh[N-1][M-1]

#결과 출력
print(BFS(0, 0))

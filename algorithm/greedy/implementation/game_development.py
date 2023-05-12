##게임 개발##

#입력 받기
N, M = map(int, input().split())
A, B, d = map(int, input().split())
array = []
for _ in range(N):
    array.append(list(map(int, input().split())))

#북동남서
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

#방문한 좌표 기록 리스트
visit = [[0] * M for _ in range(N)]
visit[A][B] = 1 #처음 위치 방문

#왼쪽 방향 회전 함수
def turn_left():
    global d
    d -= 1 #왼쪽으로 회전
    if d == -1: #북쪽에서 왼쪽으로 회전할 경우
        d = 3 #서쪽으로 회전

#break 조건 변수
cnt = 0
#방문한 칸의 수
result = 1

while True:
    turn_left() #왼쪽 방향으로 회전
    nx = A + dx[d]
    ny = B + dy[d] #현재 위치에 방향 반영
    if visit[nx][ny] == 0 and array[nx][ny] == 0: #바다가 아니고 방문하지 않은 경우 이동
        A = nx
        B = ny
        visit[A][B] = 1 #방문
        result += 1 #카운트 증가
        cnt = 0 #break 조건 초기화
        continue
    else: #바다이거나 방문한 경우
        cnt += 1

    if cnt == 4: #네 방향 모두 갈 수 없는 경우
        nx = A - dx[d]
        ny = B - dy[d]
        if array[nx][ny] == 0: #바다가 아닌 경우
            A = nx
            B = ny #바라보는 방향을 유지한 채로 한 칸 뒤로 가기
        else: #바다인 경우
            break
        cnt = 0  # break 조건 초기화

print(result)

    


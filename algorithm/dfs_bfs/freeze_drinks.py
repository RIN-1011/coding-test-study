##음료수 얼려 먹기##

#입력 받기
N, M = map(int, input().split())
gragh = []
for i in range(N):
    gragh.append(list(map(int, input())))

#깊이 우선 탐색 함수 (아이스크림 개수 세기)
def DFS(x, y):
    if x<=-1 or x>=N or y<=-1 or y>=M: #배열 범위 벗어나는 경우
        return False #종료
    if gragh[x][y] == 0: #아직 방문 안했을 경우
        gragh[x][y] = 1 #방문 처리
        #상하좌우 방문
        DFS(x-1, y)
        DFS(x+1, y)
        DFS(x, y-1)
        DFS(x, y+1)
        return True
    return False
    
#결과 변수
result = 0
for i in range(N):
    for j in range(M):
        if DFS(i, j) == True: #처음 방문했을 경우
            result += 1 #카운트 증가
            
#결과 출력
print(result)
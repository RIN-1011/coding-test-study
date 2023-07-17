##단지번호붙이기##

#우하좌상
dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

def algorithm(x, y):
    if x <= -1 or x >= n or y <= -1 or y >= n: #범위 벗어나는 경우
        return False
    if graph[x][y] == 1: #집이 존재할 경우
        global count
        count += 1 #단지수 카운트 증가
        graph[x][y] = 0 #방문한 단지 표시
        for i in range(4): #상하좌우 방문
            nx = x + dx[i]
            ny = y + dy[i]
            algorithm(nx, ny)
        return True
    return False

#입력 받기
n = int(input())
graph = []
for i in range(n):
    graph.append(list(map(int, input())))

result = 0 #총 단지수
count = 0 #단지내 집의 수
house_cnt = [] #각 단지내 집의 수

for i in range(n):
    for j in range(n):
        if algorithm(i, j) == True:
            house_cnt.append(count) #각 단지내 집의 수 저장
            result += 1 #총 단지수 카운트 증가
            count = 0 #초기화
#결과 출력
print(result)
house_cnt.sort() #오름차순 정렬
for i in range(len(house_cnt)):
    print(house_cnt[i])
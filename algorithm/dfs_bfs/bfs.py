##BFS##

from collections import deque

def BFS(gragh, start, visited):
    queue = deque() #큐 생성
    queue.append(start) #첫번째 노드 큐 삽입
    visited[start] = True #첫번째 노드 방문

    while queue: #큐가 빌 때까지 반복
        v = queue.popleft() #후입선출
        print(v, end=' ') #방문 순서 출력
        
        for i in gragh[v]: #인접 노드 확인
            if visited[i] == False:
                queue.append(i)  #큐 삽입
                visited[i] = True #방문
        
#그래프 정의
gragh = [[],
             [2, 3, 8],
             [1, 7],
             [1, 4, 5],
             [3, 5],
             [3, 4],
             [7],
             [2, 6, 8],
             [1, 7]]
#방문 여부 리스트
visited = [False] * 9
#함수 호출
BFS(gragh, 1, visited)
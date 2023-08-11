##DFS와 BFS##
from collections import deque

def dfs(graph, v, visited):
    visited[v] = True #방문
    print(v, end=' ') #결과 출력


    for i in graph[v]: #v와 연결된 노드 중
        if not visited[i]: #방문하지 않은 노드일 경우
            dfs(graph, i, visited) #탐색

def bfs(graph, start, visited):
    #큐 선언
    queue = deque([start])
    visited[start] = True  #시작 노드 방문

    #큐가 빌 때까지 반복
    while queue:
        v = queue.popleft() #선입 선출
        print(v, end=' ') #결과 출력

        for i in graph[v]: #v와 연결된 노드 중
            if not visited[i]: #방문하지 않은 노드 있을 경우
                queue.append(i) #모두 큐에 삽입
                visited[i] = True #방문

#입력 받기
n, m, v = map(int, input().split())
#그래프 선언
graph = [[] for _ in range(n+1)]
#방문 여부
visited = [False] * (n+1)
for i in range(m):
    s, e = map(int, input().split()) #연결 노드 입력 받기
    #연결된 노드 정보 추가
    graph[s].append(e)
    graph[e].append(s)
    #그래프 오름차순 정렬
    graph[s].sort()
    graph[e].sort()

#결과 출력
dfs(graph, v, visited)
print()
#방문 여부 초기화
visited = [False] * (n+1)
bfs(graph, v, visited)

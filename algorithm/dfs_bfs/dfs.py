##DFS##

def DFS(gragh, v, visted):
    visited[v] = True #방문 처리
    print(v, end=' ') #방문 순서 출력

    for i in gragh[v]: #현재 노드와 연결된 다른 노드 방문
        if visted[i] == False: #아직 방문 안했을 경우
            DFS(gragh, i, visted) #재귀 DFS 함수 호출

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
DFS(gragh, 1, visited)
a=[]
for i in range(19):
    a.append(list(map(int, input().split()))) #이차원 배열 입력 받기
        
n = int(input()) #뒤집기 횟수 입력 받기
for i in range(n):
    x, y = map(int, input().split()) #뒤집는 가로, 세로 줄 입력 받기
    x -= 1
    y -= 1 #인덱스 맞추기
    for j in range(19):
        if a[x][j]==0: #가로 줄 배열 값이 0이면
            a[x][j] = 1 #1 삽입
        else: #가로 줄 배열 값이 1이면
            a[x][j] = 0 #0 삽입
    for k in range(19):
        if a[k][y]==0: #세로 줄 배열 값이 0이면
            a[k][y] = 1 #1 삽입
            
        else: #세로 줄 배열 값이 1이면
            a[k][y] = 0 #0 삽입

for i in range(19): #결과 출력
    for j in range(19):
        print(a[i][j], end=' ')
    print()

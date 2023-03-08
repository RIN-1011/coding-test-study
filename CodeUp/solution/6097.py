h, w = map(int, input().split()) #세로, 가로 입력 받기
n = int(input()) #막대의 개수 입력 받기

result = []
for i in range(h):
    result.append([])
    for j in range(w):
        result[i].append(0)

for i in range(n): #막대 개수만큼 반복
    l, d, x, y = map(int, input().split()) #길이, 방향, 좌표 입력 받기
    x -= 1
    y -= 1 #인덱스 맞추기
    for j in range(l): #막대 길이만큼 반복
        
        if d == 0: #막대 방향이 가로일 경우
            result[x][y] = 1
            y += 1 #가로로 한 칸 이동
            
        elif d == 1: #막대 방향이 세로일 경우
            result[x][y] = 1
            x += 1

for i in range(h):
    for j in range(w):
        print(result[i][j], end=' ')
    print()

result = []
for i in range(10):
    result.append(list(map(int, input().split())))

x = 1
y = 1 #개미집 첫 시작 (2,2)

result[x][y] = 9 #시작 지점

while True:
    if result[x][y+1] != 1: #가로가 벽으로 막혀있지 않을 경우
        y += 1 #가로 한칸 이동
        
        if result[x][y] == 2: #먹이가 있는 경우
            result[x][y] = 9 #가로 한칸 이동
            break; #반복문 종료
        
        else: #먹이가 없는 경우
            result[x][y] = 9 #가로 한칸 이동


    elif result[x][y+1] == 1: #가로가 벽으로 막혀있는 경우
        
        if result[x+1][y] != 1: #세로가 벽으로 막혀있지 않을 경우
            x += 1 #세로 한칸 이동

            if result[x][y] == 2: #먹이가 있는 경우
                result[x][y] = 9 #세로 한칸 이동
                break; #반복문 종료
        
            else: #먹이가 없는 경우
                result[x][y] = 9 #세로 한칸 이동
                
        else: #가로, 세로 모두 막혀있는 경우
            break;

for i in range(10): #결과 출력
    for j in range(10):
        print(result[i][j], end=' ')
    print()

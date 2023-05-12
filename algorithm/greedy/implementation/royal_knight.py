##왕실의 나이트##

#입력 받기
s = input()

row = int(s[1]) #행
column = ord(s[0])-ord('a')+1 #열

#이동할 수 있는 경우의 수
steps = [(-2, -1), (-2, 1), (2, -1), (2, 1), (-1, -2), (1, -2), (-1, 2), (1, 2)]
#이동 경우의 수
result = 0

for i in steps: #경우의 수 모두 확인
    nx = row + i[0] #행 이동
    ny = column + i[1] #열 이동

    if 1<=nx<=8 and 1<=ny<=8: #범위 벗어나지 않는 경우
        result += 1 #카운트 증가

#결과 출력
print(result)
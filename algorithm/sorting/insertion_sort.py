##삽입 정렬##
array = [7, 5, 9, 0, 3, 1, 6, 2, 4, 8]

for i in range(1, len(array)): #배열 크기만큼 반복
    for j in range(i, 0, -1): #현재 위치에서 0까지 거꾸로 반복
        if array[j] < array[j-1]: #현재 값보다 작은 값이 왼쪽에 존재할 경우
            array[j], array[j-1] = array[j-1], array[j] #왼쪽으로 한 칸 이동
        else: #정렬 되어있는 경우
            break; #반복문 멈춤

#결과 출력
print(array)







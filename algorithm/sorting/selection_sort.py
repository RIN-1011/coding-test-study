##선택 정렬##
array = [7, 5, 9, 0, 3, 1, 6, 2, 4, 8]

for i in range(len(array)): #배열 크기만큼 반복
    min_index = i #가장 작은 수 인덱스
    for j in range(i+1, len(array)): #이미 정렬된 수 제외하고 반복
        if array[j] < array[min_index]: #정의된 가장 작은 수보다 더 작은 수 있을 경우
            min_index = j #가장 작은 수 인덱스 갱신
    array[i], array[min_index] = array[min_index], array[i] #값 스와프

#결과 출력
print(array)

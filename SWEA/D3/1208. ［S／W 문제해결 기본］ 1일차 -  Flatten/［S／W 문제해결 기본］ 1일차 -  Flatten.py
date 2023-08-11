### D3 ###
##[S/W 문제해결 기본] 1일차 - Flatten##

def algorithm(array):
    global dump, result
    n = 0 #덤프 횟수 카운트

    #덤프 횟수 초과 전까지 반복
    while n < dump:
        n += 1 #횟수 추가
        #높이 큰 순서대로 정렬
        array.sort()
        array.reverse()
        if array[0] != array[len(array)-1]:
            # 덤프 수행
            array[0] -= 1  # 최고점
            array[len(array) - 1] += 1  # 최저점
    
    #최고점과 최저점의 높이 차
    array.sort()
    array.reverse()
    result = array[0] - array[len(array)-1]

#입력 받기
for i in range(1, 11):
    dump = int(input())
    array = list(map(int, input().split()))

    #높이 차이
    result = 0
    algorithm(array)
    #결과 출력
    print(f'#{i} {result}')

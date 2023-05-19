### D3 ###
##농작물 수확하기##
import sys
sys.stdin = open("input.txt", "r")

def algorithm(n):
    result = 0 #최종 수익

    #시작 지점, 끝 지점
    start, end = n // 2, n // 2
    for i in range(n):
        for j in range(start, end + 1):
            #수익 더하기
            result += int(array[i][j])
        #i가 n의 절반보다 작을 경우
        if i < n // 2:
            #시작 지점 당기기, 끝 지점 밀기
            start -= 1
            end += 1
        # i가 n의 절반보다 같거나, 클 경우
        elif i >= n // 2:
            #시작 지점 밀기, 끝 지점 당기기
            start += 1
            end -= 1

    return result

#입력 받기
T = int(input())
for i in range(1, T+1):
    n = int(input())
    array = []
    for j in range(n):
        array.append(input())

    #결과 출력
    print(f'#{i} {algorithm(n)}')
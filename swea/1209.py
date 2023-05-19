### D3 ###
##[S/W 문제해결 기본] 2일차 - Sum##
import sys
sys.stdin = open("input.txt", "r")

def algorithm(array):
    row_sum = 0 #가로 합
    coulmn_sum = 0 #세로 합
    di_sum1 = 0 #대각선 합
    di_sum2 = 0  # 대각선 합
    
    #완전 탐색
    for i in range(100):
        row_tmp, coulmn_tmp = 0, 0
        for j in range(100):
            #첫번째 대각선 합
            if i == j:
                di_sum1 += array[i][j]
            #두번째 대각선 합
            elif i+j == 99:
                di_sum2 += array[i][j]

            #가로 합
            row_tmp += array[i][j]
            #세로 합
            coulmn_tmp += array[j][i]
        #가장 큰 가로 합으로 갱신
        if row_sum < row_tmp:
            row_sum = row_tmp
        #가장 큰 세로 합으로 갱신
        if coulmn_sum < coulmn_tmp:
            coulmn_sum = coulmn_tmp
            
    #최댓값 리턴
    return max(row_sum, coulmn_sum, di_sum1, di_sum2)

#입력 받기
for i in range(10):
    n = int(input())
    array = []
    for j in range(100):
        array.append(list(map(int, input().split())))

    #결과 출력
    print(f'#{n} {algorithm(array)}')
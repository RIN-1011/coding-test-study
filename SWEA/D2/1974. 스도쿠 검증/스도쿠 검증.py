#스도쿠 검증

T = int(input())

for t in range(1, T+1):
    arr=[]
    result = 1
    for i in range(1, 10):
        arr.append(list(map(int, input().split())))

    for i in range(9):
        cnt1 = [0 for i in range(1, 11)]
        cnt2 = [0 for i in range(1, 11)]
        for j in range(9):
            #가로줄 검사
            N = arr[i][j]
            cnt1[N] += 1
            #세로줄 검사
            M = arr[j][i]
            cnt2[M] += 1
            #격자 검사
            if(i%3==0 and j%3==0):
                cnt3 = [0 for i in range(1, 11)]
                for k in range(i, i+3):
                    for w in range(j, j+3):
                        W = arr[k][w]
                        cnt3[W] += 1
                if(cnt3[W]>1):
                    result = 0
                    break;
        #가로, 세로줄 중복 검사
        for j in range(9):
            if(cnt1[j] > 1 or cnt2[j] > 1):
                result = 0
                break;


    print(f'#{t} {result}') #결과 출력

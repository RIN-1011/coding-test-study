### D3 ###
##[S/W 문제해결 기본] 1일차 - View##

#문제 계산 함수
def algorithm(array):
    result = 0 #조망권 확보 세대 수
    for i in range(2, len(array)-2): #좌우 두 칸 건물 제외하고 모든 빌딩 검사
        #현재 빌딩 기준으로 좌우 2칸 검사하여 조망권 확보 세대 계산
        tmp = array[i] - max(array[i-2], array[i-1], array[i+1], array[i+2])
        if tmp > 0:
            result += tmp #결과 반영

    return result

for i in range(10):
    # 입력 받기
    n = int(input())
    array = list(map(int, input().split()))
    #결과 출력
    print('#'+str(i+1)+' '+str(algorithm(array)))

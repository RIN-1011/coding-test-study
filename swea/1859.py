### D3 ###
##백만 장자 프로젝트##

def algorithm(array):
    result = 0 #최대 이익 결과
    max = 0 #가장 비싼 매매가

    #배열 거꾸로 순회
    for i in range(len(array)-1, -1, -1):
        if array[i] >= max: #현재 값이 가장 비싼 매매가 보다 클 경우
            max = array[i] #갱신
        else: #아닐 경우
            result += max - array[i] #매매 가격차 더하기

    return result

#입력 받기
T = int(input())
for i in range(T):
    n = int(input())
    array = list(map(int, input().split()))

    #결과 출력
    print('#'+str(i+1)+' '+str(algorithm(array)))
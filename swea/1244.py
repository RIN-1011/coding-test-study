### D3 ###
##[S/W 문제해결 응용] 2일차 - 최대 상금##

def algorithm(cnt):
    global result
    
    #횟수 다 사용했을 경우
    if cnt == N:
        #가장 큰 수와 현재 수 비교
        result = max(result, int(''.join(map(str, array))))
        return
    
    #모든 경우의 수 탐색
    for i in range(l-1):
        for j in range(i+1, l):
            array[i], array[j] = array[j], array[i] #값 스와프

            cnum = ''.join(map(str, array))  #리스트 합치기
            #아직 처리하지 않은 경우
            if (cnt, cnum) not in v:
                algorithm(cnt + 1)  #재귀 함수 호출
                v.append((cnt, cnum)) #v 리스트에 추가

            array[i], array[j] = array[j], array[i] #값 원상 복구


#입력 받기
T = int(input())
for i in range(1, T+1):
    n, cnt = input().split()
    N = int(cnt)
    #정수 쪼개서 배열에 삽입
    array = []
    for j in n:
        array.append(int(j))
    l = len(array)

    result = 0
    v = [] #이미 처리한 경우
    algorithm(0)

    #결과 출력
    print('#'+str(i)+' '+str(result))
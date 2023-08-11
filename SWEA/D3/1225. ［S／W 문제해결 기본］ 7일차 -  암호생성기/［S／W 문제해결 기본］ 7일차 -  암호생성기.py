### D3 ###
##[S/W 문제해결 기본] 7일차 - 암호생성기##
import sys
sys.stdin = open("input.txt", "r")

from collections import deque

def algorithm(queue):
    flag = 0 #while문 빠져나오기 위한 변수

    while flag==0:
        #사이클 반복
        for i in range(1, 6):
            #맨 앞 원소 1빼기
            v = queue.popleft() - i
            #원소 0보다 작아지거나 같을 경우 결과 반환
            if v <= 0:
                queue.append(0)
                flag = 1
                break;
            #큐 마지막에 원소 삽입
            else:
                queue.append(v)

    return queue

#입력 받기
for i in range(10):
    n = int(input())
    #큐 선언
    queue = deque(list(map(int, input().split())))

    #결과 출력
    result = algorithm(queue)
    print('#'+str(n), end=' ')
    print(*result)


### D3 ###
##[S/W 문제해결 응용] 1일차 - 단순 2진 암호코드##
def algorithm(array):
    global N
    key = [] #암호 저장된 줄 저장
    for i in range(N): #전체 리스트 검사
        if '1' in array[i]: #1 포함되어 있을 경우
            key = array[i] #key 리스트에 한줄 저장
            break; #반복문 멈춤

    #암호 저장된 마지막 인덱스
    last_index = len(key)-1
    #암호 배열 거꾸로 검사
    for p in range(len(key)-1, -1, -1):
        if key[p] == '1': #1이 있을 경우
            last_index = p #암호 마지막 인덱스 저장
            break;
    #스캐너
    scanner = [['0001101'], ['0011001'],['0010011'],['0111101'],['0100011']
               ,['0110001'],['0101111'],['0111011'],['0110111'],['0001011']]
    #암호 저장된 배열
    key = key[last_index-55:last_index+1]
    
    #암호 변환 리스트
    num =[]
    #암호 7비트씩 끊어 읽기
    for i in range(0, len(key), 7):
        str = key[i:i+7]
        #scanner와 비교해서 암호 숫자로 변환
        for j in range(0, len(scanner)):
            if str in scanner[j]:
                num.append(j)
                continue;
    #올바른 암호일 경우
    if ((num[0]+num[2]+num[4]+num[6])*3+(num[1]+num[3]+num[5]+num[7])) % 10 == 0:
        return num[0]+num[2]+num[4]+num[6]+num[1]+num[3]+num[5]+num[7] #값 더해서 리턴
    #잘못된 암호일 경우
    else:
        return 0 #0 리턴

#입력 받기
T = int(input())
for i in range(1, T+1):
    N, M = map(int, input().split())
    array = []
    for j in range(N):
        array.append(input())
    
    #결과 출력
    print(f'#{i} {algorithm(array)}')
##설탕 배달##

#입력 받기
N = int(input())

result = 0 #봉지 개수

while N >= 0:
    if N % 5 == 0:  #N이 5로 나누어 떨어질 경우
        result += N // 5 #결과 반영
        break;
    N -= 3 #N이 5로는 나누어 떨어지지 않고 3으로 빼질 경우
    result += 1 #결과 반영

else: #정확하게 N킬로그램을 만들 수 없을 경우
    result = -1 #결과 반영

#결과 출력
print(result)

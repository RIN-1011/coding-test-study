#입력 받기
N, M, K = map(int, input().split())
data = list(map(int, input().split()))

#입력 받은 리스트 정렬
data.sort()
data.reverse()

first = data[0]  #첫번째 큰 수 저장
second = data[1]  #두번째 큰 수 저장

result = 0  #결과

count = 0  #덧셈 개수 제한

for i in range(M):  #M번 만큼 덧셈
  if count != K:  #제한보다 작을 경우
    result += first  #가장 큰 수 덧셈
    count += 1  #카운트 증가
  else:  #제한 도달했을 경우
    count = 0  #카운트 초기화
    result += second  #두번째 큰 수 덧셈

print(result)
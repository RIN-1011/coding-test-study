# 최빈수 구하기

T = int(input())

for t in range(1, T + 1):
    N = int(input())
    arr = list(map(int, input().split()))  # 성적 입력받기

    count = [0 for _ in range(101)]  # 최빈수 카운트
    result = 0  # 최빈수

    for p in arr:
        count[p] += 1  # 입력받은 배열의 성적 인덱스에 1 추가
        if (count[p] > count[result]):  # 기존 최빈수 갱신
            result = p
        elif (count[p] == count[result]):  # 최빈수 여러개 처리
            if (p > result):  # 가장 큰 점수 출력
                result = p

    print(f'#{N} {result}')  # 결과 출력

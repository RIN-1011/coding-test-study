##디지털시계##

#입력 받기
for i in range(3):
    start, end = input().split()
    sh, sm, ss = map(int, start.split(':')) #시작 시간 시분초 저장
    eh, em, es = map(int, end.split(':')) #끝 시간 시분초 저장
    result = 0 #3의 배수 개수

    #시작 시간부터 끝 시간 직전까지 반복
    while sh!=eh or sm!=em or ss!=es:
        #3의 배수일 경우
        if int(str(sh)+str(sm)+str(ss)) % 3 == 0:
            result += 1 #카운트 증가

        ss += 1 #초 증가
        if ss == 60: #59초 넘어가는 경우
            ss = 0 #00초
            sm += 1 #분 증가
            if sm == 60: #59분 넘어가는 경우
                sm = 0 #00분
                sh += 1 #시간 증가
                if sh == 24: #23시 넘어가는 경우
                    sh = 0 #00시

    #끝 시간 검사
    if int(str(sh)+str(sm)+str(ss)) % 3 == 0:
        result += 1

    #결과 출력
    print(result)

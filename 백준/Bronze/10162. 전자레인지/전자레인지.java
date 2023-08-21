import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine()); //요리시간 초
		
		int A = 300; //버튼 A 시간 초로 변경
		int B = 60; //버튼 B 시간 초로 변경
		int C = 10; //버튼 C 시간 초로 변경
		
		int cntA = 0; //버튼 A 횟수
		int cntB = 0; //버튼 A 횟수
		int cntC = 0; //버튼 A 횟수
		
		if(T >= A) {
			while(true) { //T가 300초 이상일 경우 A버튼 누르기
				if(T < A) { //300초 이하로 남을 경우 반복문 멈춤
					break;
				}
				T -= A;
				cntA++; //A버튼 누른 횟수 증가
			}
		}
		if(T >= B) {
			while(true) { //T가 60초 이상일 경우 B버튼 누르기
				if(T < B) { //60초 이하로 남을 경우 반복문 멈춤
					break;
				}
				T -= B;
				cntB++; //B버튼 누른 횟수 증가
			}
		}
		if(T%C == 0) { //정확히 3개의 버튼으로 T초 맞출 수 있을 경우
			cntC = T/C; //C버튼 누른 횟수
			System.out.println(cntA + " " + cntB + " " + cntC);
		}
		else { //3개의 버튼으로 T초를 맞출 수 없는 경우
			System.out.println(-1);
		}
		
	}

}

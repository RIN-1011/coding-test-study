import java.util.*;
import java.io.*;

//스위치 켜고 끄기
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); //스위치 개수
		int s[] = new int[N+1]; //스위치 상태
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			s[i] = Integer.parseInt(st.nextToken());
		}
		
		int student = Integer.parseInt(br.readLine()); //학생 수
		int ss[][] = new int[student][2]; //학생 성별, 받은 수
		for(int i=0; i<student; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<2; j++) {
				ss[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<student; i++) { //학생 수만큼 스위치 상태 변경
			if(ss[i][0] == 1) { //남학생일 경우
				for(int j=ss[i][1]; j<=N; j+=ss[i][1]) { //받은 수의 배수 스위치 상태 바꾸기
					if(s[j] == 1) { //스위치 켜져있을 경우
						s[j] = 0; //끄기
					}
					else { //스위치 꺼져있을 경우
						s[j] = 1; //켜기
					}
				}
			}
			
			
			else { //여학생일 경우
				int j, temp = ss[i][1]; //받은 스위치 번호
				for(j=1; j<=N; j++) {
					//유효한 범위 내에서
					if(temp-j>=1 && temp+j<=N) {
						if(s[temp-j] != s[temp+j]) { //대칭이 아닐 경우
							break; //반복문 탈출
						}
					}
					else {
						break;
					}
				}
				//대칭인 인덱스+1까지 저장
				
				for(int k=1; k<j; k++) { //대칭 구간 스위치 상태 변경
					if(s[temp-k]==0) {
						s[temp-k] = 1;
					}
					else if(s[temp-k]==1) {
						s[temp-k] = 0;
					}
					if(s[temp+k]==0) {
						s[temp+k] = 1;
					}
					else if(s[temp+k]==1) {
						s[temp+k] = 0;
					}
				}
				//자기 자신 상태 변경
				if(s[temp] == 0) {
					s[temp] = 1;
				}
				else {
					s[temp] = 0;
				}
			}
		}
		
		for (int i = 1; i <= N; i++) { //한 줄에 20개씩 출력
			System.out.print(s[i] + " ");
			if(i % 20 == 0) {
				System.out.println();
			}
		}
		
	}

}

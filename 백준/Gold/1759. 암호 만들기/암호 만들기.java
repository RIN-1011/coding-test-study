import java.util.*;
import java.io.*;

//암호 만들기
public class Main {
	static int L, C; //암호 길이, 문자 종류
	static char numbers[]; //완성된 조합 결과
	static char password[]; //암호 종류
	static StringBuilder sb;
	
	public static boolean checked() {
		int cnt1 = 0, cnt2 = 0; //모음, 자음 개수
		for (int i = 0; i < L; i++) {
			//모음 있을 경우
			if(numbers[i] == 'a' || numbers[i] == 'e' || numbers[i] == 'i' || numbers[i] == 'o' || numbers[i] == 'u') {
				cnt1++; //모음 카운트 증가
			}
			//자음 있을 경우
			else {
				cnt2++; //자음 카운트 증가
			}
		}
		//최소 한 개의 모음과 최소 두 개의 자음
		if(cnt1>=1 && cnt2>=2) {
			return true;
		}
		return false;
	}
	//조합
	public static void comb(int cnt, int start) {
		if(cnt == L) { //원하는 암호 길이만큼 조합 완성됐을 경우
			if(checked()) { //옳은 암호일 경우 결과 추가
				for (int i = 0; i < L; i++) {
					sb.append(numbers[i]);
				}
				sb.append("\n");
			}
		}
		else { //조합
			for (int i = start; i < C; i++) {
				numbers[cnt] = password[i];
				comb(cnt+1, i+1);
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken()); //암호 길이
		C = Integer.parseInt(st.nextToken()); //문자의 종류
		
		numbers = new char[C]; //완성된 조합 결과
		password = new char[C]; //암호 종류 알파벳
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			password[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(password); //오름차순 정렬
		
		comb(0, 0);
		System.out.println(sb);
	}

}

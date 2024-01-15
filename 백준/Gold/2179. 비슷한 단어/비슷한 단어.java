import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); //문자열 개수
		String str[] = new String[N];
		for (int i = 0; i < N; i++) {
			str[i] = br.readLine();
		}
		
		int max = Integer.MIN_VALUE; //최대 접두사 길이
		//비슷한 두 단어
		int S = 0;
		int T = 0;
		
		//문자열 두 쌍씩 전부 비교
		for (int i = 0; i < N-1; i++) {
			for (int j = i+1; j < N; j++) {
				//문자열이 일치하지 않을 경우
				if(!str[i].equals(str[j])) {
					//최대 비교 길이
					int len = Math.min(str[i].length(), str[j].length());
					int cnt = 0; //접두사 길이
					//접두사 일치 비교
					for (int k = 0; k < len; k++) {
						//같으면 카운트 증가
						if(str[i].charAt(k)==str[j].charAt(k)) {
							cnt++;
						}
						else {
							break;
						}
					}
					if(max<cnt) {
						max = cnt;
						S = i;
						T = j;
					}
				}
			}
		}
		System.out.println(str[S]);
		System.out.println(str[T]);
	}

}

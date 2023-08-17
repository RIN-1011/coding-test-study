import java.util.*;
import java.io.*;

public class Solution {
	static int N, K; //숫자 개수
	static HashSet<Integer> set = new HashSet<>(); //중복 없이 숫자 저장
	
	public static int spin(String str) {
		String[] token = new String[4]; //숫자 4면으로 쪼개기
		//회전 안했을 경우
		for (int i = 0; i < 4; i++) {
			token[i] = str.substring(i*N/4, (i*N/4)+N/4); //4면으로 쪼개서
			int key = Integer.parseInt(token[i],16); //16진수 10진수로 변환
			set.add(key); //중복 없이 set 삽입
		}
		
		//회전 했을 경우
		for (int i = 0; i < N/4-1; i++) {
			token = new String[4]; //숫자 4면으로 쪼개기
			str = str.substring(N-1).concat(str.substring(0, N-1)); //숫자 회전
			for (int j = 0; j < 4; j++) {
				token[j] = str.substring(j*N/4, (j*N/4)+N/4); //4면으로 쪼개서
				int key = Integer.parseInt(token[j],16); //16진수 10진수로 변환
				set.add(key); //중복 없이 set 삽입
			}
		}
		
		ArrayList<Integer> list = new ArrayList<>(set);
		Collections.sort(list); //set 원소 오름차순 정렬
		Collections.reverse(list); //내림차순으로 바꾸기
		
		return list.get(K-1); //K번째 큰 수 반환
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); //숫자 개수
			K = Integer.parseInt(st.nextToken()); //크기 순서
			set = new HashSet<>();
			st = new StringTokenizer(br.readLine()); //N개의 숫자
			String str = st.nextToken();
			
			sb.append("#"+t+" "+spin(str)+"\n");
		}
		System.out.println(sb);
	}

}

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //접시의 수
		int d = Integer.parseInt(st.nextToken()); //초밥의 가짓수
		int k = Integer.parseInt(st.nextToken()); //연속해서 먹는 접시 수
		int c = Integer.parseInt(st.nextToken()); //쿠폰 번호
		
		//회전 초밥 배열
		int[] sushi = new int[N];
		//먹은 초밥 체크 배열
		int[] eat = new int[d+1];
		int result = 0; //최댓값
		int cnt = 0;
		
		//초밥 입력 받기
		for(int i=0; i<N; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}
		
		//초기 윈도우 설정
		for(int i=0; i<k; i++) {
			//다른 종류 초밥을 먹었을 경우
			if(eat[sushi[i]]==0) {
				cnt++; //먹은 초밥 종류 증가
			}
			eat[sushi[i]]++; //먹은 초밥 가짓수,개수 카운트
		}
		//쿠폰 초밥 먹은 여부에 따른 초기 최댓값 설정
		result = eat[c]==0 ? cnt+1:cnt;
		
		//슬라이딩 윈도우
		for(int i=1; i<N; i++) {
			//왼쪽 포인터 (제거할 초밥)
			int left = i-1;
			//오른쪽 포인터 (추가할 초밥)
			int right = (i+k-1)%N; //회전초밥이므로 배열 범위 벗어나는 것 고려
			
			//초밥 제거
			eat[sushi[left]]--;
			if(eat[sushi[left]]==0) { //먹은 개수 0일 경우
				cnt--; //가짓수 제거
			}
			
			//초밥 추가
			eat[sushi[right]]++;
			if(eat[sushi[right]]==1) { //먹은 개수 1일 경우
				cnt++; //가짓수 추가
			}
			
			//쿠폰 초밥 고려해서 최댓값 갱신
			result = Math.max(result, eat[c]==0 ? cnt+1:cnt);
		}
		System.out.println(result);
	}

}

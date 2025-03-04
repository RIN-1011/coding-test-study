import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); //수열 크기
		
		//수열 A 입력받기
		int a[] = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}

		int list[] = new int[N]; //LIS
		list[0] = a[0]; //시작값
		int len = 1; //수열 길이
		for(int i=1; i<N; i++) {
			int now = a[i]; //현재 탐색값
			
			//현재 값이 수열 마지막 원소보다 클 경우
			if(list[len-1]<now) {
				len++; //길이 증가
				list[len-1] = now; //값 추가
			}
			//작거나 같을 경우
			else {
				int left = 0;
				int right = len-1;
				
				//현재 탐색값보다 큰 수 중에서 제일 작은 수 찾기
				while(left<right) {
					int mid = (left+right)/2;
					
					//현재 값보다 mid가 작을 경우
					if(list[mid] < now) {
						left = mid+1; //왼쪽 당기기
					}
					else {
						right = mid; //오른쪽 당기기
					}
				}
				
				//현재 탐색값과  left 자리 값 대체하기
				list[left] = now;
			}
		}
		System.out.println(len);
	}

}

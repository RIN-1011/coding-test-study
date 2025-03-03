import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //집의 개수
		int C = Integer.parseInt(st.nextToken()); //공유기의 개수
		
		//집 좌표 입력 받기
		int arr[] = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr); //이분 탐색을 위한 배열 정렬 (오름차순)
		
		int left = 1; //최소 간격
		int right = arr[N-1]; //최대 간격
		while(left<=right) {
			int mid = (left+right)/2; //거리 중간값 (기준 거리)
			
			int cnt = 1; //공유기 설치 개수
			int pos = 0;
			for(int i=1; i<N; i++) {
				//좌표 간격이 기준 거리보다 같거나 클 경우
				if(arr[i]-arr[pos] >= mid) {
					cnt++; //공유기 설치
					pos = i; //기준점 갱신
				}
			}
			//공유기 설치 완료
			//공유기 설치 개수가 공유기 개수보다 적은 경우
			if(cnt < C) {
				right = mid-1; //기준 거리 좁히기
				continue;
			}
			//공유기 설치 개수가 공유기 개수보다 많을 경우
			left = mid+1; //기준 거리 늘리기
		}
		System.out.println(left-1);
	}

}

import java.util.*;
import java.io.*;

//수들의 합2
public class _2003 {

	public static void main(String[] args) throws IOException{
		//입력 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N, M;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int arr[] = new int[N];
		
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st1.nextToken());
		}
		
		int sum, cnt = 0;
		
		//앞에서부터 M 숫자가 채워지면 카운트 증가
		for(int i=0; i<N; i++) {
			sum = 0; //초기화
			for(int j=i; j<N; j++) {
				sum += arr[j];
				if(sum == M) { //수들의 합이 M과 같아진 경우
					cnt++;
				}
				else if(sum > M) { //수들의 합이 M보다 커진 경우
					continue; //이미 M 초과했으므로 넘어가기 //break 쓰기
				}
			}
		}
		System.out.println(cnt);
		
	}

}

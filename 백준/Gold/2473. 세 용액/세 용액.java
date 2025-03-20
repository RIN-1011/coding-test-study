import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		//용액 배열
		long arr[] = new long[N];
		for(int i=0; i<N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(arr); //오름차순 정렬
		
		long min = Long.MAX_VALUE; //0에 가까운 값
		long a=0, b=0, c=0; //결과값
		//i인덱스 고정
		for(int i=0; i<N; i++) {
			int left = i+1; //왼쪽 포인터
			int right = N-1; //오른쪽 포인터
			
			while(left<right) {
				long sum = arr[i]+arr[left]+arr[right];
				
				//가까운 값 비교
				if(Math.abs(sum)<min) {
					min = Math.abs(sum);
					a = arr[i];
					b = arr[left];
					c = arr[right];
				}
				
				//세 용액의 합이 0보다 작을 경우
				if(sum<0) {
					//left값 키우기
					left++;
				}
				//세 용액의 합이 0보다 클 경우
				else if(sum>0) {
					//right 줄이기
					right--;
				}
				//세 용액의 합이 0일 경우
				else {
					break;
				}
			}
		}
		System.out.println(a+" "+b+" "+c);
	}

}

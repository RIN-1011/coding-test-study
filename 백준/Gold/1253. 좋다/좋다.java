import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		long arr[] = new long[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(arr); //오름차순 정렬
		
		int cnt = 0; //좋은 수 개수
		for(int i=0; i<N; i++) {
			int left = 0;
			int right = N-1;
			
			while(left<right) {
				//자기 자신 제외
				if(left==i) {
					left++;
					continue;
				}
				if(right==i) {
					right--;
					continue;
				}
				
				//좋은 수일 경우
				if(arr[left]+arr[right]==arr[i]) {
					cnt++;
					break;
				}
				//두 수의 합이 더 작을 경우
				else if(arr[left]+arr[right]<arr[i]) {
					left++; //왼쪽 포인터 오른쪽으로
				}
				//두 수의 합이 더 클 경우
				else {
					right--; //오른쪽 포인터 왼쪽으로
				}
			}
		}
		System.out.println(cnt);
	}

}

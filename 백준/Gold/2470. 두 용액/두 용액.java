import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); //전체 용액의 수
		//용액 특성값 입력 받기
		st = new StringTokenizer(br.readLine());
		long[] arr = new long[N];
		for(int i=0; i<N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		
		int max=0, min=0; //산성, 알칼리성
		long diff = Long.MAX_VALUE; //특성값 차이
		
		int left = 0; //왼쪽 포인터
		int right = N-1; //오른쪽 포인터
		
		Arrays.sort(arr); //오름차순 정렬
		
		while(left<right) {
			long tmp = arr[left]+arr[right]; //차이
			
			//tmp가 diff보다 0에 가까울 경우 갱신
			if(Math.abs(tmp-0)<Math.abs(diff-0)) {
				diff = tmp;
				max = right;
				min = left;
			}
			//차이가 0보다 클 경우(양수일경우)
			if(tmp>0) {
				right--; //오른쪽 포인터 왼쪽으로 옮기기 (산성값 줄이기)
			}
			//차이가 0보다 작을 경우(음수일경우)
			else if(tmp<0) {
				left++; //왼쪽 포인터 오른쪽으로 옮기기 (알칼리성 키우기)
			}
			//차이가 0일 경우
			else if(tmp==0) {
				break; //즉시 종료
			}
		}
		
		System.out.println(arr[min]+" "+arr[max]);
	}

}

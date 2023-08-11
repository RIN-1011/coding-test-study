import java.io.*;
import java.util.*;

//에라토스테네스의 체
public class _2960 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		//2~N까지 삽입
		int arr[] = new int[N+1];
		for(int i=2; i<=N; i++) {
			arr[i] = i;
		}
		
		int cnt = 0; //n번째 지우는 수
		
		//알고리즘
		for(int i=2; i<=N; i++) {
			if(arr[i] != 0) { //지우지 않았다면
				int P = arr[i]; //가장 작은 수 찾기
				for(int j=1; j<=N/i; j++) { //배수 순서대로 지우기 (배수 존재하는 수만큼 돌리기)
					if(arr[P*j] != 0) {
						arr[P*j] = 0; //배수 지우기
						cnt++; //지우는 횟수 카운팅
						
						if(cnt == K) { //K번째 지우는 수
							System.out.println(P*j);
							break;
						}
					}
				}
				
			}
		}
	}

}

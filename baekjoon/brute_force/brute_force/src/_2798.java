import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//블랙잭

public class _2798 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int N, M;
		
		//입력 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];
		
		String s = br.readLine();
		String[] str = s.split(" ");
		
		//int형 변환
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(str[i]);
		}
		
		//M과의 차이
		int diff = Integer.MAX_VALUE;
		//최종 합
		int sum = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=i+1; j<N; j++) {
				for(int k=j+1; k<N; k++) {
					int temp = arr[i] + arr[j] + arr[k]; //세 카드 합
					//M을 넘지 않으면서 최대한 가까운 경우
					if(M-temp>=0 && M-temp<diff) {
						sum = temp; //결과 반영
						diff = M - temp; //차 반영
					}
					
				}
			}
		}
		System.out.println(sum);
		
	}

}

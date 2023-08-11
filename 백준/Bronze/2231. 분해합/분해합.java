import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//분해합

public class _2231 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//입력 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int result = 0;
		
		for(int i=0; i<N; i++) {
			int sum = 0;
			int temp = i;
			
			sum += i; //자기 자신 더하기
			
			//자리수 각각 더하기
			while(temp != 0) {
				sum += temp%10; //끝 자리수부터 덧셈
				temp /= 10;
			}
			//분해합이 N과 같을 경우 가장 작은 생성자 출력
			if(sum == N) {
				result = i;
				break;
			}
		}
		System.out.println(result);
	}

}

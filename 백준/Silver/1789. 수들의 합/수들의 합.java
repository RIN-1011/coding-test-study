import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long S = Long.parseLong(br.readLine()); //자연수의 합
		
		long N = 0; //최댓값
		for(long i=1; i<=S; i++) { //제일 작은 양의 정수부터 차례대로 더하기
			//S에서 더해야 하는 숫자를 뺐을 때 현재 더한 숫자보다 커야 중복되지 않음
			if(S-i>i) { 
				S -= i;
				N++; //개수 추가
			}
			else {
				break;
			}
		}
		System.out.println(++N);
	}

}

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); //도시 개수
		
		long[] len = new long[N-1]; //도로의 길이
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N-1; i++) {
			len[i] = Integer.parseInt(st.nextToken());
		}
		
		long[] price = new long[N]; //리터당 가격
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			price[i] = Integer.parseInt(st.nextToken());
		}
		
		long min = price[0]; //최소 비용 초기화
		long result = 0; //총 최소 비용
		
		for(int i=0; i<N-1; i++) { //최소 비용 계산
			//현재 최소 비용보다 더 쌀 경우 갱신
			if(min > price[i]) {
				min = price[i];
			}
			result += min * len[i];
		}
		
		System.out.println(result);
	}

}

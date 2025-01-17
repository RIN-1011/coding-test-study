import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); //배달할 설탕 무게
		int result = 0; //봉지 개수
		
		while(N>0) {
			if(N%5==0) { //5킬로그램으로 나뉠 경우
				result += N/5; //5킬로그램 봉지 개수 추가
				N = 0;
				break;
			}
			else { //3킬로그램 봉지 개수 추가
				N-=3;
				result++;
			}
		}
		
		if(N!=0) { //나누어 떨어지지 않을 경우
			System.out.println(-1);
		}
		else {
			System.out.println(result);
		}
	}

}

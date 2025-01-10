import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); //정수의 개수
		st = new StringTokenizer(br.readLine());
		
		int[] array = new int[N]; //정수 배열
		//변수 초기화
		int min = Integer.parseInt(st.nextToken());//최솟값
		int max = min; //최댓값
		
		for(int i=0; i<N-1; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			
			if(max<tmp) { //최댓값 구하기
				max = tmp;
			}
			if(min>tmp) { //최솟값 구하기
				min = tmp;
			}
		}
		
		System.out.println(min + " " + max);
	}
}

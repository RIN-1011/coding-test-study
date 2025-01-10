import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); //정수의 개수
		st = new StringTokenizer(br.readLine());
		
		//변수 초기화
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		for(int i=0; i<N; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			min = Math.min(min, tmp);
			max = Math.max(max, tmp);
		}
		
		System.out.println(min + " " + max);
	}
}

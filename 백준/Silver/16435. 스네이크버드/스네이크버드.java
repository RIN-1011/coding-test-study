import java.util.*;
import java.io.*;

//스네이크버드
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //과일 개수
		int L = Integer.parseInt(st.nextToken()); //스네이크버드 초기 길이
		
		int fruits[] = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			fruits[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(fruits); //과일 오름차순 정렬
		for (int i = 0; i < N; i++) {
			if(fruits[i] <= L) { //과일을 먹을 수 있으면 (자신의 길이보다 작거나 같은 높이)
				L += 1; //길이 1 늘어남
			}
		}
		System.out.println(L);
	}

}

import java.util.*;
import java.io.*;

//N번째 큰 수
public class Main {

	public static void main(String[] args) throws IOException {
		//내림차순 우선순위 큐
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()); //입력 받기
			for(int j=0; j<N; j++) {
				pq.add(Integer.parseInt(st.nextToken())); //우선순위 큐에 삽입
			}
		}
		for(int i=0; i<N-1; i++) { //N-1개까지만 remove해야 N번째 큰 수 구함
			pq.remove();
		}
		System.out.println(pq.peek()); //최상단 요소 출력
		
		
	}

}

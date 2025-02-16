import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine()); //크기
		
		//수열 입력 (원소, 위치)
		Deque<int[]> q = new ArrayDeque<>();
		int[] result = new int[N]; //오큰수 결과 배열
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int n = Integer.parseInt(st.nextToken());
			
			if(i==0) { //첫 원소일 경우 바로 덱에 삽입
				q.add(new int[]{n, i});
			}
			else {
				//덱이 비어있지 않고 이전 원소보다 큰 경우 (오큰수)
				while(!q.isEmpty() && n>q.peekLast()[0]) {
					int pos = q.pollLast()[1]; //오큰수 찾은 원소 위치
					result[pos] = n;
				}
				q.add(new int[]{n, i});
			}
		}
		//오큰수 없는 경우
		while(!q.isEmpty()) {
			int pos = q.pollLast()[1];
			result[pos] = -1;
		}
		//결과 출력
		for(int i=0; i<N; i++) {
			sb.append(result[i]+" ");
		}
		System.out.println(sb);
	}

}

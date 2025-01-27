import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); //카드 개수
		int m = Integer.parseInt(st.nextToken()); //합체 횟수

		//우선순위 큐 선언 (오름차순)
		PriorityQueue<Long> q = new PriorityQueue<>();
		
		//카드 상태 오름차순 저장
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			q.add(Long.parseLong(st.nextToken()));
		}
		
		//카드 합체 횟수만큼 놀이 반복
		for(int i=0; i<m; i++) {
			//가장 작은 점수를 만들어야 하므로
			//큐에서 작은 순서대로 자연수 2개 추출
			long a = q.remove();
			long b = q.remove();
			
			long add = a+b; //카드 합체
			
			//카드 두 장에 덮어씌워서 큐에 다시 삽입
			q.add(add);
			q.add(add);
		}
		//최종 점수 계산
		long result = 0;
		while(!q.isEmpty()) {
			result += q.remove();
		}
		
		System.out.println(result);
	}

}

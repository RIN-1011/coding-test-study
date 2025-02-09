import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int i=0; i<T; i++) {
			String str = br.readLine(); //함수
			
			int len = Integer.parseInt(br.readLine()); //수의 개수
			
			String arr = br.readLine(); //원소
			arr = arr.replaceAll("[\\[\\]]", "").trim(); //대괄호 제거
			st = new StringTokenizer(arr, ","); //쉼표 제거
			
			Deque<Integer> q = new ArrayDeque<>();
			for(int j=0; j<len; j++) {
				q.add(Integer.parseInt(st.nextToken())); //덱에 원소 삽입
			}
			
			boolean direction = true; //방향(정방향 초기화)
			boolean flag = false; //에러 플래그
			
			//함수에 맞는 연산 처리
			for(int j=0; j<str.length(); j++) {
				//뒤집기
				if(str.charAt(j)=='R') {
					//방향 전환
					direction = !direction;
				}
				//버리기
				else {
					//큐 비어있는 경우 에러
					if(q.isEmpty()) {
						sb.append("error").append("\n");
						flag = true;
						break;
					}
					else {
						if(direction) { //정방향
							//선입선출
							q.poll();
						}
						else if(!direction) { //역방향
							//후입선출
							q.pollLast();
						}
					}
				}
			}
			//에러 아닌 경우
			if(!flag) {
				sb.append("[");
				while(!q.isEmpty()) {
					sb.append(direction ? q.poll():q.pollLast());
					if(!q.isEmpty()) sb.append(",");
				}
				sb.append("]").append("\n");
			}
		}
		System.out.println(sb);
	}

}

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine()); //크기
		
		//수열 A 입력받기
		Stack<Integer> s1 = new Stack<>();
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			s1.push(Integer.parseInt(st.nextToken()));
		}

		Stack<Integer> s2 = new Stack<>();
		Stack<Integer> result = new Stack();
		while(!s1.isEmpty()) {
			int n = s1.pop();
			
			//오큰수가 없을 경우
			if(s2.isEmpty()) {
				result.push(-1); //결과 삽입
				s2.push(n);
			}
			else {
				while(!s2.isEmpty()) {
					//오큰수 있는 경우
					if(n<s2.peek()) {
						result.push(s2.peek()); //결과 삽입
						s2.push(n);
						break;
					}
					//오큰수 찾을 때까지 pop
					else {
						s2.pop();
					}
				}
				//오큰수가 없을 경우
				if(s2.isEmpty()) {
					result.push(-1); //결과 삽입
					s2.push(n);
				}
			}
		}
		//결과 출력
		while(!result.isEmpty()) {
			sb.append(result.pop()+" ");
		}
		System.out.println(sb);
	}

}

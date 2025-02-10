import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine(); //문자열
		Deque<Character> leftQ = new ArrayDeque<>(); //왼쪽 덱
		Deque<Character> rightQ = new ArrayDeque<>(); //오른쪽 덱
		
		//왼쪽 덱에 문자 삽입
		for(int i=0; i<str.length(); i++) {
			leftQ.addLast(str.charAt(i));
		}
		
		int M = Integer.parseInt(br.readLine()); //명령어 개수
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine()); //명령어 입력
			String command = st.nextToken(); //명령어
			
			switch(command.charAt(0)) {
			//커서 왼쪽 옮김
			case 'L':
				if(!leftQ.isEmpty()) {
					rightQ.addLast(leftQ.pollLast());
				}
				
				break;
			//커서 오른쪽 옮김
			case 'D':
				if(!rightQ.isEmpty()) {
					leftQ.addLast(rightQ.pollLast());
				}
				
				break;
			//커서 왼쪽 문자 삭제
			case 'B':
				if(!leftQ.isEmpty()) {
					leftQ.pollLast();
				}
				
				break;
			//커서 왼쪽 문자 추가
			case 'P':
				String c = st.nextToken();
				leftQ.addLast(c.charAt(0));
				
				break;
			}
		}
		
		//결과 출력
		while(!leftQ.isEmpty()) {
			//왼쪽 덱은 선입선출
			sb.append(leftQ.pollFirst());
		}
		while(!rightQ.isEmpty()) {
			//오른쪽 덱은 후입선출
			sb.append(rightQ.pollLast());
		}
		
		System.out.println(sb);
	}

}

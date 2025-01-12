import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine()); //명령의 수
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			String str = st.nextToken(); //명령
			if(str.equals("push")) {
				stack.add(Integer.parseInt(st.nextToken())); //스택에 정수 삽입
			}
			else if(str.equals("pop")) {
				if(stack.isEmpty()) { //스택이 비어있는 경우
					sb.append(-1).append("\n");
				}
				else {
					sb.append(stack.pop()).append("\n"); //가장 위에 있는 정수 출력
				}
			}
			else if(str.equals("size")) {
				sb.append(stack.size()).append("\n"); //스택 정수 개수 출력
			}
			else if(str.equals("empty")) {
				if(stack.isEmpty()) { //스택 비어있는 경우
					sb.append(1).append("\n");
				}
				else { //아닌 경우
					sb.append(0).append("\n");
				}
			}
			else if(str.equals("top")) {
				if(stack.isEmpty()) { //스택 비어있는 경우
					sb.append(-1).append("\n");
				}
				else {
					sb.append(stack.peek()).append("\n"); //스택 가장 위에 있는 정수 출력					
				}
			}
		}
		System.out.println(sb);
	}

}

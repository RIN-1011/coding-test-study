import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine()); //명령의 수
		Queue<Integer> queue = new LinkedList<>(); //큐 선언
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken(); //명령
			
			if("push".equals(str)) {
				queue.add(Integer.parseInt(st.nextToken())); //정수 삽입
			}
			else if("pop".equals(str)) {
				if(queue.isEmpty()) { //큐 비어있는 경우
					sb.append(-1).append("\n");
				}
				else {
					sb.append(queue.remove()).append("\n");
				}
			}
			else if("size".equals(str)) {
				sb.append(queue.size()).append("\n");
			}
			else if("empty".equals(str)) {
				if(queue.isEmpty()) { //큐 비어있는 경우
					sb.append(1).append("\n");
				}
				else {
					sb.append(0).append("\n");
				}
			}
			else if("front".equals(str)) {
				if(queue.isEmpty()) { //큐 비어있는 경우
					sb.append(-1).append("\n");
				}
				else {
					sb.append(queue.peek()).append("\n");
				}
			}
			else if("back".equals(str)) {
				if(queue.isEmpty()) { //큐 비어있는 경우
					sb.append(-1).append("\n");
				}
				else {
					sb.append(((LinkedList<Integer>) queue).getLast()).append("\n");
				}
			}
		}
		System.out.println(sb);
	}

}

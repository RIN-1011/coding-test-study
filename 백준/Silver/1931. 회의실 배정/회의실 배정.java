import java.util.*;
import java.io.*;

class Meeting implements Comparable<Meeting>{
	int start; //시작시간
	int end; //끝나는 시간
	
	public Meeting(int start, int end) {
		this.start = start;
		this.end = end;
	}

	//시작시간 빠른 순서대로 정렬
	@Override
	public int compareTo(Meeting o) {
		//시작시간 같을 경우 빨리 끝나는 순서대로 정렬
		if(this.start-o.start==0) {
			return this.end-o.end;
		}
		return this.start-o.start;
	}
}
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); //회의의 수
		//시작시간 빠른 순서대로 정렬하기 위한 우선순위 큐
		PriorityQueue<Meeting> q = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			q.add(new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		//사용할 수 있는 회의를 저장한 stack
		Stack<Meeting> stack = new Stack<>();
		for (int i = 0; i < N; i++) {
			Meeting meeting = q.remove();
			//스택 비어있으면 초기값 삽입
			if(stack.isEmpty()) {
				stack.push(meeting);
				continue;
			}
			
			//1. 스택에 먼저 저장된 회의가 현재 회의보다 늦게 끝날 경우 지우기
			if(stack.peek().end > meeting.end) {
				stack.pop();
				stack.push(meeting); //현재 회의 삽입
			}
			//2. 스택에 먼저 저장된 회의가 끝나고 현재 회의가 시작하면 삽입
			else if(stack.peek().end <= meeting.start) {
				stack.push(meeting); //현재 회의 삽입
			}
		}
		System.out.println(stack.size());
	}

}

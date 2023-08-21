import java.io.*;
import java.util.*;

class Task { //업무
	int score; //점수
	int min; //소요시간
	
	public Task(int score, int min) {
		this.score = score;
		this.min = min;
	}
}
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		Stack<Task> stack = new Stack<>(); //업무 저장용 stack
		int result = 0; //이번 분기 업무 평가 점수
		
		int N = Integer.parseInt(br.readLine()); //이번 분기 분 수
		for (int t = 0; t < N; t++) {
			st = new StringTokenizer(br.readLine());
			int flag = Integer.parseInt(st.nextToken()); //업무 여부
			
			if(flag == 1) { //업무가 새로 주어졌을 경우
				int score = Integer.parseInt(st.nextToken()); //점수
				int min = Integer.parseInt(st.nextToken()); //소요시간
				min -= 1; //업무 받자마자 시작
				if(min == 0) { //업무 끝났을 경우
					result += score; //업무 평가 점수 얻음
				}
				else { //업무 안끝났을 경우
					stack.push(new Task(score, min)); //stack 삽입
				}
			}
			else { //업무가 주어지지 않았을 경우
				if(!stack.isEmpty()) { //업무 없는 경우 오류 방지
					//이전에 하던 업무 이어서 하기
					Task task = stack.pop();
					task.min = task.min-1;
					if(task.min == 0) { //업무 끝났을 경우
						result += task.score; //업무 평가 점수 얻음
					}
					else { //업무 안끝났을 경우
						stack.push(task); //이어서 하기 위해 stack 저장
					}
				}
			}
		}
		System.out.println(result);
	}
}
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine()); //연산 개수
	
		PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1-o2;
			}
		}); //오름차순 우선순위 큐 선언
		
		for(int i=0; i<N; i++) {
			int oper = Integer.parseInt(br.readLine());
			if(oper==0) { //가장 작은 값 출력
				if(!q.isEmpty()) { //비어있지 않은 경우
					sb.append(q.remove()).append("\n"); //가장 작은 값 출력 후 제거
				}
				else { //비어있는 경우
					sb.append(0).append("\n");
				}
			}
			else { //값 삽입
				q.add(oper);
			}
		}
		
		System.out.println(sb);
	}

}

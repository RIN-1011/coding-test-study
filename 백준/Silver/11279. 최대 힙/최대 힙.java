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
				return o2-o1; //내림차순 정렬
			}
		});
		//연산 반복
		for(int i=0; i<N; i++) {
			int oper = Integer.parseInt(br.readLine()); //연산
			
			if(oper==0) { //배열에서 가장 큰 값 출력 후 제거
				if(q.isEmpty()) { //배열 비어있는 경우
					sb.append(0).append("\n"); //0 출력
				}
				else {
					sb.append(q.remove()).append("\n"); //가장 큰 값 출력
				}
			}
			else { //배열에 값 삽입
				q.add(oper);
			}
		}
		System.out.println(sb);
	}

}

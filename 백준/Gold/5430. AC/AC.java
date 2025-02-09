import java.util.*;
import java.util.stream.Collectors;
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
			
			int d = 1; //방향(정방향 초기화)
			boolean flag = false; //에러 플래그
			
			//함수에 맞는 연산 처리
			for(int j=0; j<str.length(); j++) {
				//뒤집기
				if(str.charAt(j)=='R') {
					//방향 전환
					if(d==-1) d=1;
					else d=-1;
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
						if(d==1) { //정방향
							//선입선출
							q.poll();
						}
						else if(d==-1) { //역방향
							//후입선출
							q.pollLast();
						}
					}
				}
			}
			//에러 아닌 경우
			if(!flag) {
				//정방향 결과 출력
				if(d==1) {
					String result = "[" + String.join(",", q.stream()
                            .map(String::valueOf)
                            .collect(Collectors.toList())) + "]";
					sb.append(result).append("\n");
				}
				//역방향 결과 출력
				else if(d==-1) {
					List<Integer> list = new ArrayList<>(q);
					Collections.reverse(list);
					String result = "[" + String.join(",", list.stream()
                            .map(String::valueOf)
                            .toArray(String[]::new)) + "]";
					sb.append(result).append("\n");
				}
			}
		}
		System.out.println(sb);
	}

}

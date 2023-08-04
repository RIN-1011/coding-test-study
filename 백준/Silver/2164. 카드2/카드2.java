import java.util.*;
import java.io.*;

//카드2
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<>();
		
		for(int i=1; i<=N; i++) {
			q.add(i);
		}
		
		while(q.size() > 1) { //큐 사이즈가 1이 되면 반복 멈추고 결과 출력
			//제일 위 카드 버리기
			q.remove();
			//그 다음 제일 위 카드 제일 아래로 옮기기
			int tmp = q.remove();
			q.add(tmp);
		}
		System.out.println(q.remove());
	}

}

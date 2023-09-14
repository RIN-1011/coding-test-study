import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine()); //도시의 개수
		//도로 길이
		st = new StringTokenizer(br.readLine());
		Queue<Integer> length = new LinkedList<>();
		for (int i = 0; i < N-1; i++) {
			length.add(Integer.parseInt(st.nextToken()));
		}
		//각 도시 주유소 리터당 가격
		st = new StringTokenizer(br.readLine());
		Queue<Integer> cost = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			cost.add(Integer.parseInt(st.nextToken()));
		}
		
		int result = 0; //최소 비용
		while(!length.isEmpty()) {
			int nowCost = cost.remove(); //가장 왼쪽 도시
			result += nowCost*length.remove(); //거리만큼 기름 충전
			//현재 비용이 그 다음 도시 비용보다 싸다면 현재 도시에서 기름 충전하기
			while(cost.peek()>nowCost) {
				result += nowCost*length.remove();
				cost.remove();
			}
		}
		System.out.println(result);
	}

}

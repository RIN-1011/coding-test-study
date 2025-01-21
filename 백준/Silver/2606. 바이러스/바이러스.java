import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); //컴퓨터 수
		int M = Integer.parseInt(br.readLine()); //연결 수
		
		//초기화
		ArrayList<ArrayList<Integer>> network = new ArrayList<>();
		for(int i=0; i<=N; i++) {
			network.add(new ArrayList<>());
		}
		
		//네트워크 정보
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			//정보 저장
			network.get(a).add(b);
			network.get(b).add(a);
		}

		//BFS
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[N+1];
		
		q.add(1); //1번 컴퓨터
		visited[1] = true;
		
		int result = 0; //결과
		
		while(!q.isEmpty()) {
			int p = q.remove();
			//연결된 컴퓨터 확인
			for(int i=0; i<network.get(p).size(); i++) {
				int worm = network.get(p).get(i); //연결된 컴퓨터
				if(!visited[worm]) { //아직 방문하지 않았을 경우
					q.add(worm);
					visited[worm] = true; //방문 처리
					result++; //바이러스 감염
				}
			}
		}
		
		System.out.println(result);
	}

}

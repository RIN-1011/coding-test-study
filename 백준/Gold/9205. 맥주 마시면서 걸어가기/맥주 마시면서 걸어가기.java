import java.util.*;
import java.io.*;

class Point {
	int x;
	int y;
	
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}
public class Main {
	static int n;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine()); //테케 개수
		for (int t = 0; t < T; t++) {
			n = Integer.parseInt(br.readLine()); //편의점의 개수
			
			st = new StringTokenizer(br.readLine());
			Point home = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			ArrayList<Point> store = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				store.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}
			
			st = new StringTokenizer(br.readLine());
			Point end = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			//시작점
			Queue<Point> q = new ArrayDeque<Point>();
			q.add(home);
			
			String flag = "sad"; //성공 여부
			boolean[] visited = new boolean[n]; //편의점 방문 여부
			
			while(!q.isEmpty()) {
				Point p = q.poll();
				
				//도착지점까지 1000미터 이하인 경우 성공 (맥주20개 x 50미터)
				if(Math.abs(p.x-end.x)+Math.abs(p.y-end.y)<=1000) {
					flag = "happy";
					break;
				}
				
				for (int i = 0; i < store.size(); i++) {
					//이미 방문했을 경우 패스
					if(visited[i]) {
						continue;
					}
					int x = store.get(i).x;
					int y = store.get(i).y;
					//현재 지점과 다음 편의점 사이의 거리가 1000미터 이하인 경우
					if(Math.abs(p.x-x)+Math.abs(p.y-y)<=1000) {
						visited[i] = true;
						q.add(new Point(x, y));
					}
				}
			}
			
			sb.append(flag).append("\n");
		}
		System.out.println(sb);
	}

}

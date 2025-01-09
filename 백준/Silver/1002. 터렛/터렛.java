import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine()); //테스트 케이스 개수
		
		for(int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			
			//[두 원 사이의 위치 관계]
			//두 좌표 거리 계산
			int d = (int)(Math.pow(x1-x2, 2)+Math.pow(y1-y2, 2));
			
			//1.무한대 점에서 만나는 경우
			if(x1==x2 && y1==y2 && r1==r2) {
				sb.append(-1).append("\n");
			}
			
			//2.만나지 않는 경우
			//2-1)외부에서 만나지 않을 때
			else if(d>Math.pow(r1+r2, 2)) {
				sb.append(0).append("\n");
			}
			//2-2)내부에서 만나지 않을 때
			else if(d<Math.pow(r1-r2,2)) {
				sb.append(0).append("\n");
			}
			//2-3)동심원일 때
			else if(d==0 && r1!=r2) {
				sb.append(0).append("\n");
			}
			
			//3.한 점에서 만나는 경우
			//3-1)외접할 때
			else if(d==Math.pow(r1+r2,2)) {
				sb.append(1).append("\n");
			}
			//3-2)내접할 때
			else if(d==Math.pow(r1-r2,2)) {
				sb.append(1).append("\n");
			}
			
			//4.두 점에서 만나는 경우
			else {
				sb.append(2).append("\n");
			}
		}
		System.out.print(sb);
	}

}

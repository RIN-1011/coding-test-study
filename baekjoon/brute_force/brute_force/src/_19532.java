import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _19532 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		//입력 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a, b, c, d, e, f;
		
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		f = Integer.parseInt(st.nextToken());
		
		//해가 될 수 있는 모든 수 탐색
		for(int x=-999; x<1000; x++) {
			for(int y=-999; y<1000; y++) {
				//방정식 해결되면 답 출력
				if((a*x+b*y == c) && (d*x+e*y == f)) {
					System.out.println(x + " " + y);
					break;
				}
			}
		}
	}
}

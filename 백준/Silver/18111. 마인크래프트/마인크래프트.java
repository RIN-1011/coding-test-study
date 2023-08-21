import java.util.*;
import java.io.*;

//마인크래프트
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //행
		int M = Integer.parseInt(st.nextToken()); //열
		int B = Integer.parseInt(st.nextToken()); //인벤토리 블록 개수
		
		int[][] map = new int[N][M]; //땅 높이
		int min = Integer.MAX_VALUE; //최저 높이
		int max = Integer.MIN_VALUE; //최고 높이
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				min = Math.min(min, map[i][j]); //최저 높이 저장
				max = Math.max(max, map[i][j]); //최고 높이 저장
			}
		}
		//모든 땅 높이를 최저 높이~최고 높이로 맞추어서 최소 시간, 땅 높이 구하기
		int time = Integer.MAX_VALUE; //최소 시간
		int height = 0; //땅 높이

		for (int t = min; t <= max; t++) {
			int tmp = B; //인벤토리 블록 개수 초기화
			int tmpTime = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					//맞춰야 하는 높이보다 현재 높이가 클 경우
					if(map[i][j] > t) {
						int cnt = map[i][j]-t; //높이 깎아주기
						tmp += cnt; //깎은 만큼 블록 인벤토리 저장
						tmpTime += cnt*2; //2초 소요
					}
					//맞춰야 하는 높이보다 현재 높이가 작을 경우
					else if(map[i][j] < t) {
						int cnt = t-map[i][j]; //높이 더해주기
						tmp -= cnt; //더한 만큼 블록 인벤토리 감소
						tmpTime += cnt; //1초 소요
					}
				}
			}
			//땅 높이 256 이하, 인벤토리 블록 양수일 경우 옳은 작업
			if(t<=256 && tmp>=0) {
				if(time >= tmpTime) { //최소 시간 갱신
					time = tmpTime; //최소 시간
					height = Math.max(height, t); //땅 높이
				}
			}
		}
		System.out.println(time + " " + height);
	}

}

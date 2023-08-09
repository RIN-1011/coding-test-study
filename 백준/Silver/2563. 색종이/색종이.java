import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); //색종이 개수
		int[][] arr = new int[101][101];
		int cnt=0;
		
		for(int t=0; t<N; t++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			
			//10*10 정사각형 검은 영역으로 칠하기
			for(int i=x; i<x+10; i++) {
				for(int j=y; j<y+10; j++) {
					arr[i][j] = 1; //칠하기
				}
			}
		}
		
		for(int i=1; i<101; i++) {
			for(int j=1; j<101; j++) {
				if(arr[i][j] == 1) {
					cnt++; //검은 영역 카운팅
				}
			}
		}
		System.out.println(cnt);
	}

}

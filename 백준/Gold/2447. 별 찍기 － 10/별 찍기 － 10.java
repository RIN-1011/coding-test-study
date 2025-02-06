import java.util.*;
import java.io.*;

public class Main {
	static char[][] star;
	
	static void dfs(int N, int col, int row) {
		//가장 작은 단위
		if(N==3) {
			for(int i=0; i<3; i++) {
				for(int j=0; j<3; j++) {
					//가운데 공백
					if(i==1 && j==1) {
						continue;
					}
					//나머지 별
					star[col+i][row+j] = '*';
				}
			}
		}
		else {
			int next = N/3; //다음 크기
			for(int i=0; i<3; i++) {
				for(int j=0; j<3; j++) {
					//가운데 공백
					if(i==1 && j==1) {
						continue;
					}
					else {
						//자리에 맞게 추가하기 위해 col, row 값 더해주기
						dfs(next, col+(i*next), row+(j*next));
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine()); //정수
		
		star = new char[N][N]; //별 배열
		for(int i=0; i<N; i++) {
			Arrays.fill(star[i], ' '); //공백으로 초기화
		}
		
		dfs(N, 0, 0);
		
		//결과 출력
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				sb.append(star[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}

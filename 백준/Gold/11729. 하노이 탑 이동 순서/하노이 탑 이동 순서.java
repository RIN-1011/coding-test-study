import java.util.*;
import java.io.*;

public class Main {
	static int cnt;
	static StringBuilder sb;
	
	//남은 원판 개수, 시작 장대, 중간 장대, 도착 장대
	static void dfs(int N, int from, int mid, int to) {
		//원판 1개일 경우 1에서 3으로 이동
		if(N==1) {
			sb.append(from+" "+to).append("\n");
			cnt++; //이동 횟수 추가
			return;
		}
		
		dfs(N-1, from, to, mid); //N-1개의 원판이 1에서 2로 이동
		sb.append(from+" "+to).append("\n"); //남은 1개 원판 1에서 3으로 이동
		cnt++; //이동 횟수 추가
		dfs(N-1, mid, from, to); //N-1개의 원판이 2에서 3으로 이동
	}

	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 sb = new StringBuilder();
		 int N = Integer.parseInt(br.readLine()); //원판의 개수
		 
		 cnt = 0;
		 
		 dfs(N, 1, 2, 3);
		 
		 System.out.println(cnt); //옮긴 횟수
		 System.out.println(sb);
	}

}

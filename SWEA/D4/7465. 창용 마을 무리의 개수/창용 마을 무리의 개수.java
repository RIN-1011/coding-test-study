import java.util.*;
import java.io.*;

public class Solution {
	static int N, M;
	static int[] p; //루트 노드
	
	public static int find(int a) {
		//루트 노드 찾았을 경우 반환
		if(p[a] == a) {
			return a;
		}
		return p[a] = find(p[a]);
	}
	
	public static boolean union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		
		//이미 같은 무리인 경우 패스
		if(pa == pb) {
			return false;
		}
		
		p[pa] = pb; //같은 무리로 묶기
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine()); //테케 개수
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); //사람 수
			M = Integer.parseInt(st.nextToken()); //관계 수
			
			//make-set
			p = new int[N+1];
			for (int j = 1; j <= N; j++) {
				p[j] = j;
			}
			
			int result = N;
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				//a, b 사람 서로 아는 존재
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				//같은 무리가 아니었다면 무리에 포함하고 카운트 감소
				if(union(a, b)) {
					result--;
				}
			}
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}

}

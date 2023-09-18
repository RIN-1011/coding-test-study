import java.io.*;
import java.util.*;

//창용마을무리의개수
public class Solution {
	static int[] p; //루트 배열
	
	public static int find(int a) {
		if(a==p[a]) { //루트까지 올라갔다면
			return a; //루트 반환
		}
		return p[a]=find(p[a]);
	}
	
	public static boolean union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		
		if(pa==pb) { //이미 같은 그룹일 경우 false
			return false;
		}
		p[pa] = pb; //union (같은 무리로 묶기)
		return true;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine()); //테스트 케이스 개수
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); //마을에 사는 사람 수
			int M = Integer.parseInt(st.nextToken()); //사람의 관계 수
			
			//make-set
			p = new int[N+1];
			for (int i = 1; i <= N; i++) {
				p[i] = i;
			}
			
			int cnt = N; //마을 사는 사람 수만큼 카운트 초기화 
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				//같은 그룹이 아니라면 무리에 포함하고 카운트 감소
				if(union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))) {
					cnt--;
				}
			}
			sb.append("#").append(t).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb);
		br.close();
	}

}

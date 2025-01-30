import java.util.*;
import java.io.*;

public class Main {
	static int N, K, min;
	static int[] sec;
	
	static void bfs() { //0-1 BFS
		Queue<Integer> q = new LinkedList<>(); //방문 위치 저장
		q.add(N); //시작 위치
		sec[N] = 0; //시작 위치 시간 0초
		
		while(!q.isEmpty()) {
			int x = q.poll();
			
			if(x==K) { //동생 찾았을 경우
				System.out.println(sec[x]); //결과 출력
				return;
			}
			
			if(x*2<=100000 && sec[x*2]>sec[x]) { //x*2시간보다 x시간이 짧을 경우
				sec[x*2] = sec[x]; //시간 갱신
				q.add(x*2); //이동 위치 큐 저장
			}
			
			if(x-1>=0 && sec[x-1]>sec[x]+1) { //x-1시간보다 x에서 1초 더한 시간이 짧을 경우
				sec[x-1] = sec[x]+1; //시간 갱신
				q.add(x-1); //이동 위치 큐 저장
			}
			
			if(x+1<=100000 && sec[x+1]>sec[x]+1) { //x+1시간보다 x에서 1초 더한 시간이 짧을 경우
				sec[x+1] = sec[x]+1; //시간 갱신
				q.add(x+1); //이동 위치 큐 저장
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //수빈 위치
		K = Integer.parseInt(st.nextToken()); //동생 위치
		
		sec = new int[100001];
		Arrays.fill(sec, Integer.MAX_VALUE); //모든 위치 최대 시간으로 설정
		
		bfs();
	}

}

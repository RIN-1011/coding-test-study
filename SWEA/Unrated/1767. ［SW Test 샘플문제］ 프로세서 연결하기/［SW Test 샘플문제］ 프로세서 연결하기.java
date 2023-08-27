import java.util.*;
import java.io.*;

//[SW Test 샘플문제] 프로세서 연결하기
class Core {
	int x;
	int y;
	Core(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class Solution {
	static int numbers[]; //멕시노스 조합
	static int input[]; //조합할 멕시노스 인덱스
	
	static int N; //멕시노스 배열 크기
	static int mexinos[][]; //멕시노스 초기 상태
	static ArrayList<Core> core; //코어 저장 리스트
	static int min; //최소 전선 길이
	
	//상하좌우
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void combination(int M, int cnt, int start) {
		if(cnt == M) { //조합 완성
			//조합으로 뽑힌 멕시노스 연결되도록 전선 깔기
			dfs(M, 0, 0);
			return;
		}
		else {
			for (int i = start; i < input.length; i++) {
				numbers[cnt] = input[i];
				combination(M, cnt+1, i+1);
			}
		}
		
	}
	//전선 깔기 (M개 조합, 조합할 코어 인덱스, 전선 길이)
	public static void dfs(int M, int m, int minTmp) {
		//M개의 코어 만큼 전선 연결했을 경우
		if(m == M) {
			min = Math.min(min, minTmp); //최솟값 갱신
			return;
		}
		//core 있는 곳부터 상하좌우 전선 깔아보기
		for (int i = 0; i < 4; i++) {
			int x = core.get(numbers[m]).x;
			int y = core.get(numbers[m]).y;
			
			boolean flag = false; //전선 깔기 성공 여부
			while(true) {
				//상하좌우 전선 깔기
				x += dx[i];
				y += dy[i];
				//전선이 범위를 벗어났다는건 끝까지 연결했다는 의미
				if(x<0 || x>=N || y<0 || y>=N) {
					flag = true;
					break;
				}
				//전선 깔 수 없는 경우 실패
				if(mexinos[x][y]!=0) {
					break;
				}
				mexinos[x][y] = 2; //전선 깔기
				minTmp++; //전선 길이 합 증가
			}
			//전선 깔기 성공했을 경우 다른 코어로 넘어감
			if(flag) {
				dfs(M, m+1, minTmp);
			}
			//다른 방향 탐색하기 위해 백트래킹
			while(true) {
				x -= dx[i];
				y -= dy[i];
				//원래대로 돌려놓았을 경우 멈추기
				if(x==core.get(numbers[m]).x && y==core.get(numbers[m]).y) {
					break;
				}
				mexinos[x][y] = 0;
				minTmp--;
			}
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine()); //테스트 케이스 수
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine()); //멕시노스 배열 크기
			mexinos = new int[N][N]; //멕시노스 초기 상태
			core = new ArrayList<Core>(); //코어 저장 리스트
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					mexinos[i][j] = Integer.parseInt(st.nextToken());
					//가장자리가 아니고
					if(i!=0 && i!=N-1 && j!=0 && j!= N-1) {
						//core일 경우
						if(mexinos[i][j] == 1) {
							core.add(new Core(i, j)); //코어 리스트 저장
						}
					}
				}
			}
			//조합할 core 리스트 인덱스 저장
			input = new int[core.size()];
			for (int i = 0; i < core.size(); i++) {
				input[i] = i;
			}
			min = Integer.MAX_VALUE;
			//가장 많은 코어 연결하는 순서부터 0개 뽑는 경우까지 생각
			for (int i = core.size(); i >= 0; i--) {
				numbers = new int[i]; //i개 원소 조합 만들기
				combination(i, 0, 0);
				if(min < Integer.MAX_VALUE) { //min이 갱신되었을 경우 최소 전선 길이 구해진 것이므로 break
					break;
				}
			}
			sb.append("#"+t+" "+min+"\n");
		}
		System.out.println(sb);
	}

}

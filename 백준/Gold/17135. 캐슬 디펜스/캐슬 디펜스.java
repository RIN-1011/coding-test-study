import java.util.*;
import java.io.*;

class Enemy implements Comparable<Enemy>{
	int x;
	int y;
	int distance;
	
	public Enemy(int x, int y, int distance) {
		super();
		this.x = x;
		this.y = y;
		this.distance = distance;
	}

	@Override
	public int compareTo(Enemy o) {
		//가장 가까운 적 먼저 공격, 거리 같으면 가장 왼쪽에 있는 적 공격
		if(this.distance == o.distance) {
			return this.y-o.y;
		}
		else {
			return this.distance - o.distance;
		}
	}
}
public class Main {
	static int N, M, D; //행, 열, 공격 거리 제한
	static int[][] map; //격자판
	static int[] archer; //궁수 위치(열)
	static List<int[]> enemy; //초기 적 위치
	static int max = Integer.MIN_VALUE; //제거할 수 있는 적 최대 수
	
	//궁수 위치 조합
	public static void comb(int cnt, int start) {
		//3명 다 배치했을 경우
		if(cnt==3) {
			//배열 복사
			List<int[]> copyList = new ArrayList<>();
			for (int i = 0; i < enemy.size(); i++) {
				int[] tmp = enemy.get(i);
				copyList.add(new int[] {tmp[0], tmp[1]});
			}
			//게임 시작
			game(copyList);
		}
		else {
			for (int i = start; i < M; i++) {
				archer[cnt] = i;
				comb(cnt+1, i+1);
			}
		}
	}
	
	public static void game(List<int[]> copyList) {
		int result = 0; //공격한 적의 수
		
		//모든 적이 격자판에서 제외되면 게임 끝
		while(!copyList.isEmpty()) {
			List<Enemy> target = new ArrayList<>(); //실제 공격할 적
			//궁수 3명
			for (int i = 0; i < 3; i++) {
				//공격할 적들 우선순위 순서대로 큐 삽입
				PriorityQueue<Enemy> q = new PriorityQueue<>();
				//적 거리 재기
				for (int j = 0; j < copyList.size(); j++) {
					int dis = Math.abs(N-copyList.get(j)[0])+Math.abs(archer[i]-copyList.get(j)[1]);
					//궁수가 공격하는 적은 거리가 D이하인 적
					if(dis<=D) {
						q.add(new Enemy(copyList.get(j)[0], copyList.get(j)[1], dis));
					}
				}
				if(!q.isEmpty()) {
					target.add(q.peek()); //가장 우선순위 높은 적 리스트에 추가
				}
			}
			//타겟과 동일한 적 공격하기
			for (int i = 0; i < target.size(); i++) {
				for (int j = 0; j < copyList.size(); j++) {
					if(copyList.get(j)[0]==target.get(i).x && copyList.get(j)[1]==target.get(i).y) {
						copyList.remove(j);
						result++;
					}
				}
			}
			//적 한 칸 아래로 이동
			for (int i = copyList.size() - 1; i >= 0; i--) {
				copyList.get(i)[0] += 1;
				//성이 있는 칸으로 이동한 경우 게임에서 제외
				if (copyList.get(i)[0] == N)
					copyList.remove(i);
			}
		}
		//최대값 갱신
		max = Math.max(max, result);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //행
		M = Integer.parseInt(st.nextToken()); //열
		D = Integer.parseInt(st.nextToken()); //공격 거리 제한
		
		map = new int[N][M]; //격자판
		enemy = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				//적 위치 리스트에 저장
				if(map[i][j] == 1) {
					enemy.add(new int[] {i, j});
				}
			}
		}
		
		archer = new int[M];
		comb(0, 0);
		
		System.out.println(max);
	}

}

import java.util.*;
import java.io.*;

//외판원 순회 2
public class Main {
	static int N; //도시의 수
	static int cost[][]; //비용 행렬
	static int numbers[]; //순열 완성 배열
	static boolean isSelected[]; //순열 선택 여부
	static int min = Integer.MAX_VALUE; //최소 비용
	
	//순열
	public static void per(int cnt) {
		if(cnt == N) {
			int sum = 0;
			for (int i = 0; i < N-1; i++) {
				//순열로 뽑힌 조합에서 i->i+1로 가는 경우가 없을 때 더이상 값 구하지 않기
				if(cost[numbers[i]][numbers[i+1]] == 0) {
					return;
				}
				//아니라면 비용 더하기
				sum += cost[numbers[i]][numbers[i+1]];
			}
			//순열로 뽑힌 조합에서 다시 원래의 도시로 돌아가는 경우가 없을 때 더이상 값 구하지 않기
			if(cost[numbers[N-1]][numbers[0]] == 0) {
				return;
			}
			//아니라면 비용 더하기
			sum += cost[numbers[N-1]][numbers[0]];
			//최소 비용 갱신
			min = Math.min(min, sum);
		}
		else {
			for (int i = 0; i < N; i++) {
				if(isSelected[i]) {
					continue;
				}
				else {
					numbers[cnt] = i;
					isSelected[i] = true;
					per(cnt+1);
					isSelected[i] = false;
				}
			}
		}
		return;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine()); //도시의 수
		//비용 행렬
		cost  = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//초기화
		numbers = new int[N];
		isSelected = new boolean[N];

		per(0);
		System.out.println(min);
	}

}

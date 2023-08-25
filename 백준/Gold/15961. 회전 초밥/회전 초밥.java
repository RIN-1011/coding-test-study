import java.util.*;
import java.io.*;

//회전 초밥
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //접시의 수
		int d = Integer.parseInt(st.nextToken()); //초밥의 가짓수
		int k = Integer.parseInt(st.nextToken()); //연속해서 먹는 접시의 수
		int c = Integer.parseInt(st.nextToken()); //쿠폰 번호
		//원본 배열 맨 뒤에 k-1만큼 값을 덧붙여줌
		//그래야 마지막으로 입력받은 접시에서부터 k개 까지 초밥 먹을 수 있음
		int belt[] = new int[N+k-1];
		for (int i = 0; i < N; i++) {
			belt[i] = Integer.parseInt(br.readLine());
		}
		for (int i = 0; i < k-1; i++) {
			belt[N+i] = belt[i];
		}
		
		int max = 0; //최대 초밥 종류
		int tmp = 0; //경우 별 초밥 종류
		int[] visited = new int[d+1]; //중복된 초밥 종류 체크용
		
		//시작점 종류 세어주기
		for (int i = 0; i < k; i++) {
			//먹은 초밥 종류가 아니라면
			if(visited[belt[i]] == 0) {
				tmp++; //종류 증가
			}
			visited[belt[i]]++; //같은 종류 초밥 증가
		}
		max = Math.max(max, tmp);
		
		//시작할 때 투 포인터(왼쪽, 오른쪽)
		int left = 0;
		int right = k-1;
		
		//시작점 제외하고 N-1 반복
		for (int i = 0; i < N-1; i++) {
			visited[belt[left]]--; //윈도우 이동하면서 제외되는 같은 초밥 종류 개수 빼주기
			if(visited[belt[left]] == 0) { //윈도우 안에 겹치는 초밥 종류가 아예 없을 경우
				tmp--; //종류 개수 빼주기
			}
			
			//윈도우 이동
			left++;
			right++;
			
			//새로 먹는 초밥이 아직 안먹은 종류의 초밥일 경우
			if(visited[belt[right]]==0) {
				tmp++; //종류 증가
			}
			visited[belt[right]]++; //같은 종류 초밥 증가
			
			//최대값 갱신
			if(tmp>=max) {
				//쿠폰 초밥 안먹었을 경우
				if(visited[c] == 0) {
					max = tmp+1; //값에 포함시켜주기
				}
				else {
					max = tmp;
				}
			}
		}
		System.out.println(max);
	}

}

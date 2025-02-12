import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		//좌표 정보
		int[] map = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		
		//좌표 배열 복사
		int[] copy = map.clone();
		//오름차순 정렬
		Arrays.sort(copy);
		
		HashMap<Integer, Integer> h = new HashMap<>(); //좌표,순서 저장할 해시맵
		
		int rank = 0; //순서
		h.put(copy[0], rank); //초기 최솟값 저장
		
		for(int i=1; i<N; i++) {
			//이전과 다른 값일 경우 
			if(copy[i-1]!=copy[i]) {
				//순서 더해서 저장
				h.put(copy[i], ++rank);
			}
			//중복되는 값은 저장할 필요 X
		}
		
		//결과 출력
		for(int i=0; i<N; i++) {
			int result = h.get(map[i]); //순위 가져오기
			
			sb.append(i==N-1? result:result+" ");
		}
		System.out.println(sb);
	}

}

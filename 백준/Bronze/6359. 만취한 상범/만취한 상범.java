import java.io.*;


//만취한 상범
public class _6359 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			//0 잠금, 1 열림
			int n = Integer.parseInt(br.readLine());
			int room[] = new int[n+1];
			for(int i=1; i<=n; i++) {
				room[i] = 0; //잠금으로 초기화
			}
			
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=n; j++) {
					if(j%i == 0) { //i번째 라운드 번호 i 배수인 방 상태 변경
						if(room[j] == 0) { //잠겨있으면 열기
							room[j] = 1;
						}
						else { //열려있으면 잠그기
							room[j] = 0;
						}
					}
				}
			}
			
			int cnt=0;
			for(int i=1; i<=n; i++) {
				if(room[i] == 1) { //방 열려있으면
					cnt++; //도주 학생 수 세기
				}
			}
			System.out.println(cnt);
		}

	}

}

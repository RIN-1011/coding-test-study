import java.util.*;
import java.io.*;

public class Main {
	static char[][] map;
	
	//빙고 체크
	public static boolean check(char c) {
		boolean result = false;
		
		//가로 체크
		for (int i = 0; i < 3; i++) {
			int cnt = 0;
			for (int j = 0; j < 3; j++) {
				if(map[i][j]==c) {
					cnt++;
				}
			}
			if(cnt==3) {
				result = true;
				break;
			}
		}
		//세로 체크
		for (int i = 0; i < 3; i++) {
			int cnt = 0;
			for (int j = 0; j < 3; j++) {
				if(map[j][i]==c) {
					cnt++;
				}
			}
			if(cnt==3) {
				result = true;
				break;
			}
		}
		//대각선 체크
		if(map[0][0]==c
		&& map[1][1]== c
		&& map[2][2]==c) {
			result = true;
		}
		else if(map[0][2]==c 
				&& map[1][1]== c
				&& map[2][0]==c) {
					result = true;
				}
		
		return result;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuffer sb = new StringBuffer();

		//격자판 꽉 찼을 경우 X가 한 개 더 많음
		//격자판 비어있을 경우
			//1. X 빙고: O 개수 1개 더 작음
			//2. O 빙고 : X랑 개수 동일
		while(true) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			
			//end면 끝내기
			if(str.equals("end")) {
				break;
			}
			
			map = new char[3][3]; //격자판
			boolean fill = true; //격자판 가득 차있는지 여부
			//X, O 개수
			int countX = 0;
			int countO = 0;
			
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					map[i][j] = str.charAt(i*3+j);
					
					if(map[i][j]=='X') {
						countX++;
					}
					else if(map[i][j]=='O') {
						countO++;
					}
					else { //빈칸 있을 경우
						fill = false;
					}
				}
			}
			
			//둘 다 빙고일 경우
			if(check('O')&&check('X')) {
				sb.append("invalid").append("\n");
				continue;
			}
			//격자판 가득 차있을 경우
			if(fill) {
				if(countX==countO+1) {
					if(check('O')) {
						sb.append("invalid").append("\n");
					}
					else {
						sb.append("valid").append("\n");						
					}
				}
				else {
					sb.append("invalid").append("\n");
				}
			}
			//격자판 비어있을 경우
			else {
				//개수가 같은 경우 O 빙고
				if(countX==countO) {
					if(check('O')) {
						sb.append("valid").append("\n");
						continue;
					}
					else {
						sb.append("invalid").append("\n");
						continue;
					}
				}
				//X 개수가 많은 경우 X 빙고
				else if(countX==countO+1){
					if(check('X')) {
						sb.append("valid").append("\n");
						continue;
					}
					else {
						sb.append("invalid").append("\n");
						continue;
					}
				}
				else {
					sb.append("invalid").append("\n");
				}
			}
		}
		System.out.println(sb);
	}

}
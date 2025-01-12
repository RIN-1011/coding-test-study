import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); //단어의 개수
		int result = 0; //결과
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			
			char c = str.charAt(0);
			boolean[] visited = new boolean['z'-'a'+1];
			visited['z'-c] = true;
			
			int j;
			for(j=1; j<str.length(); j++) {
				if(str.charAt(j)!=c) { //연결된 알파벳이 아닌 경우
					if(!visited['z'-str.charAt(j)]) { //새로운 알파벳인 경우 
						c = str.charAt(j); //c 갱신
						visited['z'-c] = true; //방문 표시
					}
					else { //그룹 단어 아닐 경우
						break;
					}
				}
			}
			if(j==str.length()) { //그룹 단어일 경우
				result++; //개수 카운트
			}
		}
		System.out.println(result);
	}

}
                          
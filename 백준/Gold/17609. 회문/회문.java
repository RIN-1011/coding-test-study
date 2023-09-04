import java.util.*;
import java.io.*;

public class Main {
	public static boolean check(String str, int left, int right) {
		//왼쪽 포인터가 오른쪽 포인터를 넘어가지 않을 때까지
		while(left<right) {
			//양 끝 문자가 같은지 확인하여 다르면 false 반환
			if(str.charAt(left) != str.charAt(right)) {
				return false;
			}
			//범위 좁히기
			left++;
			right--;
		}
		return true;
	}
	public static boolean similarityCheck(String str, int left, int right) {
		//왼쪽 포인터가 오른쪽 포인터를 넘어가지 않을 때까지
		while(left<right) {
			//양 끝 문자가 같은지 확인하여 다르면 유사회문 체크
			if(str.charAt(left) != str.charAt(right)) {
				//왼쪽, 오른쪽 문자 각각 하나씩 제거하여 회문 체크해보기
				if(!check(str, left+1, right) && 
					!check(str, left, right-1)) {
					return false;
				}
				//유사 회문이 맞을 경우 true 반환
				else {
					return true;
				}
			}
			//범위 좁히기
			left++;
			right--;
		}
		return true;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine()); //문자열 개수
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			if(check(str, 0, str.length()-1)) { //회문일 경우
				sb.append(0+"\n");
			}
			else if(similarityCheck(str, 0, str.length()-1)) { //유사회문일 경우
				sb.append(1+"\n");
			}
			else { //모두 아닐 경우
				sb.append(2+"\n");
			}
		}
		System.out.println(sb);
	}

}

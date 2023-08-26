import java.util.*;
import java.io.*;

//나무 높이
public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine()); //테스트 케이스 수
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine()); //나무 개수
			st = new StringTokenizer(br.readLine());
			int[] tree = new int[N]; //나무
			int max = Integer.MIN_VALUE; //가장 높은 나무 길이
			for (int i = 0; i < N; i++) {
				tree[i] = Integer.parseInt(st.nextToken());
				max = Math.max(max, tree[i]);
			}
			//나무 높이 1 또는 2만큼씩 얼마나 남았는지 확인
			int even = 0; //2만큼씩 얼마나 남았는지
			int odd = 0; //1만큼씩 얼마나 남았는지
			for (int i = 0; i < N; i++) {
				if(tree[i] != max) {
					even += (max-tree[i])/2;
					odd += (max-tree[i])%2;
				}
			}
			
			//최소 날짜 구하기
			int result = 0; //최소 날짜 수
			
			//1과 2 개수가 같을 경우 (1과 2 높이만큼 남은 나무 개수 같을 경우)
			//개수 그대로 반환하면 됨
			if(even == odd) {
				result = even+odd;
				sb.append("#"+t+" "+result+"\n");
				continue;
			}
			//1이 2 개수보다 많을 경우
			//1과 2가 쌍인 경우를 제외하면 그 다음날은 홀수 번째 날이므로 날짜+1 해주면 됨
			//그 이상 남아있을 경우 1 자라는 건 홀수번째 날만 가능하므로 2일씩 기다려야 함
			//ex) 1 1 1 1 2 -> 7일
			else if(even < odd) {
				//1과 2가 쌍인 경우
				//even 개수*2 날짜 만큼 더해줌
				result += even*2;
				odd -= even; //홀짝 쌍 빼주기
				//쌍 빼고 나면 그 다음날은 홀수 날짜이므로 날짜+1 해주기
				result += 1;
				odd -= 1;
				//아직 1 남은 나무 개수 남아있는 경우
				//홀수 날짜에만 물 줄 수 있으므로 남은 개수*2 해주기
				if(odd != 0) {
					result += odd*2;
				}
				sb.append("#"+t+" "+result+"\n");
				continue;
			}
			//1보다 2 개수가 많을 경우
			//1과 2의 쌍을 제외하고 남은 2의 개수가 2 이상이면 짝수를 홀수로 만들어서 계산하여 날짜 = 2개수+1 하면 됨
			//ex) 2 2 2 2 1 1 -> 7일
			else if(even > odd){
				//1과 2가 쌍인 경우
				//odd 개수*2 날짜 만큼 더해줌
				result += odd*2;
				even -= odd; //홀짝 쌍 빼주기
				
				//2가 3개씩 짝지어서 0 남은 경우 3개 쌍 개수*4 하면 됨
				//ex) 2 2 2 -> 4일
				if(even%3 == 0) {
					result += (even/3)*4;
					sb.append("#"+t+" "+result+"\n");
					continue;
				}
				//2가 3개씩 짝지어서 1 남은 경우 3개 쌍 개수*4 + 날짜+2 하면 됨
				//2 하나 남았을 때 3일 기다려서 1씩 크는 것 보다 2일 기다려서 2 크는게 덜 기다림
				//ex) 2 2 2 2 -> 6일
				else if(even%3 == 1) {
					result += (even/3)*4; //쌍 계산
					result += 2; //2일 기다리기
					sb.append("#"+t+" "+result+"\n");
					continue;
				}
				//2가 3개씩 짝지어서 2 남은 경우 3개 쌍 개수*4 + 날짜+3 하면 됨
				//2가 두 개 남았을 경우 2 하나를 1로 쪼개서 1,1,2로 만들 수 있음
				//ex) 2 2 -> 3일
				else if(even%3 == 2) {
					result += (even/3)*4; //쌍 계산
					result += 3; //2 쪼개서 3일 더하기
					sb.append("#"+t+" "+result+"\n");
					continue;
				}
			}
		}
		System.out.println(sb);
	}

}

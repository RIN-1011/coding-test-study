import java.util.*;
import java.io.*;

//로마 숫자 만들기
public class Main {
	static int N; //사용할 수 있는 문자의 개수
	static int[] numbers; //중복 조합 완성 배열
	static int[] input = {1, 5, 10, 50}; //로마 숫자 종류
	static int sum; //중복 조합 결과
	static ArrayList<Integer> list = new ArrayList<Integer>();
	
	//중복 조합
	public static void combinationWithRepetition(int cnt, int start) {
		if(cnt == N) {
			sum = 0; //초기화
			for (int i = 0; i < N; i++) {
				sum += numbers[i]; //문자 이용해서 수 만들기
			}
			if(!list.contains(sum)) { //이미 만든 수와 겹치지 않을 경우
				list.add(sum); //리스트에 더해주기
			}
			return;
		}
		else {
			for (int i = start; i < input.length; i++) {
				numbers[cnt] = input[i];
				combinationWithRepetition(cnt+1, i);
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); //사용할 수 있는 문자의 개수
		numbers = new int[N];
		combinationWithRepetition(0, 0);
		
		System.out.println(list.size());
	}
}

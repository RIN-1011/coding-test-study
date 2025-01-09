import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int one = Integer.parseInt(br.readLine());
		int two = Integer.parseInt(br.readLine());
		
		int thd = two/100; //두번째 자연수 100의 자리 숫자
		int sec = two%100/10; //두번째 자연수 10의 자리 숫자
		int fir = two%100%10; //두번째 자연수 1의 자리 숫자
		
		int three = one*fir;
		int four = one*sec;
		int five = one*thd;
		
		int six = one*two;
		
		//(3)에 들어갈 값
		sb.append(three).append('\n');
		//(4)에 들어갈 값
		sb.append(four).append('\n');
		//(5)에 들어갈 값
		sb.append(five).append('\n');
		//(6)에 들어갈 값
		sb.append(six);
		
		System.out.println(sb);
	}
}
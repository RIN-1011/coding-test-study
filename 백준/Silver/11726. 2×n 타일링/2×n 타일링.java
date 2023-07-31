import java.util.*;
import java.io.*;

//2xn 타일링
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		//직사각형
		int arr[] = new int[1001];
		arr[1] = 1;
		arr[2] = 2; //초기화
		
		for(int i=3; i<=n; i++) { //n=3부터 점화식 사용
			//전 두 단계에서 개수 합이 현재 단계 결과
			arr[i]= (arr[i-1] + arr[i-2]) % 10007;
		}
		System.out.println(arr[n]);
	}

}

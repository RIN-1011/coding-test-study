import java.io.*;
import java.util.*;

//보물
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer ast = new StringTokenizer(br.readLine());
		StringTokenizer bst = new StringTokenizer(br.readLine());
		
		int a[] = new int[N];
		Integer b[] = new Integer[N];
		
		for(int i=0; i<N; i++) {
			a[i] = Integer.parseInt(ast.nextToken());
			b[i] = Integer.parseInt(bst.nextToken());
		}
		
		//a는 오름차순 정렬
		Arrays.sort(a);
		Arrays.sort(b, Collections.reverseOrder());
		
		int min = 0; //최솟값
		
		for(int i=0; i<N; i++) {
			min += a[i] * b[i];
		}
		System.out.println(min);
		
	}

}

import java.util.*;
import java.io.*;

public class Main {
    static int[][] sudoku;
    static ArrayList<int[]> list = new ArrayList<>();

    public static boolean sudokuChecked(int x, int y, int num) {
        //행,열 검사
        for (int i = 0; i < 9; i++) {
            if(sudoku[x][i] == num || sudoku[i][y] == num) {
                return false;
            }
        }

        //사각형 검사
        int si = (x/3)*3;
        int sj = (y/3)*3;
        
        for (int i = si; i < si+3; i++) {
            for (int j = sj; j < sj+3; j++) {
                if(sudoku[i][j] == num) {
                	return false;
                }
            }
        }

        return true;
    }
    
    public static void dfs(int depth) {
    	if(depth == list.size()) {
    		for (int i = 0; i < 9; i++) {
    			for (int j = 0; j < 9; j++) {
    				System.out.print(sudoku[i][j]);
    			}
    			System.out.println();
    		}
    		
    		System.exit(0);
    	}
    	
    	int x = list.get(depth)[0];
    	int y = list.get(depth)[1];
    	
    	for (int k = 1; k <= 9; k++) {
			if(sudokuChecked(x, y, k)) {
				sudoku[x][y] = k;
				dfs(depth+1);
				sudoku[x][y] = 0;
			}
		}
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        sudoku = new int[9][9];
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = str.charAt(j)-'0';
                if(sudoku[i][j] == 0) {
                	list.add(new int[] {i, j});
                }
            }
        }
        
        dfs(0);
    }
}
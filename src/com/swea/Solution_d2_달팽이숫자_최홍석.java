package com.swea;
import java.util.Scanner;

public class Solution_d2_달팽이숫자_최홍석{
	
	static int tes, n;
	static int arr[][] = new int[11][11];
	static final int dx[] = {0, -1, 0, 1};
	static final int dy[] = {1, 0, -1, 0};
	static final int dwall[] = {-1, 1, 1, -1};
	static int wall[] = new int[4]; 
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in); tes = sc.nextInt();
		for(int test_case = 1; test_case <= tes; test_case++) {
			n = sc.nextInt();
			int cnt = 1, dir = 0, cur_x = 0, cur_y = 0;
			wall[0] = n; wall[1] = 0; wall[2] = -1; wall[3] = n;
			arr[cur_x][cur_y] = cnt++;
			for(int i= 0; i < 2 * n - 1; i++) {
				while(true){
					int new_x = cur_x + dx[dir], new_y = cur_y + dy[dir];
					if(wall[dir] == (dir % 2 == 1 ? new_x : new_y)) break;
					cur_x = new_x; cur_y = new_y; arr[cur_x][cur_y] = cnt++;
				}
				wall[dir] += dwall[dir]; dir = (dir + 3) % 4; 
			}
			
			System.out.println("#" + test_case);
			for(int i =0; i < n; i++) {
				for(int j=0; j< n; j++) {
					System.out.print(arr[i][j] + " ");
				}System.out.println();
			}
		}
		
		sc.close();
	}
}

package com.swea;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_d3_Sum_최홍석 {
	
	static int tes;
	static String str_tok[];
	static int arr[][] = new int[100][100];
	static int max_val = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int test_case = 1; test_case <= 10; test_case++) {
			tes = Integer.parseInt(br.readLine());
			for(int i=0; i<100; i++) {
				String str = br.readLine(); str_tok = str.split(" ");
				for(int ia =0; ia < 100; ia++) {
					arr[i][ia] = Integer.parseInt(str_tok[ia]);
				}
			}
			
			int diag_sum1 = 0, diag_sum2 = 0;
			for(int i = 0; i < 100; ++i) {
				int sero_sum = 0, garo_sum = 0;
				for(int j=0; j<100; ++j) {
					sero_sum += arr[j][i]; garo_sum += arr[i][j];
				}
				diag_sum1 += arr[i][i]; diag_sum2 += arr[i][99 - i];
				max_val = Math.max(garo_sum, Math.max(sero_sum, max_val));
			}
			max_val = Math.max(diag_sum1, Math.max(diag_sum2, max_val));
			System.out.println("#" + tes + " " + max_val); max_val = 0;
		}
		
	}
}

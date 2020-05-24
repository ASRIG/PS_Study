package com.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1780_종이의개수 {
	
	static String str_tok[] = {};
	static int n;
	static int arr[][];
	static int ans[] = new int[3];
	// -1 :: 0, 0 :: 1, 1 :: 2
	
	public static void add_num(int val) {
		switch(val) {
		case -1:
			ans[0]++;
			break;
		case 0:
			ans[1]++;
			break;
		case 1:
			ans[2]++;
			break;
		}
	}
	
	public static boolean is_okay(int idx1, int idy1, int size1) {
		int val = arr[idx1][idy1];
		for(int i = idx1; i < idx1 + size1; i++) {
			for(int j = idy1; j < idy1 + size1; j++) {
				if(val != arr[i][j]) return false;
			}
		}
		return true;
	}
	
	public static void is_okay_test(int idx1, int idy1, int size1) {
		if(size1 == 1) {
			add_num(arr[idx1][idy1]); return;
		}
		
		if(is_okay(idx1, idy1, size1)) {
			add_num(arr[idx1][idy1]);
		}else {
			int tmp_size = size1 / 3;
			for(int i = idx1; i < idx1 + size1; i += tmp_size) {
				for(int j = idy1; j < idy1 + size1; j += tmp_size) {
					is_okay_test(i, j, tmp_size);
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		for(int i=0; i<n; i++) {
			str_tok = br.readLine().split(" ");
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(str_tok[j]);
			}
		}
		is_okay_test(0, 0, n);
		System.out.println(ans[0]);
		System.out.println(ans[1]);
		System.out.println(ans[2]);
	}
}

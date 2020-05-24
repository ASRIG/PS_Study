package com.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1992_쿼드트리 {
	
	static String str_tok[] = {};
	static int n;
	static char arr[][];
	static String ans;
	
	public static boolean is_okay(int idx1, int idy1, int size1) {
		char val = arr[idx1][idy1];
		for(int i = idx1; i < idx1 + size1; i++) {
			for(int j = idy1; j < idy1 + size1; j++) {
				if(val != arr[i][j]) return false;
			}
		}
		return true;
	}
	
	public static void Quadtree(int idx1, int idy1, int size1) {
		if(size1 == 1) {
			System.out.print(arr[idx1][idy1]); return;
		}
		
		if(is_okay(idx1, idy1, size1)) {
			System.out.print(arr[idx1][idy1]);
		}else {
			int tmp_size = size1 / 2;
			System.out.print("(");
			for(int i = idx1; i < idx1 + size1; i += tmp_size) {
				for(int j = idy1; j < idy1 + size1; j += tmp_size) {
					Quadtree(i, j, tmp_size);
				}
			}
			System.out.print(")");
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new char[n][n];
		for(int i=0; i<n; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		Quadtree(0, 0, n);
	}
}

package com.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_d3_의석이의세로로말해요_최홍석 {

	static String str[] = new String[5];
	static String ans_str = "";
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tes = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= tes; test_case++) {
			int max_length = 0;
			for(int i=0; i<5; i++) {
				str[i] = br.readLine();
				max_length = Math.max(max_length, str[i].length());
			}
			
			for(int i=0; i<max_length; i++) {
				for(int j=0; j<5; j++) {
					if(str[j].length() > i) ans_str += str[j].charAt(i);
				}
			}
			
			System.out.println("#" + test_case + " " + ans_str);
			ans_str = "";
		}
		
		
		
	}

}

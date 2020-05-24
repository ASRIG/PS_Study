package com.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1629_곱셈 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str_tok[] = br.readLine().split(" ");
		long a = Integer.parseInt(str_tok[0]), b = Integer.parseInt(str_tok[1]), c = Integer.parseInt(str_tok[2]);
		long ret = 1;
		
		a %= c;
		
		while(b > 1) {
			if((b & 1) == 1) {
				// Ȧ���� ���
				ret = (ret * a) % c; b >>= 1; a = ((a * a) % c);
			}else {
				// ¦���� ���
				b >>= 1; a = ((a * a) % c);
			}
		}
		System.out.println((a * ret) % c);
	}

}

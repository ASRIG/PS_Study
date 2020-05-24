package com.Baekjoon;

import java.io.*;
import java.util.*;

public class Main_17253_삼삼한수2 {
	static long N;
	static long pow(int k) {
		long ret = 1;
		for(int i = 0; i < k; i++) ret *= 3;
		return ret;
	}
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in); N = sc.nextLong();
		N = (N == 0 ? -1 : N);
		for(int i = 39; i >= 0; i--) {
			long k = pow(i);
			if(N >= k) N -= k;
		}
		if(N == 0) System.out.println("YES");
		else System.out.println("NO");
	}
}

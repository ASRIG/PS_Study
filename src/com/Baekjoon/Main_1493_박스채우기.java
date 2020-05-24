package com.Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_1493_박스채우기 {

	public static void main(String[] args) throws IOException {
		// �Էº�
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		long l = Long.parseLong(input[0]);
		long w = Long.parseLong(input[1]);
		long h = Long.parseLong(input[2]);

		int n = Integer.parseInt(br.readLine());

		// ����ó��
		if(n==0) {
			bw.write(String.valueOf(-1));
			bw.flush();
			return;
		}

		// �ٽ� �Էº�
		long[][] ar = new long[n][2];

		for(int i=0 ; i<n ; i++){
			input = br.readLine().split(" ");
			ar[i][0] = Long.parseLong(input[0]);
			ar[i][1] = Long.parseLong(input[1]);
		}

		// result�� ���߿� �� ������ ���� ���� ����
		long result = 0;

		// l,w,h�� ���� Ȧ���϶� ���ǰ� 1�� ť��� ������ ä��� ¦���� �����ֱ� ���� �κ�
		if(l%2==1){
			if(ar[0][0]==0){
				if(ar[0][1]>=w*h) {
					result += w*h;
					ar[0][1] -= w*h;
					l--;
				}
				else {
					bw.write(String.valueOf(-1));
					bw.flush();
					return;
				}
			}
			else {
				bw.write(String.valueOf(-1));
				bw.flush();
				return;
			}
		}
		if(w%2==1){
			if(ar[0][0]==0){
				if(ar[0][1]>=l*h) {
					result += l*h;
					ar[0][1] -= l*h;
					w--;
				}
				else {
					bw.write(String.valueOf(-1));
					bw.flush();
					return;
				}
			}
			else {
				bw.write(String.valueOf(-1));
				bw.flush();
				return;
			}
		}
		if(h%2==1){
			if(ar[0][0]==0){
				if(ar[0][1]>=w*l) {
					result += w*l;
					ar[0][1] -= w*l;
					h--;
				}
				else {
					bw.write(String.valueOf(-1));
					bw.flush();
					return;
				}
			}
			else {
				bw.write(String.valueOf(-1));
				bw.flush();
				return;
			}
		}

		// �� ���� ���
		long sum = (long)(l*w*h);

		// ū ť����� ���ʴ�� ���
		for(int i=n-1 ; i>=0 ; i--){
			// �� ���� ����
			long now = (long) Math.pow(2,ar[i][0]);
			// ť���� ����
			now *= (long)(now*now);
			// ť���� ����
			long num = ar[i][1];
			// ������ ť�긦 �ִ�� ���� �� �ִ� ����
			long temp = Math.min(num, sum/now);
			// �� ���� �߰�
			result += temp;
			// ���� ä���� �� ����
			sum -= temp*now;
			// �� ä������ break
			if(sum==0) break;
		}

		// �� ä�������� -1 ���
		if(sum>0) bw.write(String.valueOf(-1));
		// �������� ��� ���� ���
		else bw.write(String.valueOf(result));

		bw.flush();
	}
}


/*
 * #include <iostream>
#include <cstring>
#include <string>
#include <vector>
#include <algorithm>
#include <cmath>
#include <cstdio>
#include <deque>
#include <map>
#include <stack>
#include <queue>
#include <set>
#include <list>
#include <unordered_map>
#define MOD 1000000007
#define MAXINT 2000000000
#define mp make_pair
using namespace std;

int a[20];

int main() {
	long long w = 0;
	int t, x, y, z, r = 0;
	int i, n, u, v;
	scanf("%d%d%d%d", &x, &y, &z, &n);
	for (i = 0; i < n; i++) {
		scanf("%d%d", &u, &v);
		a[u] += v;
	}
	for (i = 19; i >= 0; i--) {
		w <<= 3; //�̹� ���� ������ �κ� ���� 8�� �ø���
		t = min((long long)a[i], (long long)(x >> i) * (y >> i) * (z >> i) - w);
		w += t; // ���Ӱ� ���� ������ �κ� �����ֱ�
		r += t; // �Ѱ���
	}
	printf("%d", w == (long long)x * y * z ? r : -1);
//���� �� �Ǹ� -1
}

 * 
 * 
 * 
 * 
 */

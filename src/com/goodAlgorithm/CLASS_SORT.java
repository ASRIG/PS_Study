package com.goodAlgorithm;

import java.util.Arrays;

class Assign {
    int rest, score;

    public Assign(int rest, int score) {
        this.rest = rest;
        this.score = score;
    }
}

public class CLASS_SORT {
	public static void main(String[] args) {
		Assign assigns[] = new Assign[1001];
        Arrays.sort(assigns, (Assign a1, Assign a2) -> (a1.score > a2.score) ? -1 : (a1.score == a2.score) ? 0 : 1);
	}
}

package com.quiz;

import java.util.Arrays;

public class ProblemBean {
	private int[] sequence;
	private int solution;
	
	public ProblemBean() {
		
	}
	
	public ProblemBean(int[] sequence, int solution) {
		this.sequence = new int[sequence.length];
		for (int i = 0; i < sequence.length; i++) {
			this.sequence[i] = sequence[i];
		}
		this.solution = solution;
	}

	public int[] getSequence() {
		return sequence;
	}

	public void setSequence(int[] sequence) {
		this.sequence = sequence;
	}

	public int getSolution() {
		return solution;
	}

	public void setSolution(int solution) {
		this.solution = solution;
	}

	@Override
	public String toString() {
		String result = "";
		for (int i = 0; i < sequence.length; i++)
			result += sequence[i] + " ";
		return result;
	}
	
	
}

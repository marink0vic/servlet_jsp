package com.quiz;

import java.util.ArrayList;
import java.util.List;

public class QuizBean {

	private List<ProblemBean> problems = new ArrayList<>();
	private int currentIndex;
	private int score;
	
	public QuizBean() {
		problems.add(new ProblemBean(new int[]{1, 4, 9, 16, 25}, 36));
		// kvadrati
		problems.add(new ProblemBean(new int[]{1, 1, 2, 3, 5}, 8));
		// fibonaci
		problems.add(new ProblemBean(new int[]{3, 1, 4, 1, 5}, 9));
		// pi
		problems.add(new ProblemBean(new int[]{2, 3, 5, 7, 11}, 13));
		// prosti
		problems.add(new ProblemBean(new int[]{1, 2, 4, 8, 16}, 32));
		// stepeni dvojke
		problems.add(new ProblemBean(new int[]{0, 7, 26, 63, 124}, 215));
		// kubovi -1
		currentIndex = 0;
		score = 0;
	}
	
	public void setProblems(List<ProblemBean> problems) {
		this.problems = problems;
		currentIndex = 0;
		score = 0;
	}
	
	public int getScore() {
		return score;
	}

	public void incrementScore() {
		score++;
	}

	public int getCurrentIndex() {
		return currentIndex;
	}

	public void setCurrentIndex(int i) {
		this.currentIndex = i;
	}
	
	public ProblemBean getCurrentProblem() {
		return problems.get(currentIndex);
	}
	
	public boolean checkAnswer(int answer) {
		return getCurrentProblem().getSolution() == answer;
	}
	
	public boolean isFinished() {
		return currentIndex == problems.size();
	}

}

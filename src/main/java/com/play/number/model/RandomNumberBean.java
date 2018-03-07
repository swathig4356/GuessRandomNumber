package com.play.number.model;

public class RandomNumberBean {
	private int randomNumber;
	private int attempt;
	private int userGuess;
	private String message;
	
	public int getRandomNumber() {
		return randomNumber;
	}
	public void setRandomNumber(int randomNumber) {
		this.randomNumber = randomNumber;
	}
	public int getAttempt() {
		return attempt;
	}
	public void setAttempt(int attempt) {
		this.attempt = attempt;
	}
	public int getUserGuess() {
		return userGuess;
	}
	public void setUserGuess(int userGuess) {
		this.userGuess = userGuess;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}

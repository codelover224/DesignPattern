package com.observerPattern;

import java.util.ArrayList;
import java.util.List;

class Subject1 {
	private List<Observer1> observers = new ArrayList<Observer1>();
	private int state;

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
		notifyAllObservers();
	}

	public void attach(Observer1 observer) {
		observers.add(observer);
	}

	public void notifyAllObservers() {
		for (Observer1 observer : observers)
			observer.update();
	}
}

abstract class Observer1 {
	protected Subject1 subject;

	public abstract void update();
}

class Newspaper extends Observer1 {

	@Override
	public void update() {
		System.out.println("(Newspaper)New Loan rate: " + subject.getState());
	}

	public Newspaper(Subject1 subject) {
		this.subject = subject;
		this.subject.attach(this);
	}
}

class InternetMedia extends Observer1 {

	@Override
	public void update() {
		System.out.println("(Internet)New Loan rate: " + subject.getState());
	}

	public InternetMedia(Subject1 subject) {
		this.subject = subject;
		this.subject.attach(this);
	}
}

public class AnotherExample {

	public static void main(String[] args) {
		Subject1 subject = new Subject1();
		new Newspaper(subject);
		new InternetMedia(subject);

		System.out.println("First rate change: 3");
		subject.setState(3);

		System.out.println("Second rate change: 4");
		subject.setState(4);
	}

}

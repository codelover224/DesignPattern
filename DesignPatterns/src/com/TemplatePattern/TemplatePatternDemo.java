package com.TemplatePattern;

abstract class Game {
	abstract void initialize();

	abstract void startPlay();

	abstract void endPlay();

	public final void play() {
		initialize();
		startPlay();
		endPlay();
	}
}

class Cricket extends Game {

	@Override
	void endPlay() {
		System.out.println("Cricket game finished!!");
	}

	@Override
	void startPlay() {
		System.out.println("Cricket game started.Enjoy the game!!");
	}

	@Override
	void initialize() {
		System.out.println("Cricket game initialized.Start playing");
	}

}

class Football extends Game {

	@Override
	void startPlay() {
		System.out.println("Football game started.Enjoy the game!!");
	}

	@Override
	void endPlay() {
		System.out.println("Football game finished!!");
	}

	@Override
	void initialize() {
		System.out.println("Football game initialized.Start playing");
	}

}

public class TemplatePatternDemo {

	public static void main(String[] args) {
		Game game = new Cricket();
		game.play();
		System.out.println();
		game = new Football();
		game.play();
	}

}

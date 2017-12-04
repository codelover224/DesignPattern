package com.adapterPattern;

interface MediaPlayer {
	public void play(String audioType, String filename);
}

interface AdvancedMediaPlayer {
	public void playVLC(String filename);

	public void playMp4(String filename);
}

class VlcPlayer implements AdvancedMediaPlayer {

	@Override
	public void playVLC(String filename) {
		// TODO Auto-generated method stub
		System.out.println("Playing vlc file.Name " + filename);
	}

	@Override
	public void playMp4(String filename) {
		// TODO Auto-generated method stub
	}

}

class Mp4Player implements AdvancedMediaPlayer {

	@Override
	public void playVLC(String filename) {
		// TODO Auto-generated method stub
	}

	@Override
	public void playMp4(String filename) {
		// TODO Auto-generated method stub
		System.out.println("Playing mp4 file.Name " + filename);
	}
}

class MediaAdapter implements MediaPlayer {
	AdvancedMediaPlayer advancedMusicPlayer;

	public MediaAdapter(String audioType) {
		if (audioType.equalsIgnoreCase("vlc"))
			advancedMusicPlayer = new VlcPlayer();
		else if (audioType.equalsIgnoreCase("mp4"))
			advancedMusicPlayer = new Mp4Player();
	}

	@Override
	public void play(String audioType, String filename) {
		if (audioType.equalsIgnoreCase("vlc"))
			advancedMusicPlayer.playVLC(filename);
		else if (audioType.equalsIgnoreCase("mp4"))
			advancedMusicPlayer.playMp4(filename);
	}
}

class AudioPlayer implements MediaPlayer {
	MediaAdapter mediaAdapter;

	@Override
	public void play(String audioType, String fileName) {

		if (audioType.equalsIgnoreCase("mp3")) {
			System.out.println("Playing mp3 file. Name: " + fileName);
		}

		else if (audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4")) {
			mediaAdapter = new MediaAdapter(audioType);
			mediaAdapter.play(audioType, fileName);
		}

		else {
			System.out.println("Invalid media. " + audioType + " format not supported");
		}
	}
}

public class AdapterPatternDemo {

	public static void main(String[] args) {
		AudioPlayer audioPlayer = new AudioPlayer();

		audioPlayer.play("mp3", "beyond the horizon.mp3");
		audioPlayer.play("mp4", "alone.mp4");
		audioPlayer.play("vlc", "far far away.vlc");
		audioPlayer.play("avi", "mind me.avi");
	}

}

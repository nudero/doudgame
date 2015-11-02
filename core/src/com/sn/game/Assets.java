package com.sn.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Assets {

	public static BitmapFont font;

	public static Texture background;
	public static TextureRegion backgroundRegion;

	public static Texture items;
	public static TextureRegion soundOn;
	public static TextureRegion soundOff;
	public static TextureRegion arrow;
	public static TextureRegion logo;
	public static TextureRegion gameOver;

	public static Animation idleAnim;
	public static Animation throwAnim;
	public static Animation lookAnim;
	public static Animation hittedAnim;
	public static TextureRegion platform;
	public static Animation breakingPlatform;

	public static Music music;
	public static Sound riseSound;
	public static Sound fallSound;
	public static Sound hitSound;
	public static Sound failSound;
	public static Sound score1Sound;
	public static Sound score2Sound;
	public static Sound clickSound;

	public static void load() {
		background = new Texture(Gdx.files.internal("background.png"));
		backgroundRegion = new TextureRegion(background, 0, 0, 320, 480);

		items = new Texture(Gdx.files.internal("items.png"));
		gameOver = new TextureRegion(items, 352, 256, 160, 96);
		logo = new TextureRegion(items, 0, 352, 274, 142);
		soundOff = new TextureRegion(items, 0, 0, 64, 64);
		soundOn = new TextureRegion(items, 64, 0, 64, 64);
		arrow = new TextureRegion(items, 0, 64, 64, 64);
		platform = new TextureRegion(items, 64, 160, 64, 16);
		
		idleAnim = new Animation(0.2f,
				new TextureRegion(items, 0, 128, 32, 32), new TextureRegion(
						items, 32, 128, 32, 32));
		lookAnim = new Animation(0.2f,
				new TextureRegion(items, 64, 128, 32, 32), new TextureRegion(
						items, 96, 128, 32, 32));
		hittedAnim = new Animation(0.2f, new TextureRegion(items, 128, 128, 32,
				32));
//		platform = new Animation(0.2f,new TextureRegion(items, 64, 160, 64, 16));
		breakingPlatform = new Animation(0.2f, new TextureRegion(items, 64,
				160, 64, 16), new TextureRegion(items, 64, 176, 64, 16),
				new TextureRegion(items, 64, 192, 64, 16), new TextureRegion(
						items, 64, 208, 64, 16));

		font = new BitmapFont(Gdx.files.internal("font.fnt"), Gdx.files.internal("font.png"), false);

		music = Gdx.audio.newMusic(Gdx.files.internal("music.mp3"));
		music.setLooping(true);
		music.setVolume(0.5f);

		riseSound = Gdx.audio.newSound(Gdx.files.internal("jump.wav"));
		fallSound = Gdx.audio.newSound(Gdx.files.internal("highjump.wav"));
		hitSound = Gdx.audio.newSound(Gdx.files.internal("hit.wav"));
		score1Sound = Gdx.audio.newSound(Gdx.files.internal("coin.wav"));
		score2Sound = Gdx.audio.newSound(Gdx.files.internal("coin.wav"));
		failSound = Gdx.audio.newSound(Gdx.files.internal("coin.wav"));
		clickSound = Gdx.audio.newSound(Gdx.files.internal("click.wav"));

		idleAnim.setPlayMode(PlayMode.LOOP);
		lookAnim.setPlayMode(PlayMode.LOOP);
	}

	public static void playSound(Sound sound) {
		sound.play(1);
	}
}

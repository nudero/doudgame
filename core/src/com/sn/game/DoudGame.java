package com.sn.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class DoudGame extends Game {

	public SpriteBatch batcher;
	
	@Override
	public void create() {
		batcher = new SpriteBatch();
		Assets.load();
		setScreen(new MainMenuScreen(this));
	}

	@Override
	public void dispose() {
		batcher.dispose();
	}

}

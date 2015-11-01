package com.sn.game;

import com.badlogic.ashley.core.PooledEngine;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;

public class GameScreen extends ScreenAdapter {

	DoudGame game;
	PooledEngine engine;
	World world;
	
	public GameScreen(DoudGame game) {
		this.game = game;
		
		engine = new PooledEngine();
		world = new World(engine);
		world.create();
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.05f, 0.15f, 0.05f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
	}

	@Override
	public void dispose() {
		
	}
	
	
}

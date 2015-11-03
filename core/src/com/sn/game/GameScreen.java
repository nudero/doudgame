package com.sn.game;

import com.badlogic.ashley.core.PooledEngine;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.sn.game.system.BackgroundSystem;
import com.sn.game.system.BobSystem;
import com.sn.game.system.GravitySystem;
import com.sn.game.system.MovementSystem;
import com.sn.game.system.PlatformSystem;
import com.sn.game.system.RenderingSystem;

public class GameScreen extends ScreenAdapter {

	DoudGame game;
	PooledEngine engine;
	World world;
	OrthographicCamera guiCam;
	
	public GameScreen(DoudGame game) {
		Gdx.input.setInputProcessor(null);
		
		this.game = game;
		Assets.music.play();
		
		guiCam = new OrthographicCamera(320, 480);
		guiCam.position.set(320 / 2, 480 / 2, 0);
		
		engine = new PooledEngine();
		world = new World(engine);
		engine.addSystem(new BackgroundSystem());
		engine.addSystem(new RenderingSystem(game.batcher));
		engine.addSystem(new AnimationSystem());
		engine.addSystem(new MovementSystem());
		engine.addSystem(new PlatformSystem());
		engine.addSystem(new BobSystem(world, engine));
		engine.addSystem(new GravitySystem());
		engine.getSystem(BackgroundSystem.class).setCamera(engine.getSystem(RenderingSystem.class).getCamera());
		world.create();
	}
	
	public void update(float dt) {
		if (dt > 0.1f) dt = 0.1f;
		
		engine.update(dt);
	}
	
	public void drawui(float dt) {
		guiCam.update();
		game.batcher.setProjectionMatrix(guiCam.combined);
		game.batcher.begin();
//		game.batcher.draw(Assets.logo, 160 - 270 / 2, 240 - 32 / 2);
		Assets.font.draw(game.batcher, "7", 320-30, 480 - 10);
		game.batcher.end();
	}
	
	

	@Override
	public void show() {
		super.show();
	}

	@Override
	public void render(float delta) {
//		Gdx.gl.glClearColor(0.05f, 0.15f, 0.05f, 1);
//		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		update(delta);
		drawui(delta);
	}

	@Override
	public void dispose() {
		
	}
	
	
}

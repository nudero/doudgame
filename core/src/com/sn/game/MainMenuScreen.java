package com.sn.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Value;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

public class MainMenuScreen extends ScreenAdapter {
	
	DoudGame game;
	Stage stage;
	Skin skin;
	SpriteBatch batch;
	
	public MainMenuScreen(DoudGame game) {
		this.game = game;
		batch = new SpriteBatch();
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);
		
		skin = new Skin();
		
		Pixmap pixmap = new Pixmap(1,1,Format.RGB888);
		pixmap.setColor(Color.WHITE);
		pixmap.fill();
		skin.add("white", new Texture(pixmap));
		
		BitmapFont bf = new BitmapFont();
		skin.add("default", bf);
		
		TextButtonStyle textButtonStyle = new TextButtonStyle();
		textButtonStyle.up = skin.newDrawable("white", Color.DARK_GRAY);
		textButtonStyle.down = skin.newDrawable("white", Color.DARK_GRAY);
		textButtonStyle.checked = skin.newDrawable("white", Color.BLUE);
		textButtonStyle.over = skin.newDrawable("white", Color.LIGHT_GRAY);
		textButtonStyle.font = skin.getFont("default");
		skin.add("default", textButtonStyle);
		
		Table table = new Table();
		table.setFillParent(true);
		stage.addActor(table);
		
		TextButton tb = new TextButton("play", skin);
		table.add(tb).size(180);
		
		tb.center();
		tb.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				play();
			}
		});
		
//		table.add(new Image(skin.newDrawable("white", Color.RED))).size(64);
	}
	
	private void play() {
		game.setScreen(new GameScreen(game));
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		stage.act(delta);
		stage.draw();
	}

//	@Override
//	public void resize(int width, int height) {
//		stage.getViewport().update(width, height, true);
//	}

	@Override
	public void dispose() {
		stage.dispose();
		skin.dispose();
		batch.dispose();
	}
	
	
}

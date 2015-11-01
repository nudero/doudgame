package com.sn.game.system;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.sn.game.component.BackgroundComponent;
import com.sn.game.component.TransformComponent;

public class BackgroundSystem extends IteratingSystem {
	
	private OrthographicCamera camera;
	private ComponentMapper<TransformComponent> tm;
	
	@SuppressWarnings("unchecked")
	public BackgroundSystem() {
		super(Family.all(BackgroundComponent.class).get());
		tm = ComponentMapper.getFor(TransformComponent.class);
	}
	
	public void setCamera(OrthographicCamera camera) {
		this.camera = camera;
	}

	@Override
	protected void processEntity(Entity entity, float deltaTime) {
		TransformComponent t = tm.get(entity);
		t.pos.set(camera.position.x, camera.position.y, 10.0f);
	}
}

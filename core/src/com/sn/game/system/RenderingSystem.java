package com.sn.game.system;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.sn.game.component.TextureComponent;
import com.sn.game.component.TransformComponent;

public class RenderingSystem extends IteratingSystem {

	private Array<Entity> renderQueue;
	
	@SuppressWarnings("unchecked")
	public RenderingSystem(SpriteBatch batch) {
		super(Family.all(TransformComponent.class, TextureComponent.class).get());
		
		renderQueue = new Array<Entity>();
	}
	
	
	@Override
	public void update(float deltaTime) {
		// TODO Auto-generated method stub
		super.update(deltaTime);
	}


	@Override
	protected void processEntity(Entity entity, float deltaTime) {
		renderQueue.add(entity);
	}
	
	
}

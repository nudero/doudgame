package com.sn.game;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.PooledEngine;
import com.sn.game.component.AnimationComponent;
import com.sn.game.component.BackgroundComponent;
import com.sn.game.component.BobComponent;
import com.sn.game.component.BoundsComponent;
import com.sn.game.component.StateComponent;
import com.sn.game.component.TextureComponent;
import com.sn.game.component.TransformComponent;

public class World {

	PooledEngine engine;
	
	public World(PooledEngine engine) {
		this.engine = engine;
	}
	
	public void create() {
		createBob();
		createBackground();
	}
	
	private void createBackground() {
		Entity ent = engine.createEntity();
		BackgroundComponent background = engine.createComponent(BackgroundComponent.class);
		TextureComponent texture = engine.createComponent(TextureComponent.class);
		TransformComponent transform = engine.createComponent(TransformComponent.class);
		texture.region = Assets.backgroundRegion;
		ent.add(background);
		ent.add(texture);
		ent.add(transform);
		engine.addEntity(ent);
	}
	
	private Entity createBob() {
		Entity entity = engine.createEntity();
		AnimationComponent animation = engine.createComponent(AnimationComponent.class);
		BobComponent bob = engine.createComponent(BobComponent.class);
		BoundsComponent bounds = engine.createComponent(BoundsComponent.class);
		TransformComponent transform = engine.createComponent(TransformComponent.class);
		StateComponent state = engine.createComponent(StateComponent.class);
		TextureComponent texture = engine.createComponent(TextureComponent.class);
		
		animation.animations.put(BobComponent.STATE_IDLE, Assets.idleAnim);
		animation.animations.put(BobComponent.STATE_THROW, Assets.throwAnim);
		animation.animations.put(BobComponent.STATE_LOOK, Assets.lookAnim);
		animation.animations.put(BobComponent.STATE_HITTED, Assets.hittedAnim);
		
		bounds.bounds.width = BobComponent.WIDTH;
		bounds.bounds.height = BobComponent.HEIGHT;
		
		transform.pos.set(5.0f, 3.0f, 0.0f);
		
		state.set(BobComponent.STATE_IDLE);
		
		entity.add(animation);
		entity.add(bob);
		entity.add(bounds);
		entity.add(transform);
		entity.add(state);
		entity.add(texture);
		
		engine.addEntity(entity);
		
		
		return entity;
	}
}

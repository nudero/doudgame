package com.sn.game;

import java.util.Random;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.PooledEngine;
import com.sn.game.component.AnimationComponent;
import com.sn.game.component.BackgroundComponent;
import com.sn.game.component.BobComponent;
import com.sn.game.component.BoundsComponent;
import com.sn.game.component.MovementComponent;
import com.sn.game.component.PlatformComponent;
import com.sn.game.component.StateComponent;
import com.sn.game.component.TextureComponent;
import com.sn.game.component.TransformComponent;
import com.sn.game.system.BobSystem;

public class World {

	public static final float WORLD_WIDTH = 10;
	public static final float WORLD_HEIGHT = 15 * 20;
	
	public final Random rand = new Random();
	
	PooledEngine engine;
	
	public World(PooledEngine engine) {
		this.engine = engine;
	}
	
	public void create() {
		createBob();
		createBackground();
		createPlatform();
	}
	
	public Entity createBall() {
		Entity ball = engine.createEntity();
		TextureComponent texture = engine.createComponent(TextureComponent.class);
		TransformComponent transform = engine.createComponent(TransformComponent.class);
		BoundsComponent bounds = engine.createComponent(BoundsComponent.class);
		MovementComponent movement = engine.createComponent(MovementComponent.class);
		
		texture.region = Assets.spring;
		bounds.bounds.width = texture.region.getRegionWidth()/32.0f;
		bounds.bounds.height = texture.region.getRegionHeight()/32.0f;
		
		ball.add(texture);
		ball.add(transform);
		ball.add(bounds);
		ball.add(movement);
		engine.addEntity(ball);
		
		return ball;
	}
	
	public void createPlatform() {
		Entity entity = engine.createEntity();
		TextureComponent texture = engine.createComponent(TextureComponent.class);
		TransformComponent transform = engine.createComponent(TransformComponent.class);
		BoundsComponent bounds = engine.createComponent(BoundsComponent.class);
		PlatformComponent platform = engine.createComponent(PlatformComponent.class);
		MovementComponent movement = engine.createComponent(MovementComponent.class);
		texture.region = Assets.platform;
		platform.width = texture.region.getRegionWidth()/32.0f;
		platform.height = texture.region.getRegionHeight()/32.0f;
		platform.velocity = 4;
		transform.pos.set(5.0f, 8.0f, 2.0f);
		movement.velocity.x = rand.nextBoolean()?platform.velocity:-platform.velocity;

		entity.add(platform);
		entity.add(texture);
		entity.add(transform);
		entity.add(bounds);
		entity.add(movement);
		
		engine.addEntity(entity);
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
		
		transform.pos.set(5.0f, 3.0f, 2.0f);
		
		state.set(BobComponent.STATE_IDLE);
		
		entity.add(animation);
		entity.add(bob);
		entity.add(bounds);
		entity.add(transform);
		entity.add(state);
		entity.add(texture);
		
		engine.addEntity(entity);
		
		engine.getSystem(BobSystem.class).createBall(entity);
		
		return entity;
	}
}

package com.sn.game.system;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.core.PooledEngine;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.Gdx;
import com.sn.game.World;
import com.sn.game.component.BobComponent;
import com.sn.game.component.GravityComponent;
import com.sn.game.component.MovementComponent;
import com.sn.game.component.StateComponent;
import com.sn.game.component.TransformComponent;

public class BobSystem extends IteratingSystem {

	@SuppressWarnings("unchecked")
	private static final Family family = Family.all(BobComponent.class, StateComponent.class, 
			TransformComponent.class, MovementComponent.class).get();
	
	private World world;
	
	private Entity ball;
	private PooledEngine engine;
	boolean gottaBall;
	
	public BobSystem(World world, PooledEngine engine) {
		super(family);
		this.world = world;
		this.engine = engine;
		gottaBall = false;
	}

	@Override
	protected void processEntity(Entity entity, float deltaTime) {
		
	}
	
	
	
	@Override
	public void update(float deltaTime) {
		super.update(deltaTime);
		
		if (Gdx.input.isTouched()) {
			throwBall();
		}
	}
	
	public void throwBall() {
		if (ball == null || !gottaBall) {
			return;
		}
		GravityComponent gravity = engine.createComponent(GravityComponent.class);
		ball.add(gravity);
		MovementComponent movement = ball.getComponent(MovementComponent.class);
		movement.velocity.y = 20.0f;
		gottaBall = false;
	}

	public void createBall(Entity bob) {
		gottaBall = true;
		ball = world.createBall();
		TransformComponent pos = ball.getComponent(TransformComponent.class);
		TransformComponent bobPos = bob.getComponent(TransformComponent.class);
		pos.pos.set(bobPos.pos.x, bobPos.pos.y+0.9f, 1.0f);
	}
}

package com.sn.game.system;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.math.Vector2;
import com.sn.game.component.GravityComponent;
import com.sn.game.component.MovementComponent;

public class GravitySystem extends IteratingSystem {
	
	public static final Vector2 gravity = new Vector2(0, -20);
	
	private ComponentMapper<MovementComponent> mm;

	@SuppressWarnings("unchecked")
	public GravitySystem() {
		super(Family.all(GravityComponent.class, MovementComponent.class).get());
		
		mm = ComponentMapper.getFor(MovementComponent.class);
	}

	@Override
	protected void processEntity(Entity entity, float deltaTime) {
		MovementComponent move = mm.get(entity);
		move.velocity.add(gravity.x*deltaTime, gravity.y*deltaTime);
	}
}

package com.sn.game.system;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.math.Vector2;
import com.sn.game.component.MovementComponent;
import com.sn.game.component.TransformComponent;

public class MovementSystem extends IteratingSystem {

	private Vector2 tmp = new Vector2();
	
	private ComponentMapper<TransformComponent> tm;
	private ComponentMapper<MovementComponent> mm;
	
	@SuppressWarnings("unchecked")
	public MovementSystem() {
		super(Family.all(TransformComponent.class, MovementComponent.class).get());
		
		tm = ComponentMapper.getFor(TransformComponent.class);
		mm = ComponentMapper.getFor(MovementComponent.class);
	}

	@Override
	protected void processEntity(Entity entity, float deltaTime) {
		TransformComponent pos = tm.get(entity);
		MovementComponent move = mm.get(entity);
		
		tmp.set(move.accel).scl(deltaTime);
		move.velocity.add(tmp);
		
		tmp.set(move.velocity).scl(deltaTime);
		pos.pos.add(tmp.x, tmp.y, 0.0f);
	}

}

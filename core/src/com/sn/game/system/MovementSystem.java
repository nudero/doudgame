package com.sn.game.system;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.sn.game.component.MovementComponent;
import com.sn.game.component.TransformComponent;

public class MovementSystem extends IteratingSystem {

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
		
	}

}

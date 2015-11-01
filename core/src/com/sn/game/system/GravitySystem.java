package com.sn.game.system;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.sn.game.component.GravityComponent;
import com.sn.game.component.MovementComponent;

public class GravitySystem extends IteratingSystem {
	
	private ComponentMapper<MovementComponent> mm;

	@SuppressWarnings("unchecked")
	public GravitySystem() {
		super(Family.all(GravityComponent.class, MovementComponent.class).get());
		
		mm = ComponentMapper.getFor(MovementComponent.class);
	}

	@Override
	protected void processEntity(Entity entity, float deltaTime) {
		// TODO Auto-generated method stub
		
	}
}

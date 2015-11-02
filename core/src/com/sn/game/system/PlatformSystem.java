package com.sn.game.system;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.sn.game.World;
import com.sn.game.component.MovementComponent;
import com.sn.game.component.PlatformComponent;
import com.sn.game.component.TransformComponent;

public class PlatformSystem extends IteratingSystem {

	ComponentMapper<TransformComponent> tm;
	ComponentMapper<MovementComponent> mm;
	ComponentMapper<PlatformComponent> pm;
	
	@SuppressWarnings("unchecked")
	public PlatformSystem() {
		super(Family.all(PlatformComponent.class).get());
		
		tm = ComponentMapper.getFor(TransformComponent.class);
		mm = ComponentMapper.getFor(MovementComponent.class);
		pm = ComponentMapper.getFor(PlatformComponent.class);
	}

	@Override
	protected void processEntity(Entity entity, float deltaTime) {
		PlatformComponent platform = pm.get(entity);
		TransformComponent transform = tm.get(entity);
		MovementComponent movement = mm.get(entity);
		
		if (transform.pos.x < platform.width/2) {
			movement.velocity.x = -movement.velocity.x;
			transform.pos.x = platform.width/2;
		}
		else if (transform.pos.x > World.WORLD_WIDTH-platform.width/2) {
			movement.velocity.x = -movement.velocity.x;
			transform.pos.x = World.WORLD_WIDTH - platform.width/2;
		}
	}
}

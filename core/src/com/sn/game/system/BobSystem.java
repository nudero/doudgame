package com.sn.game.system;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.sn.game.World;
import com.sn.game.component.BobComponent;
import com.sn.game.component.MovementComponent;
import com.sn.game.component.StateComponent;
import com.sn.game.component.TransformComponent;

public class BobSystem extends IteratingSystem {

	@SuppressWarnings("unchecked")
	private static final Family family = Family.all(BobComponent.class, StateComponent.class, 
			TransformComponent.class, MovementComponent.class).get();
	
	private World world;
	
	public BobSystem(World world) {
		super(family);
		this.world = world;
	}

	@Override
	protected void processEntity(Entity entity, float deltaTime) {
		// TODO Auto-generated method stub
		
	}
}

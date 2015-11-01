package com.sn.game.system;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.sn.game.component.BoundsComponent;
import com.sn.game.component.TransformComponent;

public class BoundsSystem extends IteratingSystem {

	private ComponentMapper<TransformComponent> tm;
	private ComponentMapper<BoundsComponent> bm;
	
	@SuppressWarnings("unchecked")
	public BoundsSystem() {
		super(Family.all(BoundsComponent.class, TransformComponent.class).get());
	
		tm = ComponentMapper.getFor(TransformComponent.class);
		bm = ComponentMapper.getFor(BoundsComponent.class);
	}

	@Override
	protected void processEntity(Entity entity, float deltaTime) {
		// TODO Auto-generated method stub
		
	}
}

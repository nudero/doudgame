package com.sn.game;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.sn.game.component.AnimationComponent;
import com.sn.game.component.StateComponent;
import com.sn.game.component.TextureComponent;

public class AnimationSystem extends IteratingSystem {

	private ComponentMapper<AnimationComponent> am;
	private ComponentMapper<TextureComponent> tm;
	private ComponentMapper<StateComponent> sm;
	
	@SuppressWarnings("unchecked")
	public AnimationSystem() {
		super(Family.all(AnimationComponent.class, TextureComponent.class, StateComponent.class).get());
		
		am = ComponentMapper.getFor(AnimationComponent.class);
		tm = ComponentMapper.getFor(TextureComponent.class);
		sm = ComponentMapper.getFor(StateComponent.class);
	}

	@Override
	protected void processEntity(Entity entity, float deltaTime) {
		TextureComponent tex = 	tm.get(entity);
		AnimationComponent anim = am.get(entity);
		StateComponent state = sm.get(entity);
		
		Animation animation = anim.animations.get(state.get());
		if (animation != null) {
			tex.region = animation.getKeyFrame(state.time);
		}
		
		state.time += deltaTime;
	}
	
	
}

package com.sn.game.system;

import java.util.Comparator;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import com.sn.game.component.TextureComponent;
import com.sn.game.component.TransformComponent;

public class RenderingSystem extends IteratingSystem {
	static final float FRUSTUM_WIDTH = 10;
	static final float FRUSTUM_HEIGHT = 15;
	static final float PIXELS_TO_METRES = 1.0f / 32.0f;

	private SpriteBatch batch;
	private Array<Entity> renderQueue;
	private Comparator<Entity> comparator;
	private OrthographicCamera camera;

	private ComponentMapper<TextureComponent> textm;
	private ComponentMapper<TransformComponent> transm;

	@SuppressWarnings("unchecked")
	public RenderingSystem(SpriteBatch batch) {
		super(Family.all(TransformComponent.class, TextureComponent.class).get());

		textm = ComponentMapper.getFor(TextureComponent.class);
		transm = ComponentMapper.getFor(TransformComponent.class);

		comparator = new Comparator<Entity>() {
			@Override
			public int compare(Entity enta, Entity entb) {
				return (int) Math.signum(transm.get(entb).pos.z - transm.get(enta).pos.z);
			}
		};
		this.batch = batch;
		renderQueue = new Array<Entity>();

		camera = new OrthographicCamera(FRUSTUM_WIDTH, FRUSTUM_HEIGHT);
		camera.position.set(FRUSTUM_WIDTH / 2, FRUSTUM_HEIGHT / 2, 0);
	}

	@Override
	public void update(float deltaTime) {
		super.update(deltaTime);

		renderQueue.sort(comparator);
		camera.update();
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		for (Entity entity : renderQueue) {
			TextureComponent tex = textm.get(entity);
			if (tex.region == null) {
				continue;
			}
			
			TransformComponent t = transm.get(entity);

			float width = tex.region.getRegionWidth();
			float height = tex.region.getRegionHeight();
			float originX = width * 0.5f;
			float originY = height * 0.5f;
			batch.draw(tex.region, t.pos.x - originX, t.pos.y - originY,
					originX, originY, width, height, t.scale.x*PIXELS_TO_METRES, t.scale.y*PIXELS_TO_METRES,
					MathUtils.radiansToDegrees * t.rotation);
		}

		batch.end();
		renderQueue.clear();
	}

	@Override
	protected void processEntity(Entity entity, float deltaTime) {
		renderQueue.add(entity);
	}

	public OrthographicCamera getCamera() {
		return camera;
	}
}

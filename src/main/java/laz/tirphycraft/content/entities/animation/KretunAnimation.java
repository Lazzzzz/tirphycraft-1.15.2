package laz.tirphycraft.content.entities.animation;

public class KretunAnimation {

	private float floats_part = 0;
	private boolean done = false;
	private boolean bite_animation = false;
	private float steps = 0.03f;
	private int timer = 0;

	public void update() {
		if (bite_animation) {
			if (floats_part < 1.6) {
				floats_part += steps * 20;
				if (floats_part > 1.6)
					floats_part = 1.6f;
			}
			timer += 4;
			if (timer > 40) {
				done = true;
				stopBite();
			}
		} else {
			done = false;
			if (floats_part > 0) {
				floats_part -= steps;
				if (floats_part < 0)
					floats_part = 0;
			}
		}
	}

	public float getPart() {
		return floats_part;
	}

	public void startBite() {
		timer = 0;
		bite_animation = true;
	}

	public void stopBite() {
		timer = 0;
		bite_animation = false;
	}
	
	public boolean isDone() {
		return this.done;
	}

}

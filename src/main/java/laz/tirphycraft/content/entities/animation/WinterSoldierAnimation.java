package laz.tirphycraft.content.entities.animation;

public class WinterSoldierAnimation {
	boolean bite_animation = false;
	private float float_parts = 0; 
	private int timer = 0;
	
	public void update() {
		if (bite_animation) {
			timer += 1;
			if (timer >= 5) {
				float_parts = 0.08f;
			}
			if (timer == 10) {
				float_parts = 0;
				timer = 0;
				bite_animation = false;
			}
		}
	}
	
	public float getPart() {
		return float_parts;
	}

	public void startBite() {
		bite_animation = true;
	}
	
}

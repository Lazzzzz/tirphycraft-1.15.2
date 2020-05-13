package laz.tirphycraft.util;

public enum TirphyColor {

    BLUE(0, 0, 0, 1),
    GREEN(1, 0, 1, 0),
    RED(2, 1, 0, 0),
    YELLOW(3, 1, 1, 0),
    PINK(4, 1f, 0.5f, 0.5f),
    PURPLE(5, 0.5f, 0, 1),
    WHITE(6, 1, 1, 1);

    private final float index;
    private final float blue;
    private final float green;
    private final float red;

    TirphyColor(int index, float red, float green, float blue) {
        this.index = index;
        this.blue = blue;
        this.green = green;
        this.red = red;
    }

    public float getIndex() {
        return index;
    }

    public float getBlue() {
        return blue;
    }

    public float getGreen() {
        return green;
    }

    public float getRed() {
        return red;
    }

    public static TirphyColor getColorfromIndex(int index) {
        switch (index) {
            case 0:
                return BLUE;
            case 1:
                return GREEN;
            case 2:
                return RED;
            case 3:
            	return YELLOW;
            case 4:
            	return PINK;
            case 5:
            	return PURPLE;
            case 6:
            	return WHITE;
            default:
                throw new IllegalStateException("Unexpected variant: " + index);
        }
    }
}

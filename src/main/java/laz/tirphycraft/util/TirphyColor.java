package laz.tirphycraft.util;

public enum TirphyColor {

    BLUE(0, 1, 1, 1),
    GREEN(1, 1, 1, 1),
    RED(2, 1, 1, 1);

    private final int index;
    private final int blue;
    private final int green;
    private final int red;

    TirphyColor(int index, int blue, int green, int red) {
        this.index = index;
        this.blue = blue;
        this.green = green;
        this.red = red;
    }

    public int getIndex() {
        return index;
    }

    public int getBlue() {
        return blue;
    }

    public int getGreen() {
        return green;
    }

    public int getRed() {
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
            default:
                throw new IllegalStateException("Unexpected variant: " + index);
        }
    }
}

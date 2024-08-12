package net.icxd.imguitest.utils;

public class Color {
    public static final Color White = new Color(0xFFFFFFFF);
    public static final Color Black = new Color(0xFF000000);
    public static final Color DavysGray = new Color(0xff4D5057);
    public static final Color HookersGreen = new Color(0xff4e6e5d);
    public static final Color ShamrockGreen = new Color(0xff4da167);
    public static final Color DarkPastelGreen = new Color(0xff3bc14a);
    public static final Color Timberwolf = new Color(0xffcfcfcf);

    public final int r, g, b, a;

    public Color(int r, int g, int b, int a) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.a = a;
    }

    // e.g. 0xFF0000FF
    public Color(int hex) {
        this.r = (hex >> 16) & 0xFF;
        this.g = (hex >> 8) & 0xFF;
        this.b = hex & 0xFF;
        this.a = (hex >> 24) & 0xFF;
    }

    public Color darken(float factor) { return new Color((int) (r * factor), (int) (g * factor), (int) (b * factor), a); }
    public Color lighten(float factor) { return new Color((int) (r + (255 - r) * factor), (int) (g + (255 - g) * factor), (int) (b + (255 - b) * factor), a); }
    public int toInt() { return (a << 24) | (r << 16) | (g << 8) | b; }
}

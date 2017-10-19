package hs.utility.Struct;

import java.nio.ByteBuffer;

/**
 * Created by ParkHonsSic on 2016-10-04.
 * C#에서 쓰던 Color 클래스를 변형하여 자바에 맞게 포팅함
 * Byte값이 -128~127 이기에 사용하지 마십시오. (이 클래스는 0~255인 Byte에 특화되어있습니다.)
 * 따라서 개선이되면 Deprecated 제거하겠습니다.
 */

@Deprecated
public class Color
{
    private final int ARGBAlphaShift  = 24;
    private final int ARGBRedShift    = 16;
    private final int ARGBGreenShift  = 8;
    private final int ARGBBlueShift   = 0;

    public byte A = (byte)255;
    public byte R;
    public byte G;
    public byte B;

    public Color(byte A, byte R, byte G, byte B) {this.A = A; this.R = R;this.G = G;this.B = B;}
    public Color(byte R, byte G, byte B) {this.R = R;this.G = G;this.B = B;}
    public Color(int color)
    {
        this.A = (byte)(color >>> ARGBAlphaShift);
        this.R = (byte)(color >>> ARGBRedShift);
        this.G = (byte)(color >>> ARGBGreenShift);
        this.B = (byte)(color >>> ARGBBlueShift);
    }

    public int getInt()
    {
        //return ByteBuffer.wrap(bytes)

        return((0xFF & A)<<ARGBAlphaShift)|((0xFF & R)<<ARGBRedShift)|((0xFF & G)<<ARGBGreenShift)|((0xFF & B)<<ARGBBlueShift);
    }

    /**Hue-Saturation-Brightness (HSB) 밝기 구하기 */
    public float getBrightness()
    {
        float r = (float)R / 255.0f;
        float g = (float)G / 255.0f;
        float b = (float)B / 255.0f;

        float max, min;

        max = r; min = r;

        if (g > max) max = g;
        if (b > max) max = b;

        if (g < min) min = g;
        if (b < min) min = b;

        return(max + min) / 2;
    }

    /**Hue-Saturation-Brightness (HSB) 구하기 */
    public float getHue()
    {
        if (R == G && G == B)
            return 0; // 0 makes as good an UNDEFINED value as any

        float r = (float)R / 255.0f;
        float g = (float)G / 255.0f;
        float b = (float)B / 255.0f;

        float max, min;
        float delta;
        float hue = 0.0f;

        max = r; min = r;

        if (g > max) max = g;
        if (b > max) max = b;

        if (g < min) min = g;
        if (b < min) min = b;

        delta = max - min;

        if (r == max) {
            hue = (g - b) / delta;
        }
        else if (g == max) {
            hue = 2 + (b - r) / delta;
        }
        else if (b == max) {
            hue = 4 + (r - g) / delta;
        }
        hue *= 60;

        if (hue < 0.0f) {
            hue += 360.0f;
        }
        return hue;
    }

    /**Hue-Saturation-Brightness (HSB) 채도 구하기 */
    public float getSaturation()
    {
        float r = (float)R / 255.0f;
        float g = (float)G / 255.0f;
        float b = (float)B / 255.0f;

        float max, min;
        float l, s = 0;

        max = r; min = r;

        if (g > max) max = g;
        if (b > max) max = b;

        if (g < min) min = g;
        if (b < min) min = b;

        // if max == min, then there is no color and
        // the saturation is zero.
        //
        if (max != min) {
            l = (max + min) / 2;

            if (l <= .5) {
                s = (max - min)/(max + min);
            }
            else {
                s = (max - min)/(2 - max - min);
            }
        }
        return s;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder(32);
        sb.append("A=");
        sb.append(A);
        sb.append(", R=");
        sb.append(R);
        sb.append(", G=");
        sb.append(G);
        sb.append(", B=");
        sb.append(B);
        return sb.toString();
    }
}

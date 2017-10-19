package kr.arumnarae.finder.Libs.HSUtillity.Structs;

/**
 * Created by ParkHongSic on 2016-09-10.
 * @author 박홍식 (ParkHongSic, 조장찡, gpo04174, HSKernel)
 */
public class SizeF {

    public float Width;
    public float Height;

    public SizeF(){}
    public SizeF(float Width, float Height){setSize(Width, Height);}

    public SizeF setSize(float Width, float Height)
    {
        this.Width = Width;
        this.Height = Height;
        return this;
    }

}
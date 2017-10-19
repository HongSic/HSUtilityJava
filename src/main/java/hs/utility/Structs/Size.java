package kr.arumnarae.finder.Libs.HSUtillity.Structs;

/**
 * Created by ParkHongSic on 2016-09-10.
 * @author 박홍식 (ParkHongSic, 조장찡, gpo04174, HSKernel)
 */
public class Size {

    public int Width;
    public int Height;

    public Size(){}
    public Size(int Width, int Height){setSize(Width, Height);}

    public Size setSize(int Width, int Height)
    {
        this.Width = Width;
        this.Height = Height;
        return this;
    }

}
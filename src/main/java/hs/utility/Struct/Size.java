package hs.utility.Struct;
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

    @Override
    public boolean equals(Object obj)
    {
        Size size = (Size)obj;
        if(size == null)return false;
        else return size.Width == Width && size.Height == Height;
    }
}
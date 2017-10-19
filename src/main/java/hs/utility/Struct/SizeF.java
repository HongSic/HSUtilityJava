package hs.utility.Struct;

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

    @Override
    public boolean equals(Object obj)
    {
        SizeF size = (SizeF)obj;
        if(size == null)return false;
        else return size.Width == Width && size.Height == Height;
    }
}
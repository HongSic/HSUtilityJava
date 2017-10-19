package hs.utility.Struct;

/**
 * Created by ParkHongSic on 2016-09-10.
 */
public class Size {

    public int Width;
    public int Height;

    public Size(){}
    public Size(int Width, int Height){setSize(Width, Height);}

    public void setSize(int Width, int Height)
    {
        this.Width = Width;
        this.Height = Height;
    }

}

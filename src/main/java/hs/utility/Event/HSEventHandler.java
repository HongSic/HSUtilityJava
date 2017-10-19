package hs.utility.Event;

/**
 * C# 처럼 이벤트 비슷하게 쓸 수 있게해주는 클래스 (이벤트 핸들러)
 * Created by ParkHongSic on 2016-09-03.
 */
public interface HSEventHandler<TEventArgs extends HSEventArgs> {
    void eventReceived(Object sender, TEventArgs e);
}

package hs.utility.Event;

import java.util.ArrayList;

/**
 * C# 처럼 이벤트 비슷하게 쓸 수 있게해주는 클래스
 * Created by ParkHongSic on 2016-09-03.
 */
public final class HSEvent<TEventArgs extends HSEventArgs> {
    // Event Handler List
    private ArrayList<HSEventHandler<TEventArgs>> observerList = new ArrayList<HSEventHandler<TEventArgs>>();
    // Raise Event
    public void raiseEvent(Object sender, TEventArgs e) {
        for(HSEventHandler<TEventArgs> handler : this.observerList) {
            try{handler.eventReceived(sender, e);}catch (Exception ex){}
        }
    }
    // Add Event Handler
    public void addEventHandler(HSEventHandler<TEventArgs> handler) {
        this.observerList.add(handler);
    }

    // Remove Event Handler
    public void removeEventHandler(HSEventHandler<TEventArgs> handler) {
        this.observerList.remove(handler);
    }
}

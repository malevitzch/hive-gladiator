package core.event;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;
public class EventBus {
    public interface EventCallback{
        public void OnEvent(Event pEvent);
    }

    static public void Init(){
        Events = new LinkedList<Event>();
        Subscribers = new Vector<EventCallback>();
    }

    static public void Shutdown(){

    }

    static public void Subscribe(EventCallback pCallback){
        Subscribers.add(pCallback);
    }

    static public void Broadcast(Event pEvent){
        Events.add(pEvent);
    }

    static public void Update(){
        while(!Events.isEmpty())
        {
            Event current = Events.remove();
            for(EventCallback i : Subscribers)
            {
                i.OnEvent(current);
            }
        }
    }

    static private Queue<Event> Events;
    static private Vector<EventCallback> Subscribers;

}

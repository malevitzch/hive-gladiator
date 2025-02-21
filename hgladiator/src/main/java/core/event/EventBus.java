package core.event;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;
public class EventBus {
	
    public interface EventCallback {
        public void onEvent(Event pEvent);
    }

    static public void Init() {
        events = new LinkedList<Event>();
        subscribers = new Vector<EventCallback>();
    }

    static public void shutdown() {

    }

    static public void subscribe(EventCallback pCallback) {
        subscribers.add(pCallback);
    }

    static public void broadcast(Event pEvent) {
        events.add(pEvent);
    }

    static public void update() {
        while(!events.isEmpty()) {
            Event current = events.remove();
            for(EventCallback i : subscribers) {
                i.onEvent(current);
            }
        }
    }

    static private Queue<Event> events;
    static private Vector<EventCallback> subscribers;

}

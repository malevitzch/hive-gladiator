package core.event;

public abstract class Event {
    public enum Type{
        WindowClosed,
        KeyPressed,
        KeyReleased,
        KeyTyped,
        MouseButtonPressed,
        MouseButtonReleased
    }
    public Type type;
    public String ToString() {
        return "Event\n";
    }
}

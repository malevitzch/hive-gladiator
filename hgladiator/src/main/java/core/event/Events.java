package core.event;

public class Events {
    public static class WindowClosedEvent extends Event {
        public WindowClosedEvent() {
            type = Type.WindowClosed;
        }
        public final String ToString(){
            return "Window Closed.";
        }
    }

    public static class KeyPressedEvent extends Event {
        public KeyPressedEvent(KeyCode pCode) {
            type = Type.KeyPressed;
            code = pCode;
        }

        public final String ToString() {
            return "Key Pressed: " + code.name();
        }

        public KeyCode code;
    }

    public static class KeyReleasedEvent extends Event{
        public KeyReleasedEvent(KeyCode pCode) {
            type = Type.KeyReleased;
            code = pCode;
        }

        public final String ToString() {
            return "Key Released: " + code.name();
        }
        public KeyCode code;
    }

    public static class MouseButtonPressedEvent extends Event {
        public MouseButtonPressedEvent(KeyCode pCode) {
            type = Type.MouseButtonPressed;
            code = pCode;
        }

        public final String ToString() {
            return "Mouse Button Pressed: " + code.name();
        }
        public KeyCode code;
    }

    public static class MouseButtonReleasedEvent extends Event{
        public MouseButtonReleasedEvent(KeyCode pCode) {
            type = Type.MouseButtonReleased;
            code = pCode;
        }

        public final String ToString() {
            return "Mouse Button Released: " + code.name();
        }
        public KeyCode code;
    }
}

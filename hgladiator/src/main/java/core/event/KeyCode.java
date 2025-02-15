package core.event;

import java.util.HashMap;
import java.util.Map;
public enum KeyCode {
        Backspace   (0x08),
        Tab         (0x09),
        Clear       (0x0C),
        Enter       (0x0D),
        Shift       (0x10),
        Control     (0x11),
        Alt         (0x12),
        Pause       (0x13),
        CapsLock    (0x14),
        Esc         (0x1B),
        Space       (0x20),
        PageUp      (0x21),
        PageDown    (0x22),
        Home        (0x24),
        Left        (0x25),
        Up          (0x26),
        Right       (0x27),
        Down        (0x28),
        PrintScreen (0x2C),
        Insert      (0x2D),
        Delete      (0x2E),
        Help	    (0x2F),

        D0		    (0x30),
        D1		    (0x31),
        D2		    (0x32),
        D3		    (0x33),
        D4		    (0x34),
        D5		    (0x35),
        D6		    (0x36),
        D7		    (0x37),
        D8		    (0x38),
        D9		    (0x39),

        A		    (0x41),
        B		    (0x42),
        C		    (0x43),
        D		    (0x44),
        E		    (0x45),
        F		    (0x46),
        G		    (0x47),

        H           (0x48),
        I           (0x49),
        J           (0x4A),
        K           (0x4B),
        L           (0x4C),
        M           (0x4D),
        N           (0x4E),
        O           (0x4F),
        P           (0x50),
        Q           (0x51),
        R           (0x52),
        S           (0x53),
        T           (0x54),
        U           (0x55),
        V           (0x56),
        W           (0x57),
        X           (0x58),
        Y           (0x59),
        Z		    (0x5A),

        N0          (0x60),
        N1          (0x61),
        N2          (0x62),
        N3          (0x63),
        N4          (0x64),
        N5          (0x65),
        N6          (0x66),
        N7          (0x67),
        N8          (0x68),
        N9		    (0x69),

        Multiply    (0x6A),
        Add		    (0x6B),
        Separator   (0x6C),
        Subtract    (0x6D),
        Decimal     (0x6E),
        Divide	    (0x6F),

        F1		    (0x70),
        F2		    (0x71),
        F3		    (0x72),
        F4		    (0x73),
        F5		    (0x74),
        F6          (0x75),
        F7          (0x76),
        F8          (0x77),
        F9          (0x78),
        F10         (0x79),
        F11         (0x7A),
        F12         (0x7B),
        F13         (0x7C),
        F14		    (0x7D),

        Numlock     (0x90),
        ScrollLock  (0x91),

        LShift      (0xA0),
        RShift      (0xA1),
        LControl    (0xA2),
        RControl    (0xA3),
        LMenu	    (0xA4),
        RMenu       (0xA5),

        Mute        (0xAD),
        VolumeUp    (0xAF),
        VolumeDown  (0xAE),

        MouseButtonLeft (0x00),
        MouseButtonRight (0x01),
        MouseButtonMiddle (0x02);
        private static final Map map = new HashMap<>();
        static {
                for (KeyCode code : KeyCode.values()) {
                        map.put(code.code, code);
                }
        }
        public static KeyCode FromInt(int pCode){return (KeyCode)map.get(pCode);}
        private final int code;

        int Code(){
                return code;
        }
        KeyCode(int pCode){
            code = pCode;
        }

}

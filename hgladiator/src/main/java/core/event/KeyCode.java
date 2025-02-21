package core.event;

import java.util.HashMap;
import java.util.Map;
public enum KeyCode {
        Backspace   (259),
        Tab         (258),
        Enter       (257),
        Pause       (284),
        CapsLock    (280),
        Esc         (256),
        Space       (32),
        PageUp      (266),
        PageDown    (267),
        Home        (268),
        Left        (263),
        Up          (265),
        Right       (262),
        Down        (264),
        PrintScreen (283),
        Insert      (260),
        Delete      (261),

        D0		    (48),
        D1		    (49),
        D2		    (50),
        D3		    (51),
        D4		    (52),
        D5		    (53),
        D6		    (54),
        D7		    (55),
        D8		    (56),
        D9		    (57),

        A		    (65),
        B		    (66),
        C		    (67),
        D		    (68),
        E		    (69),
        F		    (70),
        G		    (71),

        H           (72),
        I           (73),
        J           (74),
        K           (75),
        L           (76),
        M           (77),
        N           (78),
        O           (79),
        P           (80),
        Q           (81),
        R           (82),
        S           (83),
        T           (84),
        U           (85),
        V           (86),
        W           (87),
        X           (88),
        Y           (89),
        Z		    (90),


        Multiply    (332),
        Add		    (334),
        Subtract    (333),
        Decimal     (330),
        Divide	    (331),

        F1		    (290),
        F2		    (291),
        F3		    (292),
        F4		    (293),
        F5		    (294),
        F6          (295),
        F7          (296),
        F8          (297),
        F9          (298),
        F10         (299),
        F11         (300),
        F12         (301),


        LShift      (340),
        RShift      (344),
        LControl    (341),
        RControl    (345),
        LAlt        (342),
        RAlt        (346),
        MouseButtonLeft (0x00),
        MouseButtonRight (0x01),
        MouseButtonMiddle (0x02),

        Undefined(-42);
        private static final Map map = new HashMap<>();
        static {
                for (KeyCode code : KeyCode.values()) {
                        map.put(code.code, code);
                }
        }
        public static KeyCode FromInt(int pCode){
                KeyCode code = (KeyCode)map.get(pCode);
                if(code == null) return Undefined;
                return code;
        }
        private final int code;

        public int Code(){
                return code;
        }
        KeyCode(int pCode){
            code = pCode;
        }

}

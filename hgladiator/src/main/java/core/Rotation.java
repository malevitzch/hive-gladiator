package core;

public class Rotation {

    public static double Degrees(double radians) {
        return radians * 180 / Math.PI;
    };

    public static double Radians(double degrees) {
        return degrees * Math.PI / 180;
    };
}

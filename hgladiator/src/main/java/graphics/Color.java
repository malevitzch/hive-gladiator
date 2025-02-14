package graphics;

public class Color {
    public float r;
    public float g;
    public float b;
    public float a;

    public Color() {
        r = g = b = 1.0f;
        a = 0;
    }

    public Color(float pR, float pG, float pB, float pA){
            r = pR;
            g = pG;
            b = pB;
            a = pA;
    }

    public Color(int pR,int pG,int pB, int pA){

            r = (float)pR / (float)256.0;
            g = (float)pG / (float)256.0;
            b = (float)pB / (float)256.0;
            a = (float)pA / (float)256.0;
    }
}

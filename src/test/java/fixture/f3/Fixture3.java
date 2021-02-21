package fixture.f3;

public class Fixture3 {

    public int m1() {
        int a = 1;
        int b = a + 2;

        return a + b;
    }

    public int m2() {
        int a = 1;
        int b = a + 2;
        int c = b + 3;
        int d = c + 6;
        int e = d * 3;
        int f = e + d;

        if(b == 3) {
            f += 5;
        }

        return a + b - c + e * f;
    }
}

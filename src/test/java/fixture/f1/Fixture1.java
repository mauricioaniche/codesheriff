package fixture.f1;

public class Fixture1 {

    int m1() {
        int a = 1;
        return a + 2;
    }

    int m2(int a, int b) {

        if(a > 10) {
            if(b < 20) {
                if(a>50) {
                    return 50;
                }
            }
        }

        return 10;
    }

}

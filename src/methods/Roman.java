package methods;

public enum Roman {
    I(1),
    II(2),
    III(3),
    IV(4),
    V(5),
    VI(6),
    VII(7),
    VIII(8),
    IX(9),
    X(10),
    XL(40),
    L(50),
    XC(90),
    C(100);

    private int arab;

    public int getArab() {
        return arab;
    }


    Roman(int arab) {
        this.arab = arab;
    }

    public static String convert(int s) {// перевод из римских -мы идём с конца и приписываем справа цифру,уменьшая арабскую запись
        Roman[] all = Roman.values();
        int n = all.length - 1;
        String S = "";
        while (s != 0) {
            if (s == all[n].getArab()) {
                S += all[n].name();
                break;
            } else if (s > all[n - 1].getArab() && n > 0) {
                S += all[n - 1].name();
                s -= all[n - 1].getArab();
            } else n--;

        }
        return S;
    }
}

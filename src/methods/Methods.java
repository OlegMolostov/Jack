package methods;

import static java.lang.Math.abs;

public class Methods {


    public static boolean contains(String s) {
        boolean b = false;
        String[] operations = {"+", "-", "*", "/"};
        for (String l : operations
        ) {
            if (l.equals(s)) {
                b = true;
                break;

            }
        }

        return b;
    }

    public static int ArAndRom(String s1, String s2) {
        int i1, i2;
        try {
            i1 = Integer.parseInt(s1);
            i2 = Integer.parseInt(s2);
            if (i1 > 0 && i1 < 11 && i2 > 0 && i2 < 11) {
                return 0;
            }
            return 2;
        } catch (Exception e) {
            try {
                Roman r1 = Roman.valueOf(s1);
                Roman r2 = Roman.valueOf(s2);
                if (r1.getArab() > 0 && r1.getArab() < 11 && r2.getArab() > 0 && r2.getArab() < 11) {
                    return 1;
                }
                return 2;
            } catch (Exception l) {
                return 2;
            }
        }

    }

    public static int Operation(String[] s) {
        int i1, i2;
        i1 = Integer.parseInt(s[0]);
        i2 = Integer.parseInt(s[2]);

        switch (s[1]) {
            case "+":
                return i1 + i2;
            case "-":
                return i1 - i2;
            case "*":
                return i1 * i2;
            default:
                return i1 / i2;
        }

    }

    public static String Operation1(String[] s) {
        String k = "";
        int res;
        String[] list = {Roman.valueOf(s[0]).getArab() + "", s[1], Roman.valueOf(s[2]).getArab() + ""};
        res = Operation(list);
        if (res == 0) {
            return 0 + k;
        } else if (res < 0) {
            res = abs(res);
            k = "-";
        }

        k = k + Roman.convert(res);
        return k;
    }

}

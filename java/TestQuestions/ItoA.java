package TestQuestions;

/**
 * Created by jun on 3/23/2015.
 */
public class ItoA {
    private char getChar(int digit) {
        if (digit < 10) {
            return (char) ('0' + digit);
        } else {
            return (char) ('A' + digit - 10);
        }
    }

    public String iToA(int value, int base) {
        if (base != 8 && base != 10 && base != 16) {
            return null;
        }

        if (value == 0) {
            return "0";
        }

        int temp = value > 0 ? value : value * -1;
        int mod = 0;
       // we know that Integer.MAX_VALUE is not going to be more than 16 digits in Octal, Decimal or Hex
        char[] result = new char[16];
        int count = 0;

        while (temp > 0) {
            mod = temp % base;
            temp = temp / base;
            result[count++] = getChar(mod);
        }

        // revert the result
        char[] newResult = new char[count];
        for (int i = 0; i < count; i++) {
            newResult[i] = result[count - i - 1];
        }

        return value > 0 ? new String(newResult) : "-" + new String(newResult);
    }
}

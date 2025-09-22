package Chap10.Page296;

import java.util.Locale;

public class TestFormats {
    public static void main(String[] args) {
        long myBillion = 1_000_000_000;

        // Add commas for readability using US locale
        String formattedNumber = String.format(Locale.US, "%,d", myBillion);

        System.out.println(formattedNumber);
    }
}



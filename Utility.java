import java.util.Random;
import java.util.Scanner;

public class Utility {

    private Utility() {

    }



    public static String randomString() {
        String horse = "horse_";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            Random r = new Random();
            char c = (char) (r.nextInt(26) + 'a');
            sb.append(c);
        }
        return horse + sb.toString();
    }

    public static String randomString(int numbOfChar) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numbOfChar; i++) {
            Random r = new Random();
            char c = (char) (r.nextInt(26) + 'a');
            sb.append(c);
        }
        return sb.toString();
    }

    public static int getIntegerInput(String text) {
        Scanner sc = new Scanner(System.in);

        System.out.printf(text);

        while (true) {
            try {

                int input = Integer.parseInt(sc.nextLine());
                System.out.println(input);
                return input >= 0 ? input : -1;

            } catch (NumberFormatException e) {
                System.out.printf("Input should only be a positive integer.\nPlease input another value: ");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}

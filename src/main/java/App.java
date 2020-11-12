public class App {

    public static void main(String[] args) {

    }

    public static String rtl(String str) throws RuntimeException {

        if (str == null ||
                str.length() == 0 ||
                str.replaceAll("[^A-Z]", "").length() != str.length()) {
            throw new RuntimeException("Wrong format");
        }

        StringBuilder result = new StringBuilder();

        char temp = '0';
        short count = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch != temp) {
                if (count > 1) result.append(count);
                result.append(String.valueOf(ch));
                count = 0;
            }
            temp = ch;
            count++;
        }
        if (count > 1) result.append(count);
        System.out.println(result);
        return result.toString();
    }
}

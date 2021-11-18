import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionsTask {
    public static void main(String[] args) {
        String firstEmail = "sulina@gmail.com";
        String secondEmail = "sulina01@gmail.com";
        System.out.println(IsEmailAddress1(firstEmail));
        System.out.println(IsEmailAddress2(secondEmail));
        System.out.println(IsEmailAddress3(secondEmail));

        String text = "В 20:55 он решил съесть бутерброд, в 28:15 он лег спать и проснулся тольков в 09:38";
        TimeSearch(text);

        String text2 = "Часть состоит из 31 бытовой сценки и повествует о жизни простых советских людей: рабочих , чиновников  , инженеров   , люмпенизированных низов общества. ";
        System.out.println(DeleteSpaces(text2));

        String text3 = "Какая-то сине-зеленовая трава";
        System.out.println(SwapPartsOfWord(text3));

        String text4 = "КОТ кот! скот КоТ, который КОТ.";
        System.out.println(HowManyCats(text4));

        String text5 = "У меня 2 яблока и -4 банана";
        System.out.println(IncreaseByOne(text5));
    }

    private static boolean IsEmailAddress1(String email) {
        return email.matches("[a-z]+@[a-z]+\\.[a-z]{2,4}");
    }

    private static boolean IsEmailAddress2(String email) {
        return email.matches("[a-z0-9-_]+@[a-z0-9-_]+\\.[a-z]{2,4}");
    }

    private static boolean IsEmailAddress3(String email) {
        return email.matches("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])");
    }

    private static void TimeSearch(String text) {
        Pattern timePattern = Pattern.compile("(\\d\\d):(\\d\\d)");
        Matcher m = timePattern.matcher(text);
        String result = "";
        while (m.find()) {
            // if (m.group(1).matches("[01]\\d|20|21|22|23") && m.group(2).matches("([012345])\\d"))
            if (Integer.parseInt(m.group(1)) < 24 && Integer.parseInt(m.group(2)) < 60)
                result = "Соответствует формату";
            else
                result = "Не соответствует формату";
            System.out.println(m.group() + " " + result);
        }
    }

    private static String DeleteSpaces(String text) {
        return text.replaceAll("\\s+(,)", "$1");
    }

    private static String SwapPartsOfWord(String text) {
        return text.replaceAll("([a-zA-Zа-яА-Я]+)-([a-zA-Zа-яА-Я]+)", "$2-$1");
    }

    private static int HowManyCats(String text) {
        // "\b" символ "границы слова" не работает для кириллицы
        int count = 0;
        Scanner in = new Scanner(text);
        Pattern catPattern = Pattern.compile("^кот(\\p{Punct}|$)", Pattern.CASE_INSENSITIVE + Pattern.UNICODE_CASE);
        while (in.hasNext()) {
            Matcher c = catPattern.matcher(in.next());
            if (c.find())
                count++;
        }
        return count;
    }
    private static String IncreaseByOne(String text) {
        int digit;
        Pattern number = Pattern.compile("-?(\\d+)");
        Matcher n = number.matcher(text);
        while (n.find()) {
            digit = Integer.parseInt(n.group()) + 1;
            text = text.replaceAll(n.group(), Integer.toString(digit));
        }
        return text;

//        Scanner in = new Scanner(text);
//        while (in.hasNext()) {
//            if (in.hasNextInt())
//                System.out.print(1 + in.nextInt() + " ");
//            else
//                System.out.print(in.next() + " ");
//        }
    }
}

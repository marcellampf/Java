import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdvancedRegexLab {

    public static void main(String[] args) {
        matchComplexPattern();
        findMultiplePatterns();
        extractDataUsingGroups();
        validatePhoneNumber();
        replaceMultiplePatterns();
        matchComplexQuantifiers();
        matchWordsStartingWithSpecificLetter();
        matchPatternsWithSpecialCharacters();
        splitStringUsingComplexPattern();
        useMatchesMethodForComplexPatterns();
    }

    public static void matchComplexPattern() {
        String text = "Bartolomeu loves kale";
        String regex = "Bartolomeu loves kale";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        System.out.println("Task 1: " + matcher.matches());
    }

// Task 2
    public static void findMultiplePatterns() {
        String text = "Email addresses: marcellademelopf@gmail.com, marcellampf1@gmail.com";
        String regex = "[\\w.%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        System.out.println("Task 2:");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    // Task 3
    public static void extractDataUsingGroups() {
        String text = "Product: pineaple, Price: $1.99, Quantity: 10";
        String regex = "Product: (.*), Price: \\$(.*), Quantity: (\\d+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        System.out.println("Task 3:");
        if (matcher.find()) {
            System.out.println("Product: " + matcher.group(1));
            System.out.println("Price: $" + matcher.group(2));
            System.out.println("Quantity: " + matcher.group(3));
        }
    }

    // Task 4
    public static void validatePhoneNumber() {
        String text = "647-632-8314";
        String regex = "\\d{3}-\\d{3}-\\d{4}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        System.out.println("Task 4: " + matcher.matches());
    }

    // Task 5
    public static void replaceMultiplePatterns() {
        String text = "two three four five";
        String regex = "two";
        String result = text.replaceAll(regex, "qux");
        System.out.println("Task 5: " + result);
    }

    // Task 6
    public static void matchComplexQuantifiers() {
        String text = "plkodfijuhbinoimpdsa";
        String regex = "(\\w)\\1{3}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        System.out.println("Task 6:");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    // Task 7
    public static void matchWordsStartingWithSpecificLetter() {
        String text = "apple banana kale lettuce";
        String regex = "\\ba\\w*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        System.out.println("Task 7:");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    // Task 8
    public static void matchPatternsWithSpecialCharacters() {
        String text = "file1.txt, file2.txt, file3.doc";
        String regex = "\\b\\w+\\.txt\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        System.out.println("Task 8:");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    // Task 9
    public static void splitStringUsingComplexPattern() {
        String text = "one:two;three|four,five.six";
        String regex = "[:;|,.]";
        String[] result = text.split(regex);
        System.out.println("Task 9:");
        for (String str : result) {
            System.out.println(str);
        }
    }

    // Task 10
    public static void useMatchesMethodForComplexPatterns() {
        String text = "A1b2C3";
        String regex = "([a-zA-Z][0-9])+";
        boolean matches = text.matches(regex);
        System.out.println("Task 10: " + matches);
    }
}

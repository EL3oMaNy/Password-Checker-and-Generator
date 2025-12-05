import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections; //فيها دالة shuffle لخلط العناصر
import java.util.List;
public class PasswordGenerator {
private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
private static final String DIGITS = "0123456789";
private static final String SYMBOLS = "!@#$%^&*()-_=+[]{};:,.<>?/";
private final SecureRandom random = new SecureRandom();
    private final int minLength ;
    {
        minLength=8;
    }
    public String generate(int length) {
        if (length < minLength) {
            //لو اليوزر حاول يعمل باسورد أقل من 8… ارمي Error وقف البرنامج
            throw new IllegalArgumentException("Length must be at least " + minLength);
        }
        //بننشئ قائمة مؤقتة pwd علشان نضيف فيها الأحرف اللي هنكوّن منهم الباسورد
        List<Character> pwd = new ArrayList<>();
        pwd.add(randomChar(UPPER));
        pwd.add(randomChar(LOWER));
        pwd.add(randomChar(DIGITS));
        pwd.add(randomChar(SYMBOLS));
        String all = UPPER + LOWER + DIGITS + SYMBOLS;
       // لازم نملأ باقي الطول
        for (int i = 4; i < length; i++) {
            pwd.add(randomChar(all));
        }
        //بنخلط العناصر
        Collections.shuffle(pwd);
        // بنحوّل List<Character> لسلسلة ونرجعها
        StringBuilder sb = new StringBuilder();
        for (char c : pwd) sb.append(c);
        return sb.toString();
    }
    //دالة مساعدة تختار حرف عشوائي من السلسلة chars باستخدام SecureRandom.nextInt(limit)
    private char randomChar(String chars) {
        return chars.charAt(random.nextInt(chars.length()));
    }
    public void Run(){
        PasswordGenerator generator = new PasswordGenerator();
        String password = generator.generate(12);
        System.out.println("Generated Password: " + password);
    }
}

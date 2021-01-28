package practice.string;

public class ToLowerCase {
    public static void main(String[] args) {
        System.out.println("   aa   bb  cc ".trim());
    }

    public String toLowerCase(String str) {
        char[] chars = str.toCharArray();
        for(int i = 0; i < str.length(); i++) {
            if (chars[i] >= 'A' && chars[i] <= 'Z') chars[i] += 32;
        }

        return new String(chars);

    }
}

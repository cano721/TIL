// 정규식 공부

public class Regex{
    public static void main(String[] args) {
        
        String str = "010-3925-A1a010B1b";
        System.out.println(str);
        String removeStr = str.replaceAll("\\d[a-z]*[A-Z]*", "");
        System.err.println(removeStr);
        System.err.println(str.replaceAll("^0-8", ""));
    }
}
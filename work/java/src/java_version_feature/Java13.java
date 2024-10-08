package java_version_feature;

/**
 * Java 13
 *
 * textBlocks
 *
 * java 13 변경사항 정리 글 https://cano721.tistory.com/234
 */
public class Java13 {
    public static void main(String[] args) {
        textBlock();
    }

    private static void textBlock() {
        String textBlock = """
                first text
                second text
                final text
                """;

        System.out.println(textBlock);
    }
}

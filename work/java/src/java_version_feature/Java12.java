package java_version_feature;

/**
 * Java 12 - Switch Expressions (Preview -> 13에서 반영)
 * yield 처리
 *
 * yield: switch 표현식에서만 사용되며, 특정 case 블록에서 값을 반환하지만 실행 흐름을 종료하지 않고,
 * switch 표현식의 결과로 값을 반환하는 역할을 합니다.
 *
 * 자바 12 버전 특징 정리 글 : https://cano721.tistory.com/233
 * (G1GC 개선, 더욱 빠른 시작 시간 및 메모리 최적화)
 */
public class Java12 {
    public static void main(String[] args) {
        originSwitch();
        Java12Switch();
    }

    private static void originSwitch() {
        int day = 2;
        String dayString = "";

        switch (day){
            case 1:
                dayString = "Monday";
                break;
            case 2:
                dayString = "Tuesday";
                break;
            case 3:
                dayString = "Wednesday";
                break;
            default:
                dayString = "Invalid day";
                break;
        }

        System.out.println(dayString);
    }
    private static void Java12Switch() {
        int day = 2;

        String dayString = switch (day) {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            default -> "Invalid day";
        };

        System.out.println(dayString);
    }

}

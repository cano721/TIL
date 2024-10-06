/**
 * Java 14 변경사항
 *
 * 1. instanceof 패턴 매칭 (Preview)
 * 기존과 다르게 형변환 없이 바로 해당 타입 변수에 할당 가능
 *
 * 2. record 도입 (Preview)
 * 불변 데이터 객체를 쉽게 만들 수 있도록 도입
 * 해당 클래스는 불변이며, 생성자, getter, equals(), hashCode(), toString() 메소드를 자동 생성
 * 보일러플레이트 코드를 많이 줄일듯 VO객체를 만들 때 유용할 듯
 *
 * 3. NPE 에러 메시지 개선
 * NPE 에러 메시지에 null 값이 어떤 변수인지 출력
 *
 * java 14 정리글 : https://cano721.tistory.com/235
 */
public class Java14 {
    public static void main(String[] args) {
        originInstanceof();
        patternMatchingInstanceof();

        testRecord();
    }

    private static void testRecord() {
        // 생성자, getter, equals(), hashCode(), toString() 메소드 자동 생성
        Person person = new Person("kye", 32);
        int age = person.age();
        String name = person.name();

        // Objects.hash()를 이용한 hashCode() 메소드 생성
        int i = person.hashCode();

        // equals는 두 record객체가 같은 클래스인지 확인 후 모든 필드가 동일한지 순차적으로 비교.
        Object newPerson = new Person("kye", 32);
        boolean equals = person.equals(newPerson);
        System.out.println(equals); // true

        Person newPerson2 = new Person("kye", 31);
        boolean equals2 = person.equals(newPerson2);
        System.out.println(equals2); // false

        // toString() 메소드 생성
        System.out.println(person); // Person[name=kye, age=32]
    }

    public record Person(String name, int age) {
    }

    public static class NotRecordPerson {
        private String name;
        private int age;

        public NotRecordPerson(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }

    private static void patternMatchingInstanceof() {
        Object obj = "Hello!";
        if(obj instanceof String str){
            System.out.println(str);
        }
    }

    private static void originInstanceof() {
        Object obj = "Hello!";
        if(obj instanceof String){
            String str = (String) obj;
            System.out.println(str);
        }
    }
}

package java_version_feature;

import java.lang.invoke.MethodHandles;

/**
 * Java 15 Features
 *
 * 1. Sealed Classes
 * 클래스나 인터페이스가 상속될 때 어떤 클래스나 인터페이스가 상속을 받을 수 있는지 명시적으로 제한하는 기능
 * sealed 키워드를 사용하여 클래스나 인터페이스를 선언하고 permits 키워드를 사용하여 허용할 클래스나 인터페이스를 지정
 *
 * 자식
 *
 * 2. Hidden Classes
 * Hidden 클래스는 다른 클래스에 의해 참조되지 않는 클래스로, 클래스 로더에 의해 로드되지 않는 클래스
 * 프레임워크나 스크립트 언어가 동적으로 클래스 생성할때나 클래스 인스턴스화를 제한할때 사용함. (일반적인 개발엔 사용 안할듯)
 * 보안성 강화, 동적 클래스 로딩, GC에 의한 메모리 관리가 장점
 */
public class Java15 {
    public Java15() throws IllegalAccessException {
        byte[] bytes = new byte[0];
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        Class<?> hiddenClass = lookup.defineHiddenClass(bytes, true, MethodHandles.Lookup.ClassOption.NESTMATE).lookupClass();
    }

    public static void main(String[] args) {
    }

    public abstract sealed class Shape permits Circle, Square, Triangle {}

    public final class Circle extends Shape {
        // Circle은 더 이상 상속될 수 없음
    }

    public non-sealed class Square extends Shape {
        // Square는 다른 클래스가 상속할 수 있음
    }

    public final class Triangle extends Shape {
        // Triangle은 더 이상 상속될 수 없음
    }

    // 불가능
//    public class Pentagon extends Shape {
//        // Pentagon은 다른 클래스가 상속할 수 없음
//    }
//
//    // 불가능
//    public class Hexagon extends Circle {
//        // Hexagon은 다른 클래스가 상속할 수 없음
//    }

    // 가능
    public class Rectangle extends Square {
        // Rectangle은 다른 클래스가 상속할 수 없음
    }

}

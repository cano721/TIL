package java_version_feature;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.SequencedCollection;
import java.util.SequencedMap;
import java.util.SequencedSet;

public class Java21_sequenced_collection {
    public static void main(String[] args) {
//        testSequncedCollection();
//        testSequncedMap();
        testSequncedSet();
    }

    private static void testSequncedSet() {
        // LinkedHashSet은 SequencedSet 인터페이스를 구현함
        SequencedSet<String> sequencedSet = new LinkedHashSet<>();

        // Set에 요소 추가
        sequencedSet.add("A");
        sequencedSet.add("B");
        sequencedSet.add("C");
        sequencedSet.addFirst("A-");
        sequencedSet.addLast("D");

        // 첫 번째와 마지막 요소 확인
        System.out.println("첫 번째 요소: " + sequencedSet.getFirst()); // A
        System.out.println("마지막 요소: " + sequencedSet.getLast());   // C

        // 첫 번째와 마지막 요소 제거
        sequencedSet.removeFirst();
        sequencedSet.removeLast();

        // 변경된 Set 출력
        System.out.println("변경된 Set: " + sequencedSet);  // B만 남음

    }

    private static void testSequncedMap() {
        // LinkedHashMap은 SequencedMap 인터페이스를 구현함
        SequencedMap<Integer, String> sequencedMap = new LinkedHashMap<>();

        // 요소 추가 (삽입 순서 유지됨)
        sequencedMap.put(2, "Two");
        sequencedMap.putLast(3, "Three");
        sequencedMap.putFirst(1, "One");

        // 첫 번째와 마지막 요소 확인
        System.out.println("첫 번째 요소: " + sequencedMap.firstEntry()); // 1=One
        System.out.println("마지막 요소: " + sequencedMap.lastEntry());   // 3=Three
        System.out.println("전체 요소: " + sequencedMap);


        // 첫 번째와 마지막 요소 꺼내기
        System.out.println("첫 번째 요소: " + sequencedMap.pollFirstEntry()); // 1=One
        System.out.println("마지막 요소: " + sequencedMap.pollLastEntry());   // 3=Three

        // 변경된 Map 출력
        System.out.println("변경된 Map: " + sequencedMap);
    }

    private static void testSequncedCollection() {
        // LinkedList는 SequencedCollection 인터페이스를 구현함
        SequencedCollection<String> sequencedList = new LinkedList<>();

        // 리스트의 앞과 뒤에 요소를 추가
        sequencedList.addFirst("First Element");
        sequencedList.addLast("Last Element");

        // 첫 번째와 마지막 요소 출력
        System.out.println("첫 번째 요소: " + sequencedList.getFirst());  // First Element
        System.out.println("마지막 요소: " + sequencedList.getLast());    // Last Element

        // 요소 추가
        sequencedList.addFirst("new First Element");
        sequencedList.addLast("New Last Element");

        // 첫 번째와 마지막 요소 확인
        System.out.println("첫 번째 요소: " + sequencedList.getFirst());  // First Element
        System.out.println("마지막 요소: " + sequencedList.getLast());    // New Last Element

        // 리스트의 모든 요소 출력
        System.out.println("전체 요소: " + sequencedList);

        // 첫 번째와 마지막 요소 제거
        sequencedList.removeFirst();
        System.out.println("변경된 요소: " + sequencedList);
        sequencedList.removeLast();
        System.out.println("변경된 요소: " + sequencedList);
    }
}

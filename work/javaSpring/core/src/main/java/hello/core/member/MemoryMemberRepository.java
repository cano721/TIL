package hello.core.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component // memoryMemberRepository
public class MemoryMemberRepository implements MemberRepository{

    // 동시성 이슈가 생길 수 있다. -> 추후엔 컨커런트 해쉬맵? 이란걸 써야함
    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}

package hello.core.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MemoryMemberRepository implements MemberRepository { //테스트용

    private static Map<Long, Member> store = new HashMap<>(); //Map을 사용하는 이유
    //동시성 이슈 : ConcurrentHashMap 사용.
    //static : 모든 인스턴스가 store를 공유.

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}

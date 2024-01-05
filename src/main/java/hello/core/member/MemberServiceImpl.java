package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component//의존관계 주입 설정 필요 -> @Autowired 필요
public class MemberServiceImpl implements MemberService {//Impl: 구현체가 하나만 있을 때 대개 쓰는 용어

    private final MemberRepository memberRepository; //DIP 준수

    @Autowired//타입에 맞는 스프링 빈을 자동으로 주입한다. ac.getBean(MemberRepository.class)
    public MemberServiceImpl(MemberRepository memberRepository) { // 추상화에만 의존. 구체적인건 모름
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }

}

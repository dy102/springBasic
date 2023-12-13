package hello.core.member;

public class MemberServiceImpl implements MemberService {//Impl: 구현체가 하나만 있을 때 대개 쓰는 용어

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    //추상화에도 의존, 구체화에도 의존 -> DIP원칙을 위반함.

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}

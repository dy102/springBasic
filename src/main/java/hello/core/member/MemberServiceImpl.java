package hello.core.member;

public class MemberServiceImpl implements MemberService {//Impl: 구현체가 하나만 있을 때 대개 쓰는 용어

    private final MemberRepository memberRepository; //DIP 준수

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

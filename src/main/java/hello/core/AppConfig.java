package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() { // MemberService 역할이 드러남
        return new MemberServiceImpl(memberRepository()); //저장소 역할이 잘 보이지 않음.
    }

    private MemberRepository memberRepository() {// MemberRepository 역할이 드러남
        return new MemoryMemberRepository(); //다른 저장소가 필요한 경우, 이 코드만 바꾸면 된다.
    }

    public OrderService orderService() {// OrderService 역할이 드러남
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    private DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }
}

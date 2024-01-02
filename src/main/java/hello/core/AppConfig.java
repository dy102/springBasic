package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration//설정 정보
public class AppConfig {

    @Bean//spring container에 등록됨
    public MemberService memberService() { // MemberService 역할이 드러남
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository()); //저장소 역할이 잘 보이지 않음.
    }

    @Bean
    public MemberRepository memberRepository() {// MemberRepository 역할이 드러남
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository(); //다른 저장소가 필요한 경우, 이 코드만 바꾸면 된다.
    }

    @Bean
    public OrderService orderService() {// OrderService 역할이 드러남
        System.out.println("call AppConfig.orderService");
//        return new OrderServiceImpl(memberRepository(), discountPolicy());
        return new OrderServiceImpl();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        /*return new FixDiscountPolicy();*/
        return new RateDiscountPolicy();
    }
}

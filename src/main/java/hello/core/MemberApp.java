package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {//한계가 있는 테스트 방식. junit을 사용하자.
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        //@Bean들을 관리해줌
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        //이름(메서드 이름), 타입
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("member = " + member.getName()); //단축키 : soutv
        System.out.println("findMember = " + findMember.getName());
    }
}

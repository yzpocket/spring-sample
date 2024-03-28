package com.example.demoapp.service;

import com.example.demoapp.domain.Member;
import com.example.demoapp.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest // 스프링 통합테스트(실제 어플리케이션을 작동시킴)
@Transactional // 영속성을 활용하여 테스트 이후 롤백
class MemberServiceIntergrationTest {

    //test라 필드인젝션으로 간단하게 해도 무방
    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    @Test
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("spring");

        //when
        Long saveId = memberService.join(member);

        //then
        Member foundMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(foundMember.getName());
    }

    @Test
    public void 중복회원예외회원가입(){
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //when
        memberService.join(member1);

        //then
        //try {
        //    memberService.join(member2);
        //    fail();
        //} catch(IllegalStateException e){
        //    assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        //    //assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.1");
        //}

        //assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }

    @Test
    void 회원목록조회() {
    }

    @Test
    void 특정회원조회() {
    }
}
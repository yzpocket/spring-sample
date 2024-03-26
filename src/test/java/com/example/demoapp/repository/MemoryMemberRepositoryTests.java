package com.example.demoapp.repository;

import com.example.demoapp.domain.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MemoryMemberRepositoryTests {
    MemberRepository memberRepository = new MemoryMemberRepository();

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        memberRepository.save(member);

        Member result = memberRepository.findById(member.getId()).get();
        //System.out.println("result = " + (result == member));
        //Assertions.assertEquals(member, null);
        assertThat(member).isEqualTo(result);
    }


    @Test
    public void findByName(){
        //given
        Member member1 = new Member();
        member1.setName("spring1");
        memberRepository.save(member1);

        Member member2= new Member();
        member2.setName("spring2");
        memberRepository.save(member2);

        //when
        Member result1 = memberRepository.findByName("spring1").get();
        Member result2 = memberRepository.findByName("spring2").get();
        //then
        assertThat(result2).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        //given
        Member member1 = new Member();
        member1.setName("spring1");
        memberRepository.save(member1);

        Member member2= new Member();
        member2.setName("spring2");
        memberRepository.save(member2);

        List<Member> result = memberRepository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }

}

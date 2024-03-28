//package com.example.demoapp.repository;
//
//import com.example.demoapp.domain.Member;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//public class MemoryMemberRepositoryTests {
//    MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();
//
//
//    @AfterEach
//    public void afterEach(){
//        memoryMemberRepository.clearStore();
//    }
//
//    @Test
//    public void save(){
//        //given
//        Member member = new Member();
//        member.setName("spring");
//
//        memoryMemberRepository.save(member);
//
//        //when
//        Member result = memoryMemberRepository.findById(member.getId()).get();
//
//        //then
//        //System.out.println("result = " + (result == member));
//        //Assertions.assertEquals(member, null);
//        assertThat(member).isEqualTo(result);
//    }
//
//
//    @Test
//    public void findByName(){
//        //given
//        Member member1 = new Member();
//        member1.setName("spring1");
//        memoryMemberRepository.save(member1);
//
//        Member member2= new Member();
//        member2.setName("spring2");
//        memoryMemberRepository.save(member2);
//
//        //when
//        Member result = memoryMemberRepository.findByName("spring1").get();
//
//        //then
//        assertThat(result).isEqualTo(member1);
//    }
//
//    @Test
//    public void findAll(){
//        //given
//        Member member1 = new Member();
//        member1.setName("spring1");
//        memoryMemberRepository.save(member1);
//
//        Member member2= new Member();
//        member2.setName("spring2");
//        memoryMemberRepository.save(member2);
//
//        //when
//        List<Member> result = memoryMemberRepository.findAll();
//
//        //then
//        assertThat(result.size()).isEqualTo(2);
//    }
//
//}

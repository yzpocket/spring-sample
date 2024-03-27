//package com.example.demoapp.config;
//
//import com.example.demoapp.repository.MemberRepository;
//import com.example.demoapp.repository.MemoryMemberRepository;
//import com.example.demoapp.service.MemberService;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class SpringConfig {
//
//    @Bean
//    public MemberService memberService(){
//        return new MemberService(memberRepository());
//    }
//
//    @Bean
//    public MemberRepository memberRepository(){
//        return new MemoryMemberRepository();
//    }
//}

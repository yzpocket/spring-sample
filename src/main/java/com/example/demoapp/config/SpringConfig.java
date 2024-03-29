package com.example.demoapp.config;

import com.example.demoapp.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //@Bean
    //public MemberRepository memberRepository(){
    //    //return new MemoryMemberRepository();
    //    //return new JdbcMemberRepository(dataSource);
    //    //return new JdbcTemplateMemberRepository(dataSource);
    //    //return new JpaMemberRepository(em);
    //}
}

package hello.helloSpring;

import hello.helloSpring.aop.TimeTraceAop;
import hello.helloSpring.repository.JdbcMemberRepository;
import hello.helloSpring.repository.JdbcTemplateMemberRepository;
import hello.helloSpring.repository.JpaMemberRepository;
import hello.helloSpring.repository.MemberRepository;
import hello.helloSpring.service.MemberService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;
@Configuration
public class SpringConfig {
    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

    @Bean
    public TimeTraceAop timeTraceAop(){
        return new TimeTraceAop();
    }
//    @PersistenceContext
//    private EntityManager em;
//
//    @Autowired
//    public SpringConfig(EntityManager em){
//        this.em = em;
//    }
//    private final DataSource dataSource;

//     스프링부트가 bean 만들어서 DI 해줌
//    @Autowired
//    public SpringConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }



//    @Bean
//    public MemberRepository memberRepository() {
//        // return new MemoryMemberRepository();
//        // return new JdbcMemberRepository(dataSource);
//        // return new JdbcTemplateMemberRepository(dataSource);
//        // return new JpaMemberRepository(em);
//    }
}
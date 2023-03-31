package main;

import chapter07.Member;
import chapter07.MemberDao;
import config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainForMemberDao {

    public static MemberDao memberDao;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        memberDao = ctx.getBean("memberDao", MemberDao.class);
//        Member member = memberDao.selectByEmail("a@a.com");
//        System.out.println(member.getId() + ", " + member.getEmail() + ", " + member.getName());

        selectAll();
    }

    public static void selectAll() {
        int count = memberDao.count();
        List<Member> memberList = memberDao.selectAll();

        for(Member m : memberList) {
            System.out.println(m.getId() + ", " + m.getEmail() + ", " + m.getName());
        }

    }
}

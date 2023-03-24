package chapter04;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

public class MemberListPrinter {
    @Autowired
    private MemberDao memberDao;
    @Autowired
    private MemberPrinter memberPrinter;

    public void printAll() {
        Collection<Member> members = memberDao.selectAll();
        members.forEach(m -> memberPrinter.print(m));
    }

}
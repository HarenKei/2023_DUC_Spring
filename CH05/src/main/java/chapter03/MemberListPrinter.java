package chapter03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component("memberListPrinter")
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
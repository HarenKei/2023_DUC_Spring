package chapter03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("memberInfoPrinter")
public class MemberInfoPrinter {

    private MemberDao memberDao;
    private MemberPrinter memberPrinter;

    public void printMemberInfo(String email) {
        Member member = memberDao.selectByEmail(email);
        if(member == null) {
            System.out.println("데이터 없음 \n");
            return;
        }

        memberPrinter.print(member);
    }


    @Autowired
    public void setMemberDao(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    @Autowired
    public void setMemberPrinter(MemberPrinter memberPrinter) {
        this.memberPrinter = memberPrinter;
    }

}
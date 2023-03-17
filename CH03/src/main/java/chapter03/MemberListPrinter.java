package chapter03;

import java.util.Collection;

public class MemberListPrinter {
    private MemberDao memberDao;
    private MemberPrinter memberPrinter;

    //생성자 통한 의존성 추가
    public MemberListPrinter(MemberDao memberDao, MemberPrinter memberPrinter) {
        this.memberDao = memberDao;
        this.memberPrinter = memberPrinter;
    }
    public void printAll() {
        //현재까지 등록된 전체 멤버리스트
        Collection<Member> members = memberDao.selectAll();
        members.forEach(member -> memberPrinter.print(member));
    }
}

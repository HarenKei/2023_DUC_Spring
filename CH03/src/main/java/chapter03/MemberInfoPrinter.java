package chapter03;

public class MemberInfoPrinter {
    //method name : printMemberInfo
    // parameter : email
    // action
    // 1. 이메일로 등록된 멤버인지 검증, 등록되지 않으면 데이터 없다고 출력
    // 2. 멤버가 존재하면 memberPrinter.print(member) 출력

    private MemberDao memberDao;
    private MemberPrinter memberPrinter;

    //public Member selectByEmail(String email) {
    //        return map.get(email);
    //    }
//    public MemberInfoPrinter(MemberDao memberDao, MemberPrinter memberPrinter) {
//        this.memberDao = memberDao;
//        this.memberPrinter = memberPrinter;
//    }
    //생성자를 통한 의존성 주입

    public void setMemberDao(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    public void setMemberPrinter(MemberPrinter memberPrinter) {
        this.memberPrinter = memberPrinter;
    }


    public void printMemberInfo(String email){
        Member member = memberDao.selectByEmail(email);

        if(member != null) {
            memberPrinter.print(member);
        } else {
            System.err.println("등록되지 않은 멤버");
            return;
        }

    }
}

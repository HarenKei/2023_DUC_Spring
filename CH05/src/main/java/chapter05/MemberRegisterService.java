package chapter05;

import chapter03.DuplicationMemberException;
import chapter03.Member;
import chapter03.MemberDao;
import chapter03.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MemberRegisterService {

    @Autowired
    private MemberDao memberDao;

    public MemberRegisterService() {

    }

    public void regist(RegisterRequest req) {
        // 이메일로 회원 데이터 조회
        Member member = memberDao.selectByEmail(req.getEmail());
        if(member != null) {
            // 이미 같은 이메일 가진 회원이 존재
            throw new DuplicationMemberException("Duplication Email : "+ req.getEmail());
        }

        Member newMem = new Member(req.getEmail(), req.getPassword(), req.getName(), LocalDateTime.now());
        memberDao.insert(newMem);
    }
}

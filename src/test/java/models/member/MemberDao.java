package models.member;

import org.mindrot.jbcrypt.BCrypt;

import java.util.HashMap;
import java.util.Map;

public class MemberDao {
    private static Map<String, Member> members = new HashMap<>();

    public void register(Member member){
        String userPw = BCrypt.hashpw(member.getUserPw(), BCrypt.gensalt(12));

        member.setUserPw(userPw);

        members.put(member.getEmail(), member);
    }

    public Member get(String email){
        return members.get(email);
    }



    public boolean exists(String email){

        return members.containsKey(email);
    }

    public static void clearData() { // DB 연동 시 필요 없음
        members.clear();
    }
}

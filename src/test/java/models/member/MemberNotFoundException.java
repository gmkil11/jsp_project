package models.member;

public class MemberNotFoundException extends RuntimeException {
    public MemberNotFoundException(String message){
        super(message);
    }
}

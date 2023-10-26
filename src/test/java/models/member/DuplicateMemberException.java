package models.member;

public class DuplicateMemberException extends RuntimeException{

    public DuplicateMemberException(String message){
        super(message);
    }
}

package commons;

public interface PasswordValidator {

    default void passwordCheck(String hsPassword,String inputPassword, RuntimeException e){

        if(!hsPassword.equals(inputPassword)){
            throw e;
        }

    }
}

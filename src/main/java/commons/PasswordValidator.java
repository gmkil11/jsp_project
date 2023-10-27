package commons;

import org.mindrot.jbcrypt.BCrypt;

public interface PasswordValidator {

    default void passwordCheck(String inputPassword,String hsPassword, RuntimeException e){

        if(!BCrypt.checkpw(inputPassword,hsPassword)){
            throw e;
        }

    }
}

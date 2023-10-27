package commons;

import java.util.function.Predicate;

public interface EmailValidator  {
    // 이메일 형식을 검사하고 형식이 잘못된 경우 RuntimeException을 던진다
    default void emailCheck(String email, RuntimeException e) {
        if (email == null || !email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            throw e;
        }
    }
}


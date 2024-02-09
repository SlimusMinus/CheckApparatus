package y_lab.krylov.login_to_app;

import junit.framework.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class AuthorizationImplementsTest {

    AuthorizationImplements authorization;
    @BeforeEach
    void setUser(){
        authorization = new AuthorizationImplements();
    }
    @Test
    @DisplayName("check enter in database")
    void isAuthorization() {
        authorization.setLogin("admin");
        authorization.setPassword("admin");
        assertThat(authorization.IsAuthorization()).isTrue();
    }

    @Test
    @DisplayName("check login")
    void checkLogin() {
        authorization.setLogin("wrong login");
        authorization.setPassword("admin");
        assertThat(authorization.IsAuthorization()).isFalse();
    }

    @Test
    @DisplayName("check password")
    void checkPassword() {
        authorization.setLogin("admin");
        authorization.setPassword("wrong password");
        assertThat(authorization.IsAuthorization()).isFalse();
    }

}
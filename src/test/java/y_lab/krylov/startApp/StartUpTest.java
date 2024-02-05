package y_lab.krylov.startApp;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


class StartUpTest {
    @BeforeAll
    static void setUp(){
       StartUp.choice = 1;
    }

    @Test
    @DisplayName("checking input value")
    void getChoice() {
        assertThat(StartUp.choice).isEqualTo(1);
    }
}
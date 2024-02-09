package y_lab.krylov.users;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.assertj.db.type.*;
import static org.assertj.db.api.Assertions.assertThat;


class GetAllUsersImplementsTest {

    Table table;
    Source source;

    @BeforeEach
    void setUp(){
        source = new Source("jdbc:postgresql://localhost:777/postgres", "username", "password");
        table =  new Table(source, "users");

    }
    @Test
    @DisplayName("check all users in db")
    void getAllUsers() {

        assertThat(table).column("login").value().isEqualTo("admin")
                .value().isEqualTo("Tom")
                .value().isEqualTo("Kris")
                .value().isEqualTo("Jack")
                .value().isEqualTo("KrisPain");
    }

}
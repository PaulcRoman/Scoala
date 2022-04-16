package ro.school.View;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ViewUserTest {
    ViewUser viewUser;

    @BeforeEach
    public void initial(){
        viewUser = new ViewUser();
    }

    @Test
    public void test6(){
        viewUser.cursuriInscris();
    }

}
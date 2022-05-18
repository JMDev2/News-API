package models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {

    @Test
    public void getName_instantiatesWithName_String() {

        User user = new User("kimani","IT",2,"IT");

        assertEquals("kimani", user.getName());
    }

    @Test
    public void getName_instantiatesWithRole_String() {
        User user = new User("kimani","IT",2,"IT");

        assertEquals("IT", user.getRole());

    }

    @Test
    public void getName_instantiatesWithDepartment_Integer() {
        User user = new User("kimani","IT",2,"IT");

        assertEquals(2, user.getDepartmentId());

    }
    @Test
    public void getName_instantiatesWithPosition_String() {

        User user = new User("kimani","IT",2,"IT");

        assertEquals("IT", user.getPosition());
    }
}

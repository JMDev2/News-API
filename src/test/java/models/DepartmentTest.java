package models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DepartmentTest {
    @Test
    public void getName_instantiatesWithTitle_String() {

        Department department = new Department("james", "cool", 1);

        assertEquals("james", department.getName());
    }

    @Test
    public void getName_instantiatesWithLocation_String() {
        Department department = new Department("hr", "cool", 1);

        assertEquals("cool", department.getDescription());

    }

    @Test
    public void getName_instantiatesWithEmployees_Integer() {
        Department department = new Department("hr", "cool", 0);

        assertEquals(0, department.getEmployees());

    }


}

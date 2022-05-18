package models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DepartmentNewsTest {
    @Test
    public void getName_instantiatesWithTitle_String() {

        DepartmentNews departmentNews = new DepartmentNews("hr", "cool", 1);

        assertEquals("hr", departmentNews.getTitle());
    }

    @Test
    public void getName_instantiatesWithLocation_String() {
        DepartmentNews departmentNews = new DepartmentNews("hr", "cool", 1);

        assertEquals("hr", departmentNews.getTitle());

    }

    @Test
    public void getName_instantiatesWithContent_String() {
        DepartmentNews departmentNews = new DepartmentNews("hr", "cool", 1);

        assertEquals("cool", departmentNews.getContent());

    }


}
package models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class generalNewsTest {

    @Test
    public void getName_instantiatesWithId_Integer() {

        GeneralNews generalNews = new GeneralNews(1,"IT","cool",2);

        assertEquals(1, generalNews.getDid());
    }

    @Test
    public void getName_instantiatesWithTitle_String() {
        GeneralNews generalNews = new GeneralNews(1,"IT","cool",2);

        assertEquals("IT", generalNews.getTitle());

    }

    @Test
    public void getName_instantiatesWithContent_String() {
        GeneralNews generalNews = new GeneralNews(1,"IT","cool",2);

        assertEquals("cool", generalNews.getContent());

    }
    @Test
    public void getName_instantiatesWithDepId_Integer() {

        GeneralNews generalNews = new GeneralNews(1,"IT","cool",2);

        assertEquals(2, generalNews.getDepartmentid());
    }
}

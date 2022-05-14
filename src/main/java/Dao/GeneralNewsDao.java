package Dao;

import models.GeneralNews;

import java.util.List;

public interface GeneralNewsDao {
    //Create
    void addNews(GeneralNews generalNews);

    //Read
    List<GeneralNews> getAllNews();
    GeneralNews getGeneralNewsById(int id);

    //Update

    //Delete
    void deleteGeneralNews(int id);
}


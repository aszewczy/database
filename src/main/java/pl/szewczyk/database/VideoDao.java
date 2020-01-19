package pl.szewczyk.database;


import java.util.List;

//CRUD
public interface VideoDao {

    void saveVideo(long id, String title, String url);
    List<Video> findAll();
    void udateVideo(Video newVideo);
    void deleteVideo(long id);

    //dodatkowa

    Video getVideo(long id);



}

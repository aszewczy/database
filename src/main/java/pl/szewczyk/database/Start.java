package pl.szewczyk.database;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Start {


    private VideoDao videoDao;


    public Start(VideoDao videoDao) {
        this.videoDao = videoDao;
     ///   videoDao.saveVideo(3L,"trzeci", "trzeci.pl");
      //  videoDao.saveVideo(4L,"czwarty", "czwarty.pl");
      //  videoDao.udateVideo(new Video(4L,"lalala", "newUrl.pl"));
      //  videoDao.deleteVideo(2);
        System.out.println(videoDao.getVideo(1));
      //  videoDao.findAll().forEach(System.out::println);

    }
}




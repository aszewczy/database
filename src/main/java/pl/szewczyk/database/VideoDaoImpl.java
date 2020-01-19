package pl.szewczyk.database;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class VideoDaoImpl implements  VideoDao{

    private JdbcTemplate jdbcTemplate;


    public VideoDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void saveVideo(long id, String title, String url) {
        Video video = new Video(id,title,url);
        String sql = "INSERT INTO videos VALUES(?,?,?)";
        jdbcTemplate.update(sql, video.getVideoId(), video.getTitle(), video.getUrl());
    }

    @Override
    public List<Video> findAll() {
        List <Video> videoList = new ArrayList<>();
        String sql = "SELECT * FROM  videos";
        List<Map<String,Object>> maps = jdbcTemplate.queryForList(sql);
        maps.stream().forEach(element -> videoList.add(new Video(
                Long.parseLong(String.valueOf(element.get("video_id"))),
                String.valueOf(element.get("title")),
                String.valueOf(element.get("url"))
        )));
        return videoList;
    }

    @Override
    public void udateVideo(Video newVideo) {
        String sql = "UPDATE  videos SET videos.title=?, videos.url=? WHERE videos.video_id=?";
        jdbcTemplate.update(sql,  newVideo.getTitle(), newVideo.getUrl(), newVideo.getVideoId());
    }

    @Override
    public void deleteVideo(long id) {
        String sql = "DELETE FROM  videos WHERE videos.video_id=?";
        jdbcTemplate.update(sql, id);
    }

    //findAll tez można z rowMApper, on ma jeszcze moetody któ©e umożliwiają dokonanie walidacji pól

//    @Override
//    public Video getVideo(long id) {
//        String sql = "SELECT * FROM  videos WHERE videos.video_id=?";
//        return jdbcTemplate.queryForObject(sql, new RowMapper<Video>() {
//            @Override
//            public Video mapRow(ResultSet resultSet, int i) throws SQLException {
//                return new Video(resultSet.getLong(1), resultSet.getString(2), resultSet.getString(3));
//            }
//        }, id);

    // TO samo tylko lambda// cyfy można zmienić na zazwy tabel

    @Override
    public Video getVideo(long id) {
        String sql = "SELECT * FROM  videos WHERE videos.video_id=?";
         return jdbcTemplate.queryForObject(sql, (resultSet, i) -> new Video(resultSet.getLong("video_id"), resultSet.getString("title"), resultSet.getString("url")), id);
    }


}

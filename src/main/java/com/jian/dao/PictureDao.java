package com.jian.dao;

import com.jian.entity.Picture;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PictureDao {

    List<Picture> getPictures();

    Picture getPictureById(Long id);

    int savePicture(Picture picture);

    int updatePicture(Picture picture);

    int delPictureById(Long id);

}

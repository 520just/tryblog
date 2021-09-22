package com.jian.service;

import com.jian.entity.Picture;

import java.util.List;

public interface PictureService {

    List<Picture> getPictures();

    Picture getPictureById(Long id);

    int savePicture(Picture picture);

    int updatePicture(Picture picture);

    int delPictureById(Long id);

}

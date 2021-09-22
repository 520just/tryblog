package com.jian.service.impl;

import com.jian.dao.PictureDao;
import com.jian.entity.Picture;
import com.jian.service.PictureService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: myblog
 * @description:
 * @author: 520just
 * @create: 2021-08-21 16:58
 **/
@Service
public class PictureServiceImpl implements PictureService {

    private final
    PictureDao pictureDao;

    public PictureServiceImpl(PictureDao pictureDao) {
        this.pictureDao = pictureDao;
    }

    @Override
    public List<Picture> getPictures() {
        return pictureDao.getPictures();
    }

    @Override
    public Picture getPictureById(Long id) {
        return pictureDao.getPictureById(id);
    }

    @Override
    public int savePicture(Picture picture) {
        return pictureDao.savePicture(picture);
    }

    @Override
    public int updatePicture(Picture picture) {
        return pictureDao.updatePicture(picture);
    }

    @Override
    public int delPictureById(Long id) {
        return pictureDao.delPictureById(id);
    }

}

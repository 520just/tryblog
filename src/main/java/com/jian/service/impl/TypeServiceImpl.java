package com.jian.service.impl;

import com.jian.dao.TypeDao;
import com.jian.entity.Type;
import com.jian.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

    private final
    TypeDao typeDao;

    public TypeServiceImpl(TypeDao typeDao) {
        this.typeDao = typeDao;
    }

    @Override
    public List<Type> getTypes() {
        return typeDao.getTypes();
    }

    @Override
    public List<Type> getAllTypes() {
        return typeDao.getAllTypes();
    }

    @Override
    public int delType(Long id) {
        return typeDao.delType(id);
    }

    @Override
    public Type getTypeById(Long id) {
        return typeDao.getTypeById(id);
    }

    @Override
    public Type getTypeByName(String name) {
        return typeDao.getTypeByName(name);
    }

    @Override
    public int saveType(Type type) {
        return typeDao.saveType(type);
    }

    @Override
    public int updateType(Type type) {
        return typeDao.updateType(type);
    }
}

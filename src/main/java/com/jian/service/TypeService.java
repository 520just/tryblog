package com.jian.service;

import com.jian.entity.Type;

import java.util.List;

public interface TypeService {

    List<Type> getTypes();

    List<Type> getAllTypes();

    int delType(Long id);

    Type getTypeById(Long id);

    Type getTypeByName(String name);

    int saveType(Type type);

    int updateType(Type type);

}

package com.jian.dao;

import com.jian.entity.Type;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TypeDao {

    List<Type> getTypes();

    List<Type> getAllTypes();

    int delType(Long id);

    Type getTypeById(Long id);

    Type getTypeByName(String name);

    int saveType(Type type);

    int updateType(Type type);

}

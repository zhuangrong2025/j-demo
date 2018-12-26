package com.jxust.dao;

import com.jxust.entity.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
/**
 * Created by user on 2018/12/13.
 */
public interface PersonRepository extends JpaRepository<Person,Integer> {


    /**
     * 根据年龄查询
     * @param age
     * @return
     */
    public List<Person> findByAge(Integer age);


}


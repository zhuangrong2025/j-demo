package com.jxust.dao;

import com.jxust.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by user on 2018/12/13.
 */
public interface PersonRepository extends JpaRepository<Person,Integer> {
}


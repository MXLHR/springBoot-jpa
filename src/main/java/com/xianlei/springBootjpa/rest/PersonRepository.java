package com.xianlei.springBootjpa.rest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

/**
 * Created by sang on 2017/1/4.
 */
//Spring Data Rest 默认是实体类之后加s 来形成路径 。  需要修改默认的要使用如下注解
//@RepositoryRestResource(path = "people") //默认为Person , 这里定义访问路径
public interface PersonRepository extends JpaRepository<Person,Long> {
    @RestResource(path = "nameStartsWith",rel = "nameStartsWith")
    List<Person> findByNameStartsWith(@Param("name") String name);
}

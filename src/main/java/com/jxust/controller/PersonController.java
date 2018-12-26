
package com.jxust.controller;

import com.jxust.dao.PersonRepository;
import com.jxust.entity.Person;
import com.jxust.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * Created by zr
 * Time: 2018/12/21 18:05
 */
@RestController
public class PersonController {
    @Autowired
    PersonRepository personRepository;

    @Autowired
    private PersonService personService;
    /**
     * 查询所有人员列表
     *
     * @return
     */
    @GetMapping(value = "/person")
    private List<Person> personList() {
        return personRepository.findAll();
    }

    /**
     * 添加一个用户
     * @param name
     * @param age
     * @return
     */
    @PostMapping(value = "/person", consumes="application/json")
    @ResponseBody
    public Person personAdd(@RequestBody Person pp){
        return personRepository.save(pp);
    }

    /**
     * 删除一个人员
     */
    @DeleteMapping(value = "/person/{id}")
    public void personDelete(@PathVariable("id") Integer id) {
        personRepository.deleteById(id);
    }

    /**
     * 更新一个用户
     * @param name
     * @param age
     * @return
     */
    @PutMapping(value = "/person/{id}", consumes="application/json")
    @ResponseBody
    public Person personUpdate(@RequestBody Person pp2){
        return personRepository.save(pp2);
    }

    /**
     * 查询一个人员
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/person/{id}")
    public Person personFindOne(@PathVariable("id") Integer id) {
        return personRepository.findById(id).orElse(null);
    }

    /**
     * 通过年龄来查询
     * @param age
     * @return
     */
    @GetMapping(value = "/person/age/{age}")
    public List<Person> personListByAge(@PathVariable("age") Integer age) {
        return personRepository.findByAge(age);
    }

    /**
     * 分页
     */

    @GetMapping(value = "/persons/{page}")
    public Page<Person>  personPage(@PathVariable("page") Integer page) {

        System.out.println("当前get的参数：" + page);
        // size为每页显示几条，page为0表示为第一页
        Integer size = 3;
        Pageable pageable = PageRequest.of(page,size);
        Page<Person>  pages = personRepository.findAll(pageable);

        System.out.println("查询的总页数：" + pages.getTotalPages());
        System.out.println("查询的总记录数：" + pages.getTotalElements());
        System.out.println("查询的当前第几页：" + (pages.getNumber() + 1));
        System.out.println("查询的当前页面记录数：" + pages.getNumberOfElements());
        System.out.println("查询的当前页面的集合：" + pages.getContent());
        return pages;
    }
}















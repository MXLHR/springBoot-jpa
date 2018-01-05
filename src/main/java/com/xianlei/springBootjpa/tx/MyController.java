package com.xianlei.springBootjpa.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xianlei.springBootjpa.rest.Person;

/**
 * Created by sang on 2017/1/5.
 */
@RestController
public class MyController {
    @Autowired
    private DemoService demoService;
    
    @RequestMapping(value="/norollback",produces="application/json;charset=UTF-8")
    public Person noRollback(Person person) {
        return demoService.savePersonWithoutRollBack(person);
    }

    @RequestMapping(value="/rollback",produces="application/json;charset=UTF-8")
    public Person rollback(Person person) {
        return demoService.savePersonWithRollBack(person);
    }
}

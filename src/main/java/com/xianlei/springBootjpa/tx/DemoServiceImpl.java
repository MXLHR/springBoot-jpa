package com.xianlei.springBootjpa.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xianlei.springBootjpa.rest.Person;
import com.xianlei.springBootjpa.rest.PersonRepository;

/**
 * Created by sang on 2017/1/5.
 */
@Service
public class DemoServiceImpl implements DemoService {
    @Autowired
    PersonRepository personRepository;

    @Transactional(rollbackFor = {IllegalArgumentException.class})
    @Override
    public Person savePersonWithRollBack(Person person) {
        Person p = personRepository.save(person);
        if (person.getName().equals("xianlei")) {
            throw new IllegalArgumentException("xianlei 已存在，数据将回滚");
        }
        return p;
    }

    @Transactional(noRollbackFor = {IllegalArgumentException.class})
    @Override
    public Person savePersonWithoutRollBack(Person person) {
        Person p = personRepository.save(person);
        if (person.getName().equals("xianlei")) {
            throw new IllegalArgumentException("xianlei已存在，但数据不会回滚");
        }
        return p;
    }
}

package com.lin.controller;

import com.lin.pojo.People;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/people")
public class PeopleController {


    @RequestMapping("/getpeople")
    public People getPeople(Long id, String name) {
        People people = new People();
        people.setIn(id);
        people.setName("痢疾");
        people.setAddress("南京");
        return people;
    }
}

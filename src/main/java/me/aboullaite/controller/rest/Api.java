package me.aboullaite.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import me.aboullaite.model.Employee;
import me.aboullaite.service.EmployeeService;

/**
 * Created by aboullaite on 2017-02-23.
 */

@RestController
public class Api {

    @Autowired
    EmployeeService userService;

    /**
     * Handle request to the default page
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Employee> viewHome() {
        return (List<Employee>) userService.findAll();
    }


}

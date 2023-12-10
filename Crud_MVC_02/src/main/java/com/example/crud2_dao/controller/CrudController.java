package com.example.crud2_dao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.crud2_dao.dao.CrudDao;
import com.example.crud2_dao.domain.Crud;

@Controller
public class CrudController {
    
    @Autowired
    private CrudDao dao;

    @PostMapping("Employees")
    public String doEmployees(Crud crud, Model model){
        Crud crudDb = dao.getEmployee(crud.getEmail());
        if (crudDb == null) {
            dao.insertEmployee(crud);
        } else {
            dao.updateEmployee(crud);
        }

        
        return getCrud(model);
    }
    
    @RequestMapping("Employees")
    public String getCrud(Model model){
        model.addAttribute("employee",new Crud());
        model.addAttribute("employees", dao.getEmployee());
        return "CrudLista";
    }

    @RequestMapping("deleteEmployee")
    public String delete(@RequestParam(value = "email", required = true) String email, Model model) {
        dao.deleteEmployee(email);
        return getCrud(model);
    }

    @RequestMapping("editEmployee")
    public String editEmployee(@RequestParam(value = "email", required = true) String email, Model model) {
        Crud crud = dao.getEmployee(email);
        model.addAttribute("employee", crud);
        model.addAttribute("employees", dao.getEmployee());
        return "CrudLista";
    }

    @RequestMapping("employeesSearch")
    public String getEmployees(@RequestParam(value = "name", required = true) String name, Model model) {
        model.addAttribute("employees",dao.getEmployees(name));
        model.addAttribute("employee",new Crud());
        return "CrudLista";
    }


}

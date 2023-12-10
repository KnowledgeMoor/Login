package com.example.crud2_dao.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.crud2_dao.domain.Role;
import com.example.crud2_dao.dto.MenuItem;

import org.springframework.ui.Model;

@Controller
public class MenuController {

    Logger logger = LoggerFactory.getLogger(MenuController.class);

    @RequestMapping("menus")
    public String getMenus(Model model, List<Role> roles) {

        MenuItem crud = new MenuItem("/Employees", "Crud");
        MenuItem OnlyAdmins = new MenuItem("/admin/onlyadmins", "OnlyAdmins");
        Set<MenuItem> itens = new HashSet<>();
        for (Role role : roles) {
            if (role.getNome().equals("ADMIN")) {
                itens.add(crud);
                itens.add(OnlyAdmins);
            } else if (role.getNome().equals("USER")) {
                itens.add(crud);
            }
        }

        model.addAttribute("menuItems", itens);
        return "menu";

    }

}
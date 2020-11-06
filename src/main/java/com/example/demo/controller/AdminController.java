package com.example.demo.controller;


import com.dangdang.ddframe.rdb.sharding.id.generator.IdGenerator;
import com.example.demo.entity.Admin;
import com.example.demo.service.AdminService;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.page.PageMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author gzfyit
 * @since 2020-11-06
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private IdGenerator idGenerator;

    @PostMapping(value = "save")
    public String saveAdmin(long id,int age) {
//        long id =idGenerator.generateId().longValue();
//        System.out.println(id);
        Admin admin = new Admin();
        admin.setName("123")
                .setAdminId(id)
                .setAge(age);
        adminService.save(admin);
        return "成功";
    }

    @PostMapping(value = "get")
    public PageInfo<Admin> getAdmin() {
        PageMethod.startPage(1, 10);
        List<Admin> list = adminService.list(null);
        PageInfo<Admin> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }



}

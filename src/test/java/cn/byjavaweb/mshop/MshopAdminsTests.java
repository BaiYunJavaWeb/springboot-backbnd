package cn.byjavaweb.mshop;

import cn.byjavaweb.mshop.entity.Admins;
import cn.byjavaweb.mshop.mapper.AdminsMapper;
import cn.byjavaweb.mshop.service.AdminService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MshopAdminsTests {
    @Autowired
    private AdminsMapper adminsMapper;
    @Autowired
    private AdminService adminService;

    @Test
    void testSelectById(){
        Admins admins = adminsMapper.selectById(1);
        System.out.println(admins.getUsername());
    }

    @Test
    void getByUserName(){
        Admins admins = adminService.getByUserName("1");
        System.out.println(admins);
    }

    @Test
    void checkAdmin(){
        Admins admins = new Admins();
        admins.setUsername("1");
        admins.setPassword("1iUOoOdMAl7FsB1Kig37hmg==");
        Boolean bool = adminService.checkAdmin(admins);
        System.out.println(bool);
    }

    @Test
    void getList(){
        List<Admins> adminsList = adminService.getList(1,1);
        System.out.println(adminsList);
    }

    @Test
    void getTotal(){
        long count = adminService.getTotal();
        System.out.println(count);
    }

    @Test
    void get(){
        Admins admins = adminService.get(1);
        System.out.println(admins);
    }

    @Test
    void add(){
        Admins admins = new Admins();
        admins.setUsername("2");
        admins.setPassword("123456");
        int affectRows = adminService.add(admins);
        System.out.println(affectRows);
    }

    @Test
    void update(){
        Admins admins = new Admins();
        admins.setId(1);
        admins.setUsername("3");
        admins.setPassword("123456");
        boolean bool = adminService.update(admins);
        System.out.println(bool);
    }

    @Test
    void delete(){
        Admins admins = new Admins();
        admins.setId(-545161215);
        boolean bool = adminService.delete(admins);
        System.out.println(bool);
    }
}

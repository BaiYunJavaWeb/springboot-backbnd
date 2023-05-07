package cn.byjavaweb.mshop.service;

import cn.byjavaweb.mshop.entity.Users;
import cn.byjavaweb.mshop.mapper.UsersMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UsersMapper usersMapper;

    public UserService(UsersMapper usersMapper) {
        this.usersMapper = usersMapper;
    }

    public boolean add(Users users) {
        return usersMapper.insert(users) > 0;
    }

    public Users checkUser(Users users) {
        return usersMapper.findByUsername(users.getUsername());
    }

    public List<Users> all() {
        return usersMapper.getAll();
    }

    public boolean delete(int id) {
        return usersMapper.deleteById(id) > 0;
    }

    public boolean update(Users users) {
        return usersMapper.updateById(users) > 0;
    }

    public boolean resetPsw(Users users) {
        users.setPassword("HAMVRZRssPCADKqGjGWJtQ==");
        return usersMapper.updateById(users) > 0;
    }

    public Users findUserByName(String name) {
        return usersMapper.findByUsername(name);
    }

    public Users findUserById(Users users) {
        return usersMapper.selectById(users.getId());
    }
}

package cn.byjavaweb.mshop.service;

import cn.byjavaweb.mshop.entity.Users;
import cn.byjavaweb.mshop.mapper.UsersMapper;
import cn.byjavaweb.mshop.utils.SafeUtil;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UsersMapper usersMapper;

    public UserService(UsersMapper usersMapper){
        this.usersMapper = usersMapper;
    }

    public boolean add(Users users){
        users.setPassword(SafeUtil.encode(users.getPassword()));
        return usersMapper.insert(users)>0;
    }

    public Users checkUser(Users users){
        return usersMapper.findByUsername(users.getUsername());
    }
}

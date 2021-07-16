package com.company.northwind.business.concretes;

import com.company.northwind.business.abstracts.UserService;
import com.company.northwind.core.dataAccess.UserDao;
import com.company.northwind.core.entities.User;
import com.company.northwind.core.utilities.results.DataResult;
import com.company.northwind.core.utilities.results.Result;
import com.company.northwind.core.utilities.results.SuccessDataResult;
import com.company.northwind.core.utilities.results.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManager implements UserService {
    private UserDao userDao;

    @Autowired
    public UserManager(UserDao userDao) {
        super();
        this.userDao = userDao;
    }

    @Override
    public Result add(User user) {
        this.userDao.save(user);
        return new SuccessResult("User added.");
    }

    @Override
    public DataResult<User> findByEmail(String email) {
        return new SuccessDataResult<User>(this.userDao.findByEmail(email),
                "User found");
    }
}

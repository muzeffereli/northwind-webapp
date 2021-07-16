package com.company.northwind.business.abstracts;

import com.company.northwind.core.entities.User;
import com.company.northwind.core.utilities.results.DataResult;
import com.company.northwind.core.utilities.results.Result;

public interface UserService {
    Result add(User user);
    DataResult<User> findByEmail(String email);
}

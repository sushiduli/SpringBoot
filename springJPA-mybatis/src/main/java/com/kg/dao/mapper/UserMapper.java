/**   
 * Copyright © 2019  All rights reserved.
 * 
 * @Package: com.kg.dao.mapper
 * @author: xp023396
 * @CreateDate: Jan 9, 2019 10:37:07 AM
 */

package com.kg.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kg.entity.User;

/** 
 * @ClassName: UserMapper 
 * @Description: TODO
 * @author: xp023396
 * @date: Jan 9, 2019 10:37:07 AM  
 */
@Mapper
public interface UserMapper {

    public List<User> getList();
}

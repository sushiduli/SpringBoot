/**   
 * Copyright © 2019  All rights reserved.
 * 
 * @Package: com.kg.dao.jpa
 * @author: xp023396
 * @CreateDate: Jan 9, 2019 10:37:41 AM
 */

package com.kg.dao.jpa;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.kg.entity.User;

/** 
 * @ClassName: UserJPA 
 * @Description: TODO
 * @author: xp023396
 * @date: Jan 9, 2019 10:37:41 AM  
 */
public interface UserJPA extends Serializable, JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

}

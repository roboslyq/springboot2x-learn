package com.jpa.repository.primary;

import com.jpa.domain.primary.UserPrimary;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author luo.yongqian
 */
public interface UserPrimaryRepository extends JpaRepository<UserPrimary,Integer>{
}

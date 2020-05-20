package com.jpa.repository.secondary;

import com.jpa.domain.primary.UserPrimary;
import com.jpa.domain.secondary.UserSecondary;
import org.aspectj.weaver.ast.Test;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author luo.yongqian
 */
public interface UserSecondaryProperty extends JpaRepository<UserSecondary,Integer>{
}

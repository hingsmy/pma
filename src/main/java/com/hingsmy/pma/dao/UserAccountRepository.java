package com.hingsmy.pma.dao;

import com.hingsmy.pma.entities.UserAccount;
import org.springframework.data.repository.CrudRepository;

public interface UserAccountRepository extends CrudRepository<UserAccount, Long> {
}

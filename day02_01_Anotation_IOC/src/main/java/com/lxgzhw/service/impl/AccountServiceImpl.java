package com.lxgzhw.service.impl;

        import com.lxgzhw.dao.impl.AccountDaoImpl;
        import com.lxgzhw.service.IAccountService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

@Service("accountService")
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private AccountDaoImpl accountDao=null;

    public void saveAccount() {
        accountDao.saveAccount();
    }
}

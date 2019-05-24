package edu.nju.vivofinal.dao;

import edu.nju.vivofinal.model.Account;

import java.util.ArrayList;

public interface AccountInfoDao {

    ArrayList<Account> showUserAccount(String userId);

    boolean saveUserAccount(Account account);

    boolean updateUserAccount(Account account);
}

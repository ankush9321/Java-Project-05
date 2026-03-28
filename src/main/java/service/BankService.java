package service;

import entity.Account;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import util.JPAUtil;

public class BankService {

    public void createAccount(int accNo, String name, int pin) {
        EntityManager em = JPAUtil.getEMF().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(new Account(accNo, name, pin));
        tx.commit();
        em.close();
        System.out.println("Account created!");
    }

    public void deposit(int accNo, double amount ,int pin) {
        EntityManager em = JPAUtil.getEMF().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Account acc = em.find(Account.class, accNo);
        if (acc != null && pin==acc.getPin()) {
            acc.setBalance(acc.getBalance() + amount);
            System.out.println("Deposit successful!");
        } else {
            System.out.println("Pin is wrong or Account not found!");
        }
        tx.commit();
        em.close();
    }
    
    public boolean check(int accNo) {
    	EntityManager em = JPAUtil.getEMF().createEntityManager();
        Account acc = em.find(Account.class, accNo);
        if (acc == null) {
            System.out.println("Account not found!");
            return true;
        }
		return false;
    	
    }
    public void withdraw(int accNo, double amount, int pin) {
        EntityManager em = JPAUtil.getEMF().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Account acc = em.find(Account.class, accNo);
        if (acc != null && pin==acc.getPin()) {
        	if( acc.getBalance() >= amount) {
            acc.setBalance(acc.getBalance() - amount);
            System.out.println("Withdraw successful!");
        	}
        	else {
        		System.out.println("Insufficient balance!");
        	}
        } else {
            System.out.println("Pin is wrong or Account not found!");
        }
        tx.commit();
        em.close();
    }

    public void checkBalance(int accNo,int pin) {
        EntityManager em = JPAUtil.getEMF().createEntityManager();
        Account acc = em.find(Account.class, accNo);
        if (acc != null && pin==acc.getPin()) {
            System.out.println("Balance: ₹" + acc.getBalance());
        } else {
            System.out.println("Pin is wrong or Account not found!");
        }
        em.close();
    }
}
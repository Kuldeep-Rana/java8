package com.codersdesks.samples;

public class TrxThreadLocal {

    private static TrxThreadLocal local = new TrxThreadLocal();

    private ThreadLocal<User> userLocalObj = new ThreadLocal<>();

    public static TrxThreadLocal getLocal(){
        return local;
    }

    public void setUserLocalObj(User user){
        userLocalObj.set(user);
    }

    public  User getUserLocalObj(){
        return userLocalObj.get();
    }
}

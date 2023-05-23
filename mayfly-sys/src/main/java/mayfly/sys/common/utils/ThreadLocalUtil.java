package mayfly.sys.common.utils;

import mayfly.sys.module.sys.entity.AccountDO;

public class ThreadLocalUtil {
    private ThreadLocalUtil() {}
    private static ThreadLocal<AccountDO> loginUser = new ThreadLocal<>();

    public static void putUser(AccountDO user) {
        loginUser.set(user);
    }

    public static AccountDO getUser() {
        return loginUser.get();
    }

    public static void removeUser() {
        loginUser.remove();
    }
}

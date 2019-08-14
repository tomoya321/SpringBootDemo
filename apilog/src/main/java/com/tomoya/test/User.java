/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: User
 * Author:   Administrator
 * Date:     2019/8/14 19:35
 * Description: user
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.tomoya.test;

/**
 * 〈一句话功能简述〉<br> 
 * 〈user〉
 *
 * @author Administrator
 * @create 2019/8/14
 * @since 1.0.0
 */
public class User {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
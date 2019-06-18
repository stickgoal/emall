package me.maiz.ds.emall.info;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserInfo implements Serializable {

    private int userId;

    private String username;

    private String email;

    private int age;

    private Date birthday;

}

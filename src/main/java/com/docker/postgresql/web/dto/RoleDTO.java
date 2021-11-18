package com.docker.postgresql.web.dto;

import java.io.Serializable;

public class RoleDTO implements Serializable {

    private static final long serialVersionUID = 5431043843358094348L;

    private String code;
    private String name;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

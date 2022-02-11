package com.devsuperior.dscatalog.dto;

import com.devsuperior.dscatalog.entities.Role;

import java.io.Serializable;

public class RoleDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long Id;
    private String authority;

    public RoleDTO() {
    }

    public RoleDTO(Long id, String authority) {
        Id = id;
        this.authority = authority;
    }

    public RoleDTO(Role role) {
        Id = role.getId();
        this.authority = role.getAuthority();
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}

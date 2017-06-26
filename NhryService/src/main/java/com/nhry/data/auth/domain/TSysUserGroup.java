package com.nhry.data.auth.domain;

import java.io.Serializable;

public class TSysUserGroup implements Serializable{
    private String id;

    private String groupName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }
}
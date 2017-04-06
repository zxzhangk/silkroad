
package com.silk.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "tbl_user")
public class User
{
    
    @Id
    @NotNull
    @Column(name = "phone")
    private long phone;
    
    @Column(name = "code")
    private int code;
    
    @NotNull
    @Column(name = "last_modify_timestamp")
    private long lastModifyTimestamp;
    
    @Column(name = "name")
    private String name;
    
    public User()
    {
        
    }
    
    public User(long phone, int code)
    {
        super();
        this.lastModifyTimestamp = System.currentTimeMillis();
        this.phone = phone;
        this.code = code;
    }
    
    
    public long getPhone()
    {
        return phone;
    }


    public void setPhone(long phone)
    {
        this.phone = phone;
    }


    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }

    public int getCode()
    {
        return code;
    }

    public void setCode(int code)
    {
        this.lastModifyTimestamp = System.currentTimeMillis();
        this.code = code;
    }

    public long getLastModifyTimestamp()
    {
        return lastModifyTimestamp;
    }

    public void setLastModifyTimestamp(long lastModifyTimestamp)
    {
        this.lastModifyTimestamp = lastModifyTimestamp;
    }
    
}

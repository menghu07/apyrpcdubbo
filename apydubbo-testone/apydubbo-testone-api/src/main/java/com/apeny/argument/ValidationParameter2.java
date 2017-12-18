package com.apeny.argument;

import com.apeny.api.service.argumentvalidation.Validation1Service;
import com.apeny.api.service.argumentvalidation.Validation2Service;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by apeny on 2017/12/17.
 */
public class ValidationParameter2 implements Serializable {

    private static final long serialVersionUID = 192L;

    @NotNull
    @Size.List({@Size(min = 1), @Size(max = 20)})
    private String name;

    //只有Save会验证
    @NotNull(groups = Validation2Service.Save.class)
    @Pattern(regexp = "^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[\\w]+(?:[-.][\\w]+)*\\.[a-zA-Z]+\\s*$")
    private String email;

    @Min(18)
    @Max(100)
    private int age;

    @Past
    private Date loginDate;

    @Future
    private Date expiryDate;

    @Size(min = 1, max = 10, groups = Validation2Service.Update.class)
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ValidationParameter2{");
        sb.append("name='").append(name).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", age=").append(age);
        sb.append(", loginDate=").append(loginDate);
        sb.append(", expiryDate=").append(expiryDate);
        sb.append(", address='").append(address).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

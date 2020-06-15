package org.launchcode.spaday.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {

    @NotBlank(message="Must enter username, dummy.")
    @Size(min=5, max=15, message="username must be a range of 5 to 15 chars")
    private String username;

    @Email
    private String email;

    @NotBlank(message="you are going to want one of these")
    @Size(min=6, message = "and it needs to be six chars. more than five.")
    private String password;

    @NotNull(message="Passwords don't match")
    @NotBlank(message = "Same as the password.")
    private String verify;

    public User(){

    }

    public User(String username, String email, String password, String verify) {
        this();
        this.username = username;
        this.email = email;
        this.password = password;
        this.verify = verify;
    }

    private void checkPassword(String pass, String pass2){
        if(!pass.equals(pass2)){
            if(pass !=null && pass2 !=null){
                verify=null;
            }
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        this.checkPassword(this.getPassword(),this.getVerify());
    }

    public String getVerify() {
        return verify;
    }

    public void setVerify(String verify) {
        this.verify = verify;
        this.checkPassword(this.getPassword(),this.getVerify());
    }
}


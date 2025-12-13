package com.financias.demo.model;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Entity
@Table(name = "users")
public class User {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; 

    private String username;

    private String password;

    public User() {}

    public User(String username, String password) {
        this.username = username;
        this.password = password;   
    }

    public String getUsername() {
        return username;
    }
    
    
    public String getPassword() {
        return password;
    }
    
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

     public boolean isAccountNonExpired() {return true;}
     public boolean isAccountNonLocked() {return true;}
     public boolean isCredentialsNonExpired() {return true;}
     public boolean isEnabled() {return true;}

    public void setusername(String username) {this.username = username;}
    public void setpassword(String password) {this.password = password;}
}

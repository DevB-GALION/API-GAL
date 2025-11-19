package com.dim.entity.user;
import com.dim.entity.role.Role;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "app_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    public String name;
    public String email;
    public String password;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public List<Role> role;
}

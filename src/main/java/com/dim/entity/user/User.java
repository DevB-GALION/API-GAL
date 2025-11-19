package com.dim.entity.user;
import com.dim.entity.role.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "app_user")
@Setter
@Getter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    public String name;
    public String email;
    public String password;
    @ManyToMany(fetch = FetchType.EAGER)
    public List<Role> role;
}

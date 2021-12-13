package com.github.throyer.carallocator.models.user;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;
//import org.springframework.security.core.GrantedAuthority;

@Data
@Entity
@NoArgsConstructor
public class Role /*implements GrantedAuthority*/ {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String name;

    @JsonIgnore
    private String deletedName;

    private String initials;

    @JsonIgnore
    private String deletedInitials;

    private String description;

//    @Override
//    public String getAuthority() {
//        return getInitials();
//    }
}

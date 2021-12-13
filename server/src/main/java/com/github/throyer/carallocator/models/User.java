package com.github.throyer.carallocator.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import static com.fasterxml.jackson.annotation.JsonProperty.Access.WRITE_ONLY;
import java.io.Serializable;
import java.util.List;
import static javax.persistence.CascadeType.DETACH;
import javax.persistence.Entity;
import static javax.persistence.FetchType.LAZY;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String docuemnt;

    private String driversLicense;

    @JsonIgnore
    private String deletedEmail;

    @JsonProperty(access = WRITE_ONLY)
    private String password;

    @ManyToMany(cascade = DETACH, fetch = LAZY)
    @JoinTable(name = "user_role",
        joinColumns = {
            @JoinColumn(name = "user_id")},
        inverseJoinColumns = {
            @JoinColumn(name = "role_id")})
    private List<Role> roles;
}

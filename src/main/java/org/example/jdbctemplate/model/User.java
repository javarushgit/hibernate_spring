package org.example.jdbctemplate.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class User {
    @Id
    private Long id;
    private String name;
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Address> addresses;

}

package org.example.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@ToString
@AllArgsConstructor
@Getter @Setter
@NoArgsConstructor
public class AddressDTO {
    @Column(name = "city")
    private String city;
    @Column(name = "country")
    private String country;
}

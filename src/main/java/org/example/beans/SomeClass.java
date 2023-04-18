package org.example.beans;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class SomeClass implements BeanI {
    private String name;

    @Override
    public String toString() {
        return "SomeClass{" +
                "name='" + name + '\'' +
                '}';
    }
}

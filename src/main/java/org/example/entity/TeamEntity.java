package org.example.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@ToString
@Table(name = "team")
@Setter @Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TeamEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private BigDecimal bank;
  @OneToMany(mappedBy = "team", fetch =  FetchType.LAZY )
  private List<PlayerEntity> players;
}

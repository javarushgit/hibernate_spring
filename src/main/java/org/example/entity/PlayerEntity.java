package org.example.entity;

import jakarta.persistence.*;

import java.time.Instant;
import java.time.LocalDate;

import lombok.*;
import org.example.dto.AddressDTO;
import org.example.dto.PlayerType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


@Table(name = "player")
@Getter @Setter

@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"team"})
public class PlayerEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(columnDefinition = "VARCHAR(50) NOT NULL")
  private String name;

  @Column(columnDefinition = "VARCHAR(20)")
  private String surname;

  @Column(name = "price")
  private int price;
  @Column(name = "bonus")

  private int bonus;


  @CreationTimestamp
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "create_date")
  private Instant createDate;
  @UpdateTimestamp
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "modify_date")
  private Instant modifyDate;

  @Embedded
  private AddressDTO addressDTO;
  @Enumerated(value = EnumType.STRING)
  @Column(name = "player_type", columnDefinition = "VARCHAR(13)")
  private PlayerType playerType;

  @Transient
  private String someText;
  private boolean isMainSquad;
  private LocalDate age;

  @Column(columnDefinition = "text")
  private String biography;

  @Column(name = "carrier_start")
  private LocalDate carrierStart;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "team_id")
  private TeamEntity team;


}

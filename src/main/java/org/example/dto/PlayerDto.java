package org.example.dto;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.example.entity.TeamEntity;
import org.springframework.stereotype.Component;

@Builder
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PlayerDto implements Serializable {

  private String name;
  private String surname;
  private LocalDate age;

  private LocalDate carrierStart;
  private PlayerType playerType;


  private String teamName;
}

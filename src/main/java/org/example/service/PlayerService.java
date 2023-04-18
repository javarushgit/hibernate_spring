package org.example.service;

import java.util.List;
import org.example.dto.PlayerDto;

public interface PlayerService {
  Long savePlayer();
  Long savePlayer(PlayerDto playerDto);
  void updatePlayer(PlayerDto playerDto);
  PlayerDto getById(Long id);
  List<PlayerDto> getAllPlayers();
  void deletePlayer(Long id);
}

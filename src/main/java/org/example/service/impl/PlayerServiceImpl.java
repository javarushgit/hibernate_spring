package org.example.service.impl;

import java.util.List;
import java.util.Optional;

import org.example.dao.PlayerDao;
import org.example.dto.PlayerDto;
import org.example.entity.PlayerEntity;
import org.example.entity.TeamEntity;
import org.example.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class PlayerServiceImpl implements PlayerService {

  private PlayerDao playerDao;


  //private TeamDao teamDao = new TeamDao();

  @Autowired
  public PlayerServiceImpl(PlayerDao playerDao) {
    this.playerDao = playerDao;
  }

  @Override
  @Transactional
  public Long savePlayer(PlayerDto playerDto) {
    return playerDao.save(null);
  }

  public Long savePlayer() {

    System.out.println("savePlayer");
    //  return playerDao.save(null);
    return 0L;
  }

  @Override
  public void updatePlayer(PlayerDto playerDto) {

  }

  @Override
  public PlayerDto getById(Long id) {


    return null;











//    Optional<PlayerEntity> playerEntity = playerDao.findById(id);
//    if(playerEntity.isPresent()) {
//      PlayerEntity playerEntity1 = playerEntity.get();
//      TeamEntity team = playerEntity1.getTeam();
//      System.out.println("--------");
//      System.out.println(team.getName());
//    }
//    return null;
  }

  @Override
  public List<PlayerDto> getAllPlayers() {
    return null;
  }

  @Override
  public void deletePlayer(Long id) {
  }

//  private PlayerEntity dtoToEntity(PlayerDto playerDto) {
//    PlayerEntity playerEntity = PlayerEntity.builder()
//        .name(playerDto.getName())
//        .surname(playerDto.getSurname())
//        .age(playerDto.getAge())
//        .carrierStart(playerDto.getCarrierStart())
//        .build();
//    if(playerDto.getTeamName() != null) {
//      Optional<TeamEntity> teamEntity = teamDao.findByName(playerDto.getTeamName());
//      teamEntity.ifPresent(playerEntity::setTeam);
//    }
//    return playerEntity;
//  }

//  private PlayerDto entityToDto(PlayerEntity playerEntity) {
////    PlayerDto playerDto = PlayerDto.builder()
////        .price(playerEntity.getPrice())
////        .build();
//  }
}

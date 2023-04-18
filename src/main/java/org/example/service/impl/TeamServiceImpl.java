package org.example.service.impl;

import jakarta.transaction.Transactional;
import org.example.dao.PlayerDao;
import org.example.dao.TeamDao;
import org.example.dto.PlayerDto;
import org.example.dto.TeamDto;
import org.example.entity.TeamEntity;
import org.example.service.PlayerService;
import org.example.service.TeamService;
import org.example.entity.PlayerEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



@Service
public class TeamServiceImpl implements TeamService {


    private TeamDao teamRepo = new TeamDao();

    @Override
    public Long create(TeamDto teamDto) {
        return teamRepo.save(teamDtoToEntity(teamDto));
    }

    @Override
    public TeamDto getById(Long id) {
//       // Auther
//
//        // code
//
//        ///
//        System.out.println("Getting team with id: " + id);
//        Optional<TeamEntity> team = teamRepo.findById(id);
//        System.out.println("we got team: " + team);
//        return team.map(this::entityToDto).orElse(null);
        System.out.println("Team service get by id");
        return null;
    }

    private TeamDto entityToDto(TeamEntity teamEntity) {
        TeamDto teamDto = TeamDto.builder()
                .name(teamEntity.getName())
                .bank(teamEntity.getBank())
                .build();

        return teamDto;
    }

    private List<PlayerDto> playerEntityListToDto(List<PlayerEntity> playerEntities) {
        List<PlayerDto> playerDtos = new ArrayList<>();
        for (PlayerEntity playerEntity :
                playerEntities) {
            PlayerDto playerDto = PlayerDto.builder()
                    .name(playerEntity.getName())
                    .surname(playerEntity.getSurname())
                    .carrierStart(playerEntity.getCarrierStart())
                    .age(playerEntity.getAge())
                    .teamName(playerEntity.getTeam().getName())
                    .build();
            playerDtos.add(playerDto);
        }
        return playerDtos;
    }

    private List<TeamDto> teamEntityListToDto(List<TeamEntity> teamEntities) {
        List<TeamDto> teamDtos = new ArrayList<>();
        for (TeamEntity teamEntity :
                teamEntities) {
            TeamDto teamDto = TeamDto.builder()
                    .name(teamEntity.getName())
                    .bank(teamEntity.getBank())
                    .players(playerEntityListToDto(teamEntity.getPlayers()))
                    .build();
            teamDtos.add(teamDto);
        }
        return teamDtos;
    }

    private TeamEntity teamDtoToEntity(TeamDto teamDto) {
        return TeamEntity.builder()
                .name(teamDto.getName())
                .bank(teamDto.getBank())
                .build();
    }

    @Override
    public List<TeamDto> getAll() {
        return teamEntityListToDto(teamRepo.findAll());
    }
}

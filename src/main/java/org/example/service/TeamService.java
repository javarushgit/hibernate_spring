package org.example.service;

import org.example.dto.TeamDto;

import java.util.List;

public interface TeamService {
    TeamDto getById(Long id);
    List<TeamDto> getAll();
    Long create(TeamDto teamDto);
}

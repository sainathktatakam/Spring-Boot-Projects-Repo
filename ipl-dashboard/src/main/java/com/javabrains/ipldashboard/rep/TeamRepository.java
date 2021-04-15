package com.javabrains.ipldashboard.rep;

import com.javabrains.ipldashboard.model.Team;

import org.springframework.data.repository.CrudRepository;

public interface TeamRepository  extends CrudRepository<Team,Long>{

    
    public Team findByTeamName(String teamName);
}

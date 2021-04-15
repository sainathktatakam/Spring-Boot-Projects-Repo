package com.javabrains.ipldashboard.controller;

import java.util.List;

import com.javabrains.ipldashboard.model.Match;
import com.javabrains.ipldashboard.model.Team;
import com.javabrains.ipldashboard.rep.MatchRepository;
import com.javabrains.ipldashboard.rep.TeamRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeamController {
    @Autowired
    private TeamRepository teamRepository  ;
    private MatchRepository matchRepository  ;

    TeamController( TeamRepository repository , MatchRepository matchRepository){
        this.teamRepository = repository;
        this.matchRepository = matchRepository;
    }

    @GetMapping("/Team/{teamName}")
    public Team getTeams(@PathVariable String teamName){
        
          Team team =  this.teamRepository.findByTeamName(teamName);
            Pageable pageable = PageRequest.of(0, 3);
        List<Match> matchList = this.matchRepository.getByTeam1OrTeam2OrderByDateDesc(
                                                        teamName,
                                                        teamName,
                                                        pageable);

        team.setMatches(matchList);
        return team;
    }

}


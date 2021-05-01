package com.javabrains.ipldashboard.controller;

import java.time.LocalDate;
import java.util.List;

import com.javabrains.ipldashboard.model.Match;
import com.javabrains.ipldashboard.model.Team;
import com.javabrains.ipldashboard.rep.MatchRepository;
import com.javabrains.ipldashboard.rep.TeamRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class TeamController {
    @Autowired
    private TeamRepository teamRepository;
    private MatchRepository matchRepository;

    TeamController(TeamRepository repository, MatchRepository matchRepository) {
        this.teamRepository = repository;
        this.matchRepository = matchRepository;
    }

    @GetMapping("/Team")
    public Iterable<Team> getAllTeams(){
        return this.teamRepository.findAll();
    }
    
    @GetMapping("/Team/{teamName}")
    public Team getTeams(@PathVariable String teamName) {

        Team team = this.teamRepository.findByTeamName(teamName);

        List<Match> matchList = this.matchRepository.findLatestMatchesByTeam(teamName, 4);

        team.setMatches(matchList);
        return team;
    }

    @GetMapping("/Team/{teamName}/matches")
    public List<Match> getMatches(@PathVariable String teamName , @RequestParam int year){
       LocalDate startDate = LocalDate.of(year,1,1);
       LocalDate endDate = LocalDate.of(year+1, 1  , 1);
        return this.matchRepository.getMatchesByTeamBetweenDates(teamName, startDate, endDate);
        
    }

}

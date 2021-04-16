package com.javabrains.ipldashboard.controller;

import java.util.List;

import com.javabrains.ipldashboard.model.Match;
import com.javabrains.ipldashboard.rep.MatchRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin
public class MatchController {

    @Autowired
    private MatchRepository matchRepository ;

    MatchController(MatchRepository matchRepository){
        this.matchRepository = matchRepository;
    }

    @GetMapping("/Match/{teamName}")
    public List<Match> getMatches(@PathVariable String teamName){
        Pageable pageable = PageRequest.of(0, 3);
        return this.matchRepository.getByTeam1OrderByDateDesc(teamName,pageable);
    }
    
}

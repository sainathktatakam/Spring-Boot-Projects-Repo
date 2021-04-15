package com.javabrains.ipldashboard.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;


@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String teamName;
    private Long totalMatches;
    private Long totalWins;

    @Transient
    private List<Match> matches;


    Team(){

    }

    public Team(String teamName , Long totalMatches){
            this.teamName = teamName;
            this.totalMatches = totalMatches;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTeamName() {
        return teamName;
    }
    public void setTeamName(String TeamName) {
        this.teamName = TeamName;
    }
    public Long getTotalMatches() {
        return totalMatches;
    }
    public void setTotalMatches(Long totalMatches) {
        this.totalMatches = totalMatches;
    }
    public Long getTotalWins() {
        return totalWins;
    }
    public void setTotalWins(Long totalWins) {
        this.totalWins = totalWins;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }

     public List<Match> getMatches() {
        return matches;
    }

    @Override
    public String toString() {
        
        return "[ Team:"+teamName.toString()+"  Total_Matches:"+totalMatches.toString()+"  Total_Wins:"+totalWins.toString() +" ]";
    }
    
}

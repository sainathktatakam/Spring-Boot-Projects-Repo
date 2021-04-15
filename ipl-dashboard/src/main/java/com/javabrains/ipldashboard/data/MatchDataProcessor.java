package com.javabrains.ipldashboard.data;

import java.time.LocalDate;

import com.javabrains.ipldashboard.model.Match;

import org.springframework.batch.item.ItemProcessor;

public class MatchDataProcessor implements ItemProcessor<MatchInput, Match> {

  @Override
  public Match process(final MatchInput matchinput) throws Exception {
    
    Match match = new Match();
    
    match.setId(Long.parseLong(matchinput.getId()));
    match.setCity(matchinput.getCity());
    match.setDate(LocalDate.parse(matchinput.getDate()));
    match.setPlayerOfMatch(matchinput.getPlayer_of_match());

    match.setVenue(matchinput.getVenue());

    String firstInningsTeam ;
    String secondInningsTeam;
    if("bat".equalsIgnoreCase(matchinput.getToss_decision())){
         firstInningsTeam = matchinput.getToss_winner();
         secondInningsTeam = matchinput.getToss_winner().equalsIgnoreCase(matchinput.getTeam1())? matchinput.getTeam2():matchinput.getTeam1();
    }else{
         secondInningsTeam = matchinput.getToss_winner();
         firstInningsTeam = matchinput.getToss_winner().equalsIgnoreCase(matchinput.getTeam1())? matchinput.getTeam2():matchinput.getTeam1();
    }

    match.setTeam1(firstInningsTeam);
    match.setTeam2(secondInningsTeam);
    match.setTossWinner(matchinput.getToss_winner());
    match.setTossDecision(matchinput.getToss_decision());
    match.setMatchWinner(matchinput.getWinner());
    match.setResult(matchinput.getResult());
    match.setResultMargin(matchinput.getResult_margin());
    match.setUmpire1(matchinput.getUmpire1());
    match.setUmpire2(matchinput.getUmpire2());

        return match;
  }

}
    


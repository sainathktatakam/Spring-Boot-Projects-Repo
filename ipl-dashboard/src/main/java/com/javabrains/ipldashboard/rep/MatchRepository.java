package com.javabrains.ipldashboard.rep;



import java.util.List;

import com.javabrains.ipldashboard.model.Match;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface MatchRepository  extends CrudRepository<Match,Long>{
    
    public List<Match> getByTeam1(String teamName );

    public List<Match> getByTeam1OrTeam2OrderByDateDesc(
                                        String teamName, 
                                        String teamName2,
                                       Pageable pageable);

    public List<Match> getByTeam1OrderByDateDesc(String teamName, Pageable pageable);

  

}

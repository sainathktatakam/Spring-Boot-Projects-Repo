package com.javabrains.ipldashboard.rep;



import java.time.LocalDate;
import java.util.List;

import com.javabrains.ipldashboard.model.Match;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface MatchRepository  extends CrudRepository<Match,Long>{
    
    public List<Match> getByTeam1(String teamName );

    public List<Match> getByTeam1OrTeam2OrderByDateDesc(
                                        String teamName, 
                                        String teamName2,
                                       Pageable pageable);

     
    default List<Match> findLatestMatchesByTeam(String teamName,int count){
        return  getByTeam1OrTeam2OrderByDateDesc( teamName,teamName, PageRequest.of(0,count));

    }

    @Query("SELECT m FROM Match m WHERE (m.team1 = :teamName OR m.team2 =:teamName) AND m.date between :startDate and :endDate ORDER BY m.date DESC")
    public List<Match> getMatchesByTeamBetweenDates(
                    @Param("teamName")String teamName ,
                    @Param("startDate")LocalDate startDate ,
                    @Param("endDate") LocalDate endDate
                    );

    
   
  

}

import { React ,useEffect, useState} from 'react';
import {useParams} from 'react-router-dom';
import { MatchDetailsCard } from '../components/MatchDetailsCard';
import "./MatchPage.scss" ;
import { YearSelector } from './YearSelector';

export const MatchPage = () => {

    const [matches , setMatches] = useState([]);
    const {teamName , year } = useParams();
    

    useEffect(
            ()=>{
                const fetchMatches = async ()=>{
                    const response = await fetch(`http://localhost:8080/Team/${teamName}/matches?year=${year}`);
                    const data = await response.json();
                  //  console.log(data);
                    setMatches(data);
                };
                fetchMatches()

            },[teamName,year]

    )
  
    return (
        <div className="MatchPage">
          <div className='year-selection'>
            <h3>Select Year</h3>  
            < YearSelector teamName={teamName}/>
            </div>
            <div>
            <div> <h3 className='match-page-heading'> {teamName} matches in {year} </h3> </div>
             { matches.map( match => <MatchDetailsCard matche={match} teamName ={teamName} /> ) }
            
               
            </div>
        </div>
    );

}
import { React ,useEffect, useState} from 'react';
import {useParams} from 'react-router-dom';


import { MatchDetailsCard } from '../components/MatchDetailsCard';

export const MatchPage = () => {

    const [matches , setMatches] = useState([]);
    const {teamName , year } = useParams();
    

    useEffect(
            ()=>{
                const fetchMatches = async ()=>{
                    const response = await fetch(`http://localhost:8080/Team/${teamName}/matches?year=${year}`);
                    const data = await response.json();
                    console.log(data);
                    setMatches(data);
                }
                fetchMatches();

            }

    )
    return (
        <div className="MatchPage">
            <h1> Match Page</h1>
            <h2> {teamName}</h2>
               { matches.map( match => <MatchDetailsCard matche={match} teamName ={teamName} /> ) }
            
        </div>
    );

}
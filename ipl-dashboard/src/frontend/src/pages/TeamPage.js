import { React, useEffect, useState } from 'react';
import {useParams} from 'react-router-dom';
import { MatchDetailsCard } from '../components/MatchDetailsCard';
import { MatchSmallCard } from '../components/MatchSmallCard';

export const TeamPage = () => {

    const [team, setTeam] = useState({ matches: [] });
    const {teamName } = useParams();
    useEffect(

        () => {

            const fetchMatches = async () => {
                const response = await fetch(`http://localhost:8080/Team/${teamName}`);
                const data = await response.json();
                console.log(data);
                setTeam(data);
            };

            fetchMatches();
        }, [teamName]

    );

    if(!team || !team.teamName){
            return <h2> Team Not found..</h2>
    }
    return (
        <div className="TeamPage">
            <h1>{team.teamName}</h1>
            <MatchDetailsCard teamName = {team.teamName} matche={team.matches[0]} />

            {team.matches.
                slice(1)
                .map(match => <MatchSmallCard  teamName = {team.teamName} match={match} />)}

        </div>
    );
}

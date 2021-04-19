import { React } from 'react';
import { Link } from 'react-router-dom';

export const MatchDetailsCard = ({ teamName ,matche }) => {
    if (!matche) return null;

    const otherTeam = teamName === matche.team1 ? matche.team2:matche.team1;
    const otherTeamRoute = `/Team/${otherTeam}`;

    return (
        <div className="MatchDetailCard">
            <h3>Latest Match Details</h3>
            <h1> Vs <Link to={otherTeamRoute}>{otherTeam} </Link> </h1>
            <h2>{matche.date}</h2>
            <h3>at {matche.venue}</h3>
            <h3>{matche.matchWinner} won by {matche.resultMargin} {matche.result}</h3>
        </div>
    );
}

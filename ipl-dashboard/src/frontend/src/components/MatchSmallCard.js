import { React } from 'react';
import {Link } from 'react-router-dom';


export const MatchSmallCard = ({ teamName ,match }) => {

    const otherTeam = teamName === match.team1 ? match.team2:match.team1;
    const otherTeamRoute = `/Team/${otherTeam}`;
    const isMatchwon = (match.matchWinner === teamName)?true:false;
    return (
        <div className={isMatchwon ? 'MatchSmallCard won-card':'MatchSmallCard lose-card'}>
        <span className='vs'>vs</span>
         <h2> <Link to = {otherTeamRoute}> {otherTeam} </Link> </h2> 
            <p className='match-result'> {match.matchWinner} won by {match.resultMargin} {match.result}</p>
        </div>
    );
}

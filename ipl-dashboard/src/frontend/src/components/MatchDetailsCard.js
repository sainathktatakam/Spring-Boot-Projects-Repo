import { React } from 'react';
import { Link } from 'react-router-dom';
import "./MatchDetailsCard.scss";

export const MatchDetailsCard = ({ teamName, matche }) => {
    if (!matche) return null;

    const otherTeam = teamName === matche.team1 ? matche.team2 : matche.team1;
    const otherTeamRoute = `/Team/${otherTeam}`;
    const isMatchwon = (matche.matchWinner === teamName)?true:false;
    return (
        <div className={isMatchwon? 'MatchDetailCard won-card':'MatchDetailCard lose-card'}>
            <div>
                <span className='vs'>Vs</span>
                <h1> <Link to={otherTeamRoute}>{otherTeam} </Link> </h1>
                <h2 className='match-date'>{matche.date}</h2>
                <h3 className='match-venue'>at {matche.venue}</h3>
                <h3 className='match-result'>{matche.matchWinner} won by {matche.resultMargin} {matche.result}</h3>
            </div>
            <div className='additional-details'>
                <h3>First Innings</h3>
                <p> {matche.team1}</p>
                <h3>Second Innings</h3>
                <p> {matche.team2}</p>
                <h3>Man of the Match</h3>
                <p> {matche.playerOfMatch}</p>
                <h3>Umpires</h3>
                <p> {matche.umpire1},{matche.umpire2}</p>
            </div>
        </div>

    );
}

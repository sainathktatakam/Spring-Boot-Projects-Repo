import { React, useEffect, useState } from 'react';
import { useParams , Link } from 'react-router-dom';
import { MatchDetailsCard } from '../components/MatchDetailsCard';
import { MatchSmallCard } from '../components/MatchSmallCard';
import { PieChart } from 'react-minimal-pie-chart';
import './TeamPage.scss';

export const TeamPage = () => {

    const [team, setTeam] = useState({ matches: [] });
    const { teamName } = useParams();
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

    if (!team || !team.teamName) {
        return <h2> Team Not found..</h2>
    }
    return (
        <div className="TeamPage">
            <div className='team-name-section'>
                <div className='team-name'> <h1>{team.teamName}</h1> </div>
            </div>
            <div className='win-lose-section'>
                Wins/Losses
                <PieChart
                    data={[
                        
                        { title: 'Losses', value: team.totalMatches, color: '#a34d5d' },
                        { title: 'Wins', value: team.totalWins, color:'#4da375' }
                        
                    ]}
                />
           </div>
            <div className='match-details-section'>
                <h3>Latest Match Details</h3>
                <MatchDetailsCard teamName={team.teamName} matche={team.matches[0]} />
            </div>

            {team.matches.slice(1).map(match => <MatchSmallCard teamName={team.teamName} match={match} />)}
            <div className='more'>
              <Link to ={ `/Team/${team.teamName}/matches/${process.env.REACT_APP_DATA_END_YEAR}` } >More </Link>
            </div>
        </div>
    );
}

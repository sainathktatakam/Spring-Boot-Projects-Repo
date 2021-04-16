import { React } from 'react';

export const MatchDetailsCard = ({ matches }) => {
    if (!matches) return null;

    return (
        <div className="MatchDetailCard">
            <h3>Latest Match Details</h3>
            <h4>Match Details</h4>
            <h4>{matches.team1} VS {matches.team2}</h4>
        </div>
    );
}

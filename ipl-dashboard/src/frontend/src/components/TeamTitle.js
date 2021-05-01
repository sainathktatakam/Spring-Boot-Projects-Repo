import {React} from 'react';
import {Link} from 'react-router-dom';
import "./TeamTitle.scss";


export const TeamTitle = ({teamName})=>{

    const TeamRout = `/Team/${teamName}`;

    return (
            <div className='Team-Title'>
                <h2><Link to={TeamRout}>{teamName} </Link></h2> 
            </div>
    )
}
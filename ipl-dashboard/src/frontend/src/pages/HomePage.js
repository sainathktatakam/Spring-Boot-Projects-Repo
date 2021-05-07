import {React , useState,useEffect} from 'react';   
import {TeamTitle} from '../components/TeamTitle';
import "./HomePage.scss";






export const  HomePage = ()=>{

        const [teams,setData] = useState([]);
      
    useEffect(
        () =>{
            
              const  fetchAllTeams = async()=>{
                    let  response= await fetch('http://localhost:8080/Team');
                    let data = await response.json();
                    setData(data);
    
                };    
                fetchAllTeams();
            
        },[]

    );
       
    return (
            <div className='HomePage'>
                <div className='Header-section'>
                    <h1 className='app-name'>IPL Dashboard</h1>
                </div>
                <div className='team-grid'>
                    {teams.map( (team) =><TeamTitle key={team.id} teamName={team.teamName}/>)}
                </div>

            </div>
    )

}
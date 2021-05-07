import { React} from 'react';
import {Link} from 'react-router-dom';
import "./YearSelector.scss"

export const YearSelector = ({teamName}) => {
        let years= [];
        const startYear =  process.env.REACT_APP_DATA_START_YEAR;
        const endYear =  process.env.REACT_APP_DATA_END_YEAR;

         for(let i=startYear;i<=endYear;i++){
             years.push(i);
             
         }

        return (
         <ol className='year-list'>
             <h2>{years.map( year =>(
                    <li key ={year} >
                         <Link to= {`/Team/${teamName}/matches/${year}`}> {year}</Link> 
                    </li>
                     )
                 )}
             </h2>             
        </ol>     
        )
          
}
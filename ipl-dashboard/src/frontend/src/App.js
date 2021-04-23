import './App.scss';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import { MatchDetailCard } from './components/MatchDetailsCard';
import { MatchSmallCard } from './components/MatchSmallCard';
import { TeamPage } from './pages/TeamPage';
import { MatchPage } from './pages/MatchPage';

function App() {
  return (
    <div className="App">
      <Router>
        <Switch>
          <Route path='/Team/:teamName/matches/:year'>
            <MatchPage />
          </Route>
          <Route path='/Team/:teamName'>
            <TeamPage />
          </Route>
        </Switch>
      </Router>

    </div>
  );
}

export default App;

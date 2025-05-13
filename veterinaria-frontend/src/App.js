import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';

import Animals from './pages/animals';
import Navbar from './components/navigationBar';
import AnimalForm from './pages/createAnimal';
import TransactionForm from './pages/transactionForm';
import StatisticsPage from './pages/statistics';

function App() {

  return (
    <Router>
      <Navbar />
      <Routes>
        <Route path="/animals" element={<Animals />}  />
        <Route path="/create-animal" element={<AnimalForm />} />
        <Route path="/create-transaction" element={<TransactionForm />} />
        <Route path="/stats" element={<StatisticsPage />} />
      </Routes>
    </Router>
  );
}

export default App;
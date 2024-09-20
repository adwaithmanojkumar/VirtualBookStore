import { Route, Routes } from 'react-router-dom';
import './App.css';
import RoutersComponent from './Components/Routers/RoutersComponent';

function App() {
  return (
    <Routes>
      <Route path='/*' element={<RoutersComponent/>}/>
    </Routes>
  );
}

export default App;

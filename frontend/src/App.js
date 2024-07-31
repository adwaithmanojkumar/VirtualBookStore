import AddBook from './components/Book/AddBook';
import BookList from './components/Book/BookList';
import Home from './components/Home';
import Login from './components/Login';
import Logout from './components/Logout';
import MyCart from './components/MyCart';
import Navbar from './components/Navbar';
import {Routes,Route} from 'react-router-dom';

function App() {
  return (
    <>
    <Navbar/>
    <div className="container">
      <Routes>
        <Route path="/" element={<Login/>}/>
        <Route path="/login" element={<Login/>}/>
        <Route path="/welcome:username" element={<Home/>}/>
        {/* <Route path="/book-list" element={<BookList/>}/>
        <Route path="/add-book" element={<AddBook/>}/>
        <Route path="/cart-list" element={<MyCart/>}/>
        <Route path="/logout" element={<Logout/>}/> */}
      </Routes>
    </div>
    </>
  );
}

export default App;

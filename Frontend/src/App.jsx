import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import {BrowserRouter as Router, Route, Routes} from 'react-router-dom'
import BarraSuperior from './components/barraSuperior'
import Inicio from './components/inicio'
import Simulation from './components/simulation'
import RegisterClient from './components/registerClient'
import Login from './components/login'

function App() {
  return (
    <Router>
      <div className="contaninner">
        <BarraSuperior> </BarraSuperior>
          <Routes>
            <Route path= "/" element= {<Inicio/>} />
            <Route path= "/simulacion" element= {<Simulation/>} />            
            <Route path= "/registerCLient" element= {<RegisterClient/>} />
            <Route path= "/login" element= {<Login/>} />
          </Routes>


      </div>
    </Router>
  )
}

export default App

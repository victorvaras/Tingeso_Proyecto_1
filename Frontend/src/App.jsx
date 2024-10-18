import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import {BrowserRouter as Router, Route, Routes} from 'react-router-dom'
import BarraSuperior from './components/barraSuperior'
import Inicio from './components/inicio'
import Simulation from './components/simulation'


function App() {
  return (
    <Router>
      <div className="contaninner">
        <BarraSuperior> </BarraSuperior>
          <Routes>
            <Route path= "/inicio" element= {<Inicio/>} />
            <Route path= "/simulacion" element= {<Simulation/>} />
          </Routes>


      </div>
    </Router>
  )
}

export default App

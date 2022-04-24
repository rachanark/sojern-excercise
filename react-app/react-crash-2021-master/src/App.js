import { useState, useEffect, useLayoutEffect } from 'react'
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom'
import Dogs from './components/Dogs'
import Favorites from './components/Favorites'

const App = () => {
  const [dogs, setDogs] = useState()
  const [favs, setFavs] = useState([])

  useEffect(() => {
    async function fetchMyAPI() {
      let response = await fetch('https://random.dog/woof.json')
      response = await response.json()
      setDogs(response)
    }

    fetchMyAPI()
  }, []);


  // Fetch Task
  const fetchTask = async () => {
    for (var i = 0; i < 6; i++) {
      async function fetchMyAPI() {
        let response = await fetch('https://random.dog/woof.json')
        response = await response.json()
        setDogs([...dogs, response.url])
      }

      fetchMyAPI()
      console.log("cded")
    }

  }

  return (
    <Router>
      <div className='container'>
        <Routes>
          <Route
            path='/'
            element={<Dogs
              dogsources={dogs} addFavs = {() => this.setFavs}
            />
            }
          />
          <Route path='/favorites' element={<Favorites favs = {favs}/>} />
        </Routes>
      </div>
    </Router>
  )
}

export default App

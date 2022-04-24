import { Link } from 'react-router-dom'

const Favorites = (favs) => {
  return (
    <div>
     <img src={favs.url} alt="Random doggo!" />
      <Link to='/'>Go Back</Link>
    </div>
  )
}

export default Favorites

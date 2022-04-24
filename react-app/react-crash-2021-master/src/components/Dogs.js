import Button from './Button'
const Dogs = ({ dogsources, addFavs }) => {
  console.log("dogsources")
  console.log(dogsources)
  return (
    <>
    { dogsources === undefined || dogsources.length < 0 ? (
                  'No Tasks To Show'
                )  :(
                  <div>
                  <img src={dogsources.url} alt="Random doggo!" />
                  <Button
                  text={'Add Favorite'}
                  onClick={() => addFavs({dogsources})}/>
                  </div>
                
               )}
    </>
  )
}

export default Dogs

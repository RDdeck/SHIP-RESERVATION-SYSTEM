import React,{useEffect, useState} from 'react'
import { useNavigate,Link } from 'react-router-dom'
import {Service} from '../Service/Adminworker'

function Deleteships() {
    const nav = useNavigate();
const [ship, setship]=useState([])

useEffect(() => {
  
    getships();
    
}, [])

const getships=async()=>{
    Service.getships().then ((response)=>{
        setship(response.data)
        
    })
}


const deleteship =async(shipID)=>{
   Service.deleteShip(shipID).then((response)=>{
    getships();
   })
}



  return (
    <div>
    
        <h2 className='title'>Delete All Ships</h2>
        <button className='btn' onClick={()=>nav('/')} >Logout</button>
       
        

      <table  className="table table-success table-striped, table table-bordered border-primary" >
        
            <thead>
                <tr >
                    <th>Ship Id</th>
                    <th>ShipName</th>
                    <th>Reservation_Capacity</th>
                    <th>Seating_Capacity</th>
                    <th>Actions</th>
                </tr>
                
            </thead>
            <tbody>
                {
                    ship.map(
                        ship=>
                        <tr key={ship.shipID}>
                            <td>{ship.shipID}</td>
                            <td>{ship.shipName}</td>
                             <td>{ship.reservationCapacity}</td>
                             <td>{ship.seatingCapacity}</td>
                            <td>
                            {/* <Link className="btn btn-outline-primary" to={`/edit-ship/${ship.shipID}`}>Edit</Link> */}
                            <button className="btn btn-outline-danger" onClick={() => deleteship(ship.shipID)} style={{marginLeft:"10px"}}>Delete</button>
                            {/* <button className="btn btn-outline-sucess" onClick={() => getBankById(customer.bank.bankid)} style={{marginLeft:"10px"}}>Bank Details</button> */}
                            
                            
                            </td>
                        </tr>
                        
                    )
               }
            
            </tbody>
        </table>
        
    </div>
  )
}

export default Deleteships;
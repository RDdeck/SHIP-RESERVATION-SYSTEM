import { useEffect,useState } from 'react'
import {Service} from '../Service/Adminworker'
import { useNavigate,Link } from 'react-router-dom'

function ViewAllSchedule() {
    const nav = useNavigate();
    const [schedule, setSchedule]=useState([])
    
    useEffect(() => {
      
        getschedules();
        
    }, [])
    
    const getschedules=async()=>{
        Service.getschedules().then ((response)=>{
            setSchedule(response.data)
       console.log(response.data)
        })
    }
  return (
    <div>
      <h1>HEllo Sundaram</h1>
      
      <h2 className='title'>View All Schedules</h2>
        {/* <button className='btn' onClick={()=>nav('/ship')} >Create</button>
        */}
        

      <table  className="table table-success table-striped, table table-bordered border-primary" >
        
            <thead>
                <tr >
                    <th>Schedule Id</th>
                    <th>Start_Date</th>
                    <th>Ship_Name</th>
                    <th>Destination</th>
                    <th>Source</th>
                    <th>Travel_Duration</th>
                    <th>Fare</th>
                  
                </tr>
                
            </thead>
            <tbody>
                {
                    schedule.map(
                        schedule=>
                        <tr key={schedule.scheduleID}>
                            <td>{schedule.scheduleID}</td>
                            <td>{schedule.startDate}</td>
                            <td>{schedule.shipbean.shipName}</td>
                            <td>{schedule.routebean.destination}</td>
                            <td>{schedule.routebean.source}</td>
                            <td>{schedule.routebean.travelDuration}</td>
                            <td>{schedule.routebean.fare}</td>
                            <td>
                            {/* <Link className="btn btn-outline-primary" to={`/edit-ship/${ship.shipID}`}>Edit</Link>
                            <button className="btn btn-outline-danger" onClick={() => deleteship(ship.shipID)} style={{marginLeft:"10px"}}>Delete</button> */}
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

export default ViewAllSchedule

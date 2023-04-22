import React, { useEffect, useState } from 'react'
import { useNavigate, useParams } from 'react-router-dom'
import { Service } from '../Service/Adminworker'
function CreateRoute() {
  const { routeID } = useParams();
  const{shipID} = useParams();

  const[shipName, setShipname]=useState("");

const[destination,setDestination]=useState("")

  const nav=useNavigate();

  
  const [data, setData] = useState({
   
    scheduleID: 1,
    startDate: "",
    shipBean: {
        shipID: 0,
        shipName: "",
        seatingCapacity: 0,
        reservationCapacity: 0
    },
    routeBean: {
        routeID: 0,
        source: "",
        destination: "",
        travelduration: "",
        fare: 0,
        shipBean: {
            shipID:0,
            shipName: "",
            seatingCapacity: 0,
            reservationCapacity: 0
        }
    }


  });
  const [shi, setShi] = useState([
    {
      shipName: "",
      shipID: 0,
     
    }
  ])

  const [rou, setRou] = useState([
    {
      destination: "",
      routeID: 0,
     
    }
  ])

  const changedata = (e) => {
    const newdata = { ...data };
    newdata[e.target.id] = e.target.value;
    setData(newdata);
  }


  const handleChangeCus = (e) => {
    const selectShip = shi.find(item => item.shipName === e.target.value);
    const newdata2 = { ...data };
    newdata2[e.target.id] = e.target.value;
    newdata2.shipBean.shipID = selectShip.shipID;
    newdata2.shipBean.shipName = selectShip.shipName;
    newdata2.routeBean.destination = e.target.value;
    setData(newdata2);
  }

  const handleChangeRou = (e) => {
    const selectRoute = rou.find(item => item.destination === e.target.value);
    const newdata3 = { ...data };
    newdata3[e.target.id] = e.target.value;
    newdata3.routeBean.routeID = selectRoute.routeID;
    
    newdata3.routeBean.destination = e.target.value;
    setData(newdata3);
  }


  const handleSubmit =async(e)=>{
    e.preventDefault();
    Service.postSchedule(data);
     
    alert(" Created Schedule Sucessfully");
    nav('/Login')

  }
console.log(data)
  useEffect(() => {

      const fetchdata = async () => {
        const resp = await Service.getships();
        setShi(resp.data);
    }
    

      fetchdata();
  
}, []);

useEffect(() => {

    const fetchdata = async () => {
      const resp = await Service.getRoutes();
      setRou(resp.data);
  }
  

    fetchdata();

}, []);
  
  return (

    <div>
      
      <form onSubmit={handleSubmit} className='Container'>
        <div className='input-box'>
          <b><label>Ship_Name:</label></b>
          <select Value={shipName} onChange={handleChangeCus} >
            <option>--Select Ship--</option>
            {
              shi.map((item) => {
                return <option value={item.shipName} key={item.shipID}>{item.shipName}</option>
              })
            }
          </select>
        </div>


<div className='input-box'>
  <b><label>Destination:</label></b>
  <select Value={destination} onChange={handleChangeRou}>
    <option>--Select Route--</option>
    {
      rou.map((item) => {
        return <option value={item.destination} key={item.routeID}>{item.destination}</option>
      })
    }
  </select>
</div>



        <div className='input-box'>
        <label className="details"for="start_Date"><b>Start_Date:</b></label>
      <input type="text" placeholder="Enter your start_Date" id="startDate"value={data.startDate}  onChange={(e)=>changedata(e)} required="true"/><br/>
      
      </div>
      <button className='btn btn-primary' type="submit" >Sumbit</button>
      {/* {
        title1()
      } */}
      <button className='btn btn-danger'style={{marginLeft:"10px"}} onClick={(e)=>{nav('/Login')}}type="submit" >Cancel</button>
      </form>

      <hr/>
      
    </div>
  )
}

export default CreateRoute;
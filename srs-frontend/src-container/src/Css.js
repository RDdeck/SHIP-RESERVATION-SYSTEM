import React, { useEffect, useState } from 'react'
import axios from 'axios';
// import './ViewShips.css'
import './Addship.css'
// import Footer from './Footer';
// import Header from './Header';
function Css() {
    const [data, setData] = useState([]);

    axios.get('http://localhost:8077/route/viewRoutes').then(res=>{
        setData(res.data)
        
    })

    console.log(data)
        
    return (
      <div>
              <div className='f'>
        {/* <Header/> */}
          <div className='s'>
            <div className='img1'>
      <table border="8">
        <thead>
          <tr>
            <th>ROUTE-ID</th>
            <th>SOURCE</th>
            <th>DESTINATION</th>
            <th>TRAVEL-DURATION</th>
            <th>FARE</th>
            
          </tr>
        </thead>
        <tbody>
          {data.map(item => (
            <tr key={item.routeID}>
                <td>{item.routeID}</td>
              <td>{item.source}</td>

              <td>{item.destination}</td>
              <td>{item.travelDuration}</td>
              <td>{item.fare}</td>
            </tr>
            
          ))}
        </tbody>
      </table>
      
      </div>
      </div>
{/* <Footer/> */}
      </div>
      </div>
)}


export default Css;
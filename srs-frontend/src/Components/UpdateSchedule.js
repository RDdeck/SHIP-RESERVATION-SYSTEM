import React, { useState } from 'react';
import axios from 'axios';

function UpdateSchedule() {
  const [route, setRoute] = useState({scheduleID:"", startDate: '', routeID: '',shipID:'' });
  
  const [message, setMessage] = useState('');

  function handleChange(event) {
    const { name, value } = event.target;
    setRoute(prevRoute => ({ ...prevRoute, [name]: value }));
  }

  

  async function handleSubmit(event) {
    event.preventDefault();
    console.log(JSON.stringify(route))
    try {
      const response = await axios.put(`http://localhost:8077/schedule/updateSchedule/`+route.shipID+'/'+route.routeID, route).then(alert("Schedule is updated"));
      setMessage(response.data.message);
    } catch (error) {
      setMessage('Failed to update Schedule');
    }
  }

  return (
    <div>
      <h2 className="text-center">Update Schedule by ID</h2>
      {message && <p className="text-danger">{message}</p>}
      <form onSubmit={handleSubmit}>
        <div className="form-group">
          <label htmlFor="scheduleID">scheduleID:</label>
          <input
            type="text"
            className="form-control"
            id="scheduleID"
            name="scheduleID"
            value={route.scheduleID}
            onChange={handleChange}
          />
        </div>            
        <div className="form-group">
          <label htmlFor="startDate">Start Date:</label>
          <input
            type="text"
            className="form-control"
            id="startDate"
            name="startDate"
            value={route.startDate}
            onChange={handleChange}
          />
        </div>
        <div className="form-group">
          <label htmlFor="routeID">routeID:</label>
          <input
            type="number"
            className="form-control"
            id="routeID"
            name="routeID"
            value={route.routeID}
            onChange={handleChange}
          />
        </div>
        <div className="form-group">
          <label htmlFor="shipID">shipID:</label>
          <input
            type="text"
            className="form-control"
            id="shipID"
            name="shipID"
            value={route.shipID}
            onChange={handleChange}
          />
        </div>
        
       
        <button type="submit" className="btn btn-primary">Submit</button>
      </form>
    </div>
  );
}

export default UpdateSchedule;
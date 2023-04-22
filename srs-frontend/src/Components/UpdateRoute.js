import React, { useState } from 'react';
import axios from 'axios';

function UpdateRoute() {
  const [route, setRoute] = useState({routeID:"", source: '', destination: '', fare: '',travelDuration:'',shipID:'' });
  
  const [message, setMessage] = useState('');

  function handleChange(event) {
    const { name, value } = event.target;
    setRoute(prevRoute => ({ ...prevRoute, [name]: value }));
  }

  

  async function handleSubmit(event) {
    event.preventDefault();
    console.log(JSON.stringify(route))
    try {
      const response = await axios.put("http://localhost:8077/route/updateRoute", route).then(alert("route is updated"));
      setMessage(response.data.message);
    } catch (error) {
      setMessage('Failed to update route.');
    }
  }

  return (
    <div>
      <h2 className="text-center">Update Route by ID</h2>
      {message && <p className="text-danger">{message}</p>}
      <form onSubmit={handleSubmit}>
        <div className="form-group">
          <label htmlFor="routeID">routeID:</label>
          <input
            type="text"
            className="form-control"
            id="routeID"
            name="routeID"
            value={route.routeID}
            onChange={handleChange}
          />
        </div>            
        <div className="form-group">
          <label htmlFor="source">Source:</label>
          <input
            type="text"
            className="form-control"
            id="source"
            name="source"
            value={route.source}
            onChange={handleChange}
          />
        </div>
        <div className="form-group">
          <label htmlFor="destination">Destination:</label>
          <input
            type="text"
            className="form-control"
            id="destination"
            name="destination"
            value={route.destination}
            onChange={handleChange}
          />
        </div>
        <div className="form-group">
          <label htmlFor="travelDuration">Travel Duration:</label>
          <input
            type="number"
            className="form-control"
            id="travelDuration"
            name="travelDuration"
            value={route.travelDuration}
            onChange={handleChange}
          />
        </div>
        <div className="form-group">
          <label htmlFor="fare">Fare:</label>
          <input
            type="number"
            className="form-control"
            id="fare"
            name="fare"
            value={route.fare}
            onChange={handleChange}
          />
        </div>
        <div className="form-group">
          <label htmlFor="shipID">shipID:</label>
          <input
            type="number"
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

export default UpdateRoute;
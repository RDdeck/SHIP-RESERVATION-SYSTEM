  import React, { useState } from 'react'
  import { useNavigate } from 'react-router-dom';
  import axios from 'axios'
  import "./Login.css"
  function Login() {

    const [userID,setUserID]=useState('')
    const[password,setPassword]=useState('');
  const[role,setRole]=useState('Admin')
  const [Type,setType]=useState('')
    const[error,setError]=useState("");
    const navigate  = useNavigate();
    const handleSubmit =  (event) => {
      event.preventDefault();
  console.log(userID+"  "+password)
        axios.get(`http://localhost:8077/ship/selectUser/${userID}/${password}`).
        then ((res)=>{
          console.log(JSON.stringify(res.data));
          if (res.data == true)
          {
            console.log("WELCOME")
              if (role == "Admin") {
          console.log("hel")
              if (userID === 'AD-001' && password === 'AD-001') {
                navigate('/Addship');
              } else if (userID === 'AD-002' && password === 'AD-002') {
                navigate('/deleteship');
              } else if (userID === 'AD-003' && password === 'AD-003') {
                navigate('/viewship');
              } 
              else if (userID === 'AD-004' && password === 'AD-004') {
                navigate('/updateShip');
              } 
              else if (userID === 'AD-005' && password === 'AD-005') {
                navigate('/addRoute');
              } else if (userID === 'AD-006' && password === 'AD-006') {
                navigate('/deleteRoute');
              } 
              else if (userID === 'AD-007' && password === 'AD-007') {
                navigate('/viewRoutes');
              } 
              else if (userID === 'AD-008' && password === 'AD-008') {
                navigate('/updateRoute');
              } else if (userID === 'AD-009' && password === 'AD-009') {
                navigate('/addSchedule');
              } 
              else if (userID === 'AD-010' && password === 'AD-010') {
                navigate('/deleteSchedule');
              } 
              else if (userID === 'AD-011' && password === 'AD-011') {
                navigate('/viewSchedule');
              } 
              else if (userID === 'AD-012' && password === 'AD-012') {
                navigate('/updateSchedule');
              } 
            }
            else if (role === 'user'){
              if (userID === 'US-001' && password === 'US-001') {
                navigate('/AddProfile');
              } 
              else if (userID === 'US-002' && password === 'US-002') {
                navigate('/viewSchedule');
              }else {
                alert('Incorrect username or password');
              }
        }
      }} 
      ). catch ((err)=> {
        console.error(error);
        setError('Authentication failed');
      });
    
  }


    return (
      <div>
      <form  className='form-cont' onSubmit={handleSubmit}>
          Select Your Role  :{" "}  <select className='select-option' value={role} onChange={(e) => { setRole(e.target.value) }}>
            <option value="Admin">Admin</option>
            <option value="user">User</option>
          </select><br/><br/>
            Enter UserID :{" "} <input type='text' value={userID} onChange={(e)=>{setUserID(e.target.value)}}/><br/>
            Enter Password :{" "} <input type='text' value={password} onChange={(e)=>{setPassword(e.target.value)}}/>
            <button className='bt1'>Login</button><br/>
        </form>
      </div>
    )
  }

  export default Login

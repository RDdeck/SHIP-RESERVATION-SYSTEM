import { Routes, Route } from "react-router-dom";
import "./App.css";
import Viewallships from "./Components/ViewAllships";
import "../node_modules/bootstrap/dist/css/bootstrap.min.css"
import CreateShip from "./Components/CreateShip";
import Navbar from "./Components/Navbar";
import Viewallschedules from "./Components/ViewAllSchedule";
import Login from "./Components/Login";
import DeleteShip from "./Components/DeleteShip";
import ViewallRoutes from "./Components/ViewAllRoutes";
import CreateRoute from "./Components/CreateRoute";
import DeleteRoute from "./Components/DeleteRoute";
import DeleteSchedule from "./Components/DeleteSchedule";
import CreateSchedule from "./Components/CreateSchedule";
import UpdateShip from "./Components/UpdateShip";
import UpdateRoute from "./Components/UpdateRoute";
import UpdateSchedule from "./Components/UpdateSchedule";
import AddProfile from "./Components/AddProfile";


function App() {
  return (
    <div className="App">
      {/* <Navbar/> */}
      <Routes>
     <Route path='/viewship' element = {<Viewallships/>}/> 
     <Route path = "/Addship" element={<CreateShip/>}/>
     <Route path = "/viewschedule" element={<Viewallschedules/>}/>
     <Route path='/' element= {<Login/>}/>
     <Route path='/deleteship' element = {<DeleteShip/>}/>
     <Route path='/viewRoutes' element = {<ViewallRoutes/>}/> 
     <Route path='/addRoute' element = {<CreateRoute/>}/> 
     <Route path='/deleteRoute' element = {<DeleteRoute/>}/> 
     <Route path='/viewSchedule' element = {<Viewallschedules/>}/> 
     <Route path='/deleteSchedule' element = {<DeleteSchedule/>}/>
     <Route path='/addSchedule' element = {<CreateSchedule/>}/>
     <Route path='/updateShip' element = {<UpdateShip/>}/>
     <Route path='/updateRoute' element = {<UpdateRoute/>}/>
     <Route path='/updateSchedule' element = {<UpdateSchedule/>}/>
     <Route path='/AddProfile' element = {<AddProfile/>}/>

     </Routes>
       {/* <Viewallships/> */}
    </div>
  );
}

export default App;

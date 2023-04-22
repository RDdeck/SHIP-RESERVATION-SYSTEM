import axios from 'axios'



const SHIP_BASE_URL='http://localhost:8077/ship'

const ROUTE_BASE_URL='http://localhost:8077/route'

const SCHEDULE_BASE_URL='http://localhost:8077/schedule'

// export const Service= {

//      getships:()=>{
//         return axios.get(SHIP_BASE_URL + '/' + Viewallships)
//       }
//     }
    export const Service = {
      getships: () => {
        return axios.get(SHIP_BASE_URL + '/viewShips');
      },
      post:(message)=>{
        return axios.post(SHIP_BASE_URL + '/addShip',message);
      },
      deleteShip:(shipID)=>{
        return axios.delete(SHIP_BASE_URL + '/deleteship' + '/' + shipID)
      },
      getschedules: () => {
        return axios.get(SCHEDULE_BASE_URL + '/viewschedule');
      },
      getRoutes: () => {
        return axios.get(ROUTE_BASE_URL + '/viewRoutes');
      },
      postRoute:(message)=>{
        return axios.post(ROUTE_BASE_URL + '/addroute',message);
      },
      deleteRoute:(routeID)=>{
        return axios.delete(ROUTE_BASE_URL + '/deleteroute' + '/' + routeID)
      },
      getShipById:(shipID)=>{
        return axios.get(SHIP_BASE_URL + '/ship' + '/' + shipID)
      },
      getRouteById:(routeID)=>{
        return axios.get(ROUTE_BASE_URL + '/viewRouteByrouteid' + '/'+ routeID)
      },
      deleteSchedule:(scheduleID)=>{
        return axios.delete(SCHEDULE_BASE_URL + '/deleteSchedule' + '/' + scheduleID)
      },
      postSchedule:(message)=>{
        return axios.post(SCHEDULE_BASE_URL + '/addschedule',message);
      },

    };
    
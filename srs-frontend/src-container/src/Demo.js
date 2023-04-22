import React, { useState } from 'react'
import Service from './Service/Adminworker';

function Demo() {
    const obj=[{name:'Rajesh',salary:32000},{name:'Vijay',salary:34000}]
  return (
    <div>
        <div>
        <select>       
                {obj.map(element =>
    
        <option>{element.salary}</option>
        
)}
</select>
            
        </div>
    </div>
  )
}

export default Demo
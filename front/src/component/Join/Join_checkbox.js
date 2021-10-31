import React, { useState } from "react";
import "./Join_checkbox.css";
const Join_checkbox=(props)=>{
    const [status,setStatus]=useState(true)
    const sendValue=(text)=>{
        setStatus(!text)
        props.getsetValue(text);
        //console.log(text);
    }

    return(

        <div className="Join-checkbox-class">
            <input type="checkbox"onChange={()=>sendValue(status)} className="Join-checkbox-input-class"  id="Join-checkbox-checkbox-id">
            </input>
            <label className="Join-checkbox-text-class" for="Join-checkbox-checkbox-id">동의합니다</label>
        </div>

    )
}

export default Join_checkbox;
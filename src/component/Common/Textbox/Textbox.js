import React from "react";
import './Textbox.css';
const Textbox=({name})=>{


    return(
        <div className="Textbox">
        <span className="Textbox-name-class" for="Textbox-class">{name}</span>
        <input type ="text" className="Textbox-class">

        </input>
    </div>
    )
}

export default Textbox;
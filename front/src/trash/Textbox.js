import React,{useState} from "react";
import './Textbox.css';
var textvalue;


const Textbox=(props,{name})=>{

    const sendValue=(text)=>{
        props.getsetValue(text);
    }
    return(
        <div className="Textbox">
        <span className="Textbox-name-class" for="Textbox-class">{name}</span>
        <input type ="text" value={textvalue} onChange={()=>sendValue("씨벌")} className="Textbox-class">

        </input>
    </div>
    )
}

export default Textbox;
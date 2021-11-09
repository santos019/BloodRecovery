import { ADD_PAGE } from "./action"
import React,{useEffect,useState} from "react";
const initialState={
    index:0,
    page: " "
}

function memory(key,data){
   // JSON.parse(window.localStorage.getItem(key)) 
    window.localStorage.setItem("last", JSON.stringify(data))
    console.log( JSON.parse(window.localStorage.getItem("last")))
}
const subcribersReducer =(state=initialState, action)=>{

    switch(action.type){
        case ADD_PAGE:
            memory(state.index+1,action.inputpage)
            return {
            ...state,
            index:state.index+1,
            page: JSON.parse(window.localStorage.getItem("last"))
            
            
            
        }

    default: return state
    }
}

export default subcribersReducer;
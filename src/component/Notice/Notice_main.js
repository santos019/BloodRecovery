import React, { useState } from "react";
import { BrowserRouter, Link, Route, Switch } from "react-router-dom";
import { Router } from "react-router";
import Notice_nav from "./Notice_nav";
import Test1 from "../Main/Test1";
import './Notice_main.css';

function Notice_main() {
  var i=true;
  const [btn,setbtn]=useState(false);
 const onClick =()=>{

  i= !i;
  console.log("작동"+i);
 
 };

  return (
    <div className="Notice_main_class">
      <div>


        <BrowserRouter>
      
          <Route exact path="/test1" component={Test1} />

          <Notice_nav></Notice_nav>

         
            <button onClick={()=>setbtn(true)}>test1으로</button>
            
            {{
              true : <Test1></Test1>
            }[btn]}
         
        </BrowserRouter>


      </div>

    </div>
  )
}

export default Notice_main;
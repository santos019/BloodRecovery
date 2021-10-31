import React, { useState } from 'react';
import ReactModal from 'react-modal';
import { BrowserRouter, Link, Route, Switch } from "react-router-dom";
import './Test1.css';
import App from '../../App';
import UseLocalHook from '../Common/UseLocalHook';
function Test1(){

    const [modalIsOpen, setModalIsOpen] = UseLocalHook("true",false);

    return(
<div className="Main_list1_class">
<p>
         ^^ 여기는 테스트페이지입니다
        </p>
{/* <button onClick={()=> setModalIsOpen(true)}>리스트111111</button> 
        <ReactModal isOpen={modalIsOpen} onRequestClose={() => setModalIsOpen(false)}>
         55555555555555
         <BrowserRouter>
         <Switch>
    <Route exact path="/test1/Login" component={Login_modal}/>
    <Route exact path="/" component={App}/>
    <Link to="/">
        <button>22222</button>
      </Link>
    </Switch>
    </BrowserRouter>
        
       
          Learn React
        <button onClick={()=> setModalIsOpen(false)}>닫음버튼</button> 
        </ReactModal>
         */}
</div>

    )
}
export  default Test1;
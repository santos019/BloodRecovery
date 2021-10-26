import React,{useState} from "react";
import { BrowserRouter, Link, Route, Switch } from "react-router-dom";
import { Router } from "react-router";
import Notice_nav from "./Notice_nav";
import ReactModal from 'react-modal';
import Main_Button from '../Common/Button/Main_Button';
import Test1 from "../Main/Test1";
import './Notice_main.css';
function Notice_main(){
    const Counter2 = name => {
        setModalIsOpen(true)
        //modal=command;
        console.log("first i="+name);
        
      }
    const [modalIsOpen, setModalIsOpen] = useState(false);

    return (
        <div className="Notice_main_class">
               <div>
                   <div onClick={()=> Counter2("2")}>
            <Main_Button name={"공지사항"} ></Main_Button></div>
                <ReactModal isOpen={modalIsOpen} onRequestClose={() => setModalIsOpen(false)} shouldCloseOnOverlayClick={false}>
                <BrowserRouter>

    
    <Route exact path="/test1" component={Test1}/>

    
      <Link to="/test1">
        <button>test1으로</button>
      </Link>
 
      
                    <Notice_nav></Notice_nav>
                    
      <Link to="/">
                     <button onClick={()=> setModalIsOpen(false)}>Modal Open</button> </Link>
                     </BrowserRouter>
                </ReactModal>
                
                </div>
           
        </div>
    )
}

export default Notice_main;
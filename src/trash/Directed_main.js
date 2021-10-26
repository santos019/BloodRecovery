import React, { useState } from 'react';
import Directed_nav from "./Directed_nav";
import ReactModal from 'react-modal';
import Main_Button from '../Common/Button/Main_Button';
import UseLocalHook from '../Common/UseLocalHook';
function Directed_main (){

    const [modalIsOpen, setModalIsOpen] = UseLocalHook("true",false);

    return (
        <div>
               <div className="Directed_main_class" >
                   <div onClick={()=> setModalIsOpen(true)}>
            <Main_Button name={"지정헌혈 기부"} ></Main_Button></div>
                <ReactModal isOpen={modalIsOpen} onRequestClose={() => setModalIsOpen(false)}>
                  
                    <Directed_nav></Directed_nav>
                     <button onClick={()=> setModalIsOpen(false)}>Modal Open</button>
                </ReactModal>
        </div>
           
        </div>
    )
}

export default Directed_main;
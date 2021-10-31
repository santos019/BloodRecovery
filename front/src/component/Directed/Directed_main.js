import React, { useState } from 'react';
import Directed_nav from "./Directed_nav";
import ReactModal from 'react-modal';
import Main_Button from '../Common/Button/Main_Button';
import UseLocalHook from '../Common/Function/UseLocalHook';
function Directed_main (){

    const [modalIsOpen, setModalIsOpen] = UseLocalHook("true",false);

    return (
        <div>
               <div className="Directed_main_class" >
           
                  
                    <Directed_nav></Directed_nav>
                
                
        </div>
           
        </div>
    )
}

export default Directed_main;
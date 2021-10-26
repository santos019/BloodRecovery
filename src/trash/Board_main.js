import React, { useState } from 'react';
import Board_nav from './Board_nav';
import ReactModal from 'react-modal';
import Main_Button from '../Common/Button/Main_Button';
import UseLocalHook from '../Common/UseLocalHook.js';
function Board_main()
{
    const [modalIsOpen, setModalIsOpen] = UseLocalHook("true",false);

    return (
        <div>
               <div className="Board_main_class" >
                   <div onClick={()=> setModalIsOpen(true)}>
            <Main_Button name={"헌혈증 기부"} ></Main_Button></div>
                <ReactModal isOpen={modalIsOpen} onRequestClose={() => setModalIsOpen(false)}>
                  
                    <Board_nav></Board_nav>
                     <button onClick={()=> setModalIsOpen(false)}>Modal Open</button>
                </ReactModal>
        </div>
           
        </div>
    )
}

export default Board_main;
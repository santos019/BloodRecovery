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
           
                  
                    <Board_nav></Board_nav>
               
        </div>
           
        </div>
    )
}

export default Board_main;
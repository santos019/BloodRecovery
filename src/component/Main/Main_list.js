import React, { useState } from 'react';
import ReactModal from 'react-modal';
import Test1 from './Test1.js'
import './Main_list.css'
import Board_main from '../Board/Board_main.js';
import UseLocalHook from '../Common/UseLocalHook.js';
import Directed_main from '../Directed/Directed_main.js';
import Bloodhouse_main from '../Bloodhouse/Bloodhouse_main.js';
import Notice_main from '../Notice/Notice_main.js';
function Main_list()

{  const [modalIsOpen, setModalIsOpen] = useState(false);
    return(
    <div className="Main_list_class">
        <div className="Main_list_button_1">
        <Board_main></Board_main>
        </div>
        <div className="Main_list_button_1">
        <Directed_main></Directed_main>
        </div>
        <div className="Main_list_button_1">
        <Bloodhouse_main></Bloodhouse_main>
        </div>
        <div className="Main_list_button_1">
        <Notice_main></Notice_main>
        </div>
    </div>
    )
    
}

export default Main_list;
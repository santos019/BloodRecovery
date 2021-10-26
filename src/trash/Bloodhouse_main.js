import React,{useState} from "react";
import Bloodhouse_nav from "./Bloodhouse_nav";
import ReactModal from 'react-modal';
import Main_Button from '../Common/Button/Main_Button';
import UseLocalHook from '../Common/UseLocalHook';
function Bloodhouse_main(){

    const [modalIsOpen, setModalIsOpen] = UseLocalHook("true",false);

    return (
        <div>
               <div className="Bloodhouse_main_class" >
                   <div onClick={()=> setModalIsOpen(true)}>
            <Main_Button name={"헌혈의 집 예약"} ></Main_Button></div>
                <ReactModal isOpen={modalIsOpen} onRequestClose={() => setModalIsOpen(false)}>
                  
                    <Bloodhouse_nav></Bloodhouse_nav>
                     <button onClick={()=> setModalIsOpen(false)}>Modal Open</button>
                </ReactModal>
        </div>
           
        </div>
    )
}

export default Bloodhouse_main;
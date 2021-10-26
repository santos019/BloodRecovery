import React, { useState } from 'react';
import ReactModal from 'react-modal';
import './Join_modal.css';
function Join_modal(){

    const [modalIsOpen, setModalIsOpen] = useState(false);
    return(
        <div>
        <button onClick={()=> setModalIsOpen(true)}>회원가입</button>
        <ReactModal isOpen={modalIsOpen} onRequestClose={() => setModalIsOpen(false)}>
          modal
         
        
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
       
          Learn React
       <button onClick={()=> setModalIsOpen(false)}>Modal Open</button>
        </ReactModal>
        </div>

    );
}

export default Join_modal;
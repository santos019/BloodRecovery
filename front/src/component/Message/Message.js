import React, { useEffect, useState } from 'react';
import axios from 'axios';
import Message_card from './Message_card';
import './Message.css';

const Message = (props) => {
    const [messages, setMessages] = useState([]);
    const [messageMode, setMessageMode] = useState("");

    useEffect(() => {
        axios
        .get("http://BloodRecovery-LB-1423483073.us-east-2.elb.amazonaws.com:8000/notice/message/" + 
            messageMode + sessionStorage.getItem("userId"))
        .then(function(response){
            setMessages(response.data);
        });
    }, [messageMode]);

    const deleteMesssage = (mode) => {
        axios
            .delete("http://BloodRecovery-LB-1423483073.us-east-2.elb.amazonaws.com:8000/notice/message/" +
                mode + sessionStorage.getItem("userId"));
        console.log(mode, "로 delete 실행")
    };

    return(
        <div className="Message-main-container">
            <div className="Message-main-nav-container">
                <div className="Message-main-nav-class">
                    <div className="Message-main-nav-button-container">
                        <button className="Message-main-nav-button-show" onClick={()=>setMessageMode("")}>전체 메시지</button>
                        <button className="Message-main-nav-button-show" onClick={()=>setMessageMode("read/")}>읽은 메시지</button>
                        <button className="Message-main-nav-button-show" onClick={()=>setMessageMode("unread/")}>안읽은 메시지</button>
                        <button className="Message-main-nav-button-delete" onClick={()=>deleteMesssage("")}>전체 삭제</button>
                        <button className="Message-main-nav-button-delete" onClick={()=>deleteMesssage("read/")}>읽은 메시지 삭제</button>
                    </div>
                </div>
            </div>
            <div className="Message-main-cardmain-container">
                {messages.map((menu, index) => (<Message_card getData={messages[index]} key={index}></Message_card>))}
            </div>
        </div>
    )

}

export default Message;
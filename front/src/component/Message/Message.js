import React, { useState, useEffect } from 'react';
import axios from 'axios';

const Message = (props) => {
    const [messages, setMessages] = useState([]);
    const [messageMode, setMessageMode] = useState("");

    useEffect(() => {
        axios
            .get("http://BloodRecovery-LB-1423483073.us-east-2.elb.amazonaws.com:8000/notice/message/" + 
                messageMode + "/" + sessionStorage.getItem("userId"))
            .then(function(response){
                setMessages(response.data);
            });
        console.log(messages);
    }, [messageMode]);

    return(
        <div className="Message-main-class">
            
        </div>
    )

}

export default Message;
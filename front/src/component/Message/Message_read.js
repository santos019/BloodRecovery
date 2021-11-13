import React, { useEffect, useState } from 'react';
import axios from 'axios';
import './Message_read.css';

const Message_read = (props) => {
    const [message, setMessage] = useState(null);

    const showMesssage = (mode) => {
        axios
            .get("http://BloodRecovery-LB-1423483073.us-east-2.elb.amazonaws.com:8000/message/one/" +
                sessionStorage.getItem("messageId"))
            .then(function(response){
                setMessage(response.data);
            });
    };

    return(
        <div className="Message-read-container">
            <div className="Message-read-nav-container">
                <div className="Message-read-nav-class">
                    {message}
                </div>
            </div>
            <div className="Message-read-contents-container">
                <div className="Message-read-contents-title-class">
                    타이틀
                </div>
                <div className="Message-read-contents-content-class">
                    내용
                </div>
            </div>
            <div className="Message-read-footer-container">
                <div className="Message-read-footer-class">
                    푸터
                </div>
            </div>
        </div>
    )

}

const mapStateToProps = (state) => {
    return {
        page: state.page

    }
}
const mapDispatchToProps = (dispatch) => {
    return {
        addPage: (text) => dispatch(addPage(text))
    }
}

export default connect(mapStateToProps, mapDispatchToProps)(Message_read);

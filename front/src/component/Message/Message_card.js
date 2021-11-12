import React from "react";

const Message_card = (getData) => {
    function clickEvent(){
        sessionStorage.setItem("messageId", getData.getData.id);
        getData.addPage("메시지상세조회");
    }

    return(
        <div className="Message-card-container" onClick={clickEvent}>
            <div className="Message-card-nav-container">
                <div className="Message-card-nav-username">
                    
                </div>
            </div>
        </div>
    )
}
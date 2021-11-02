import React from "react";
import './Directed_card.css';
const Directed_card=(getData,index)=>{



    return(

        <div className="Directed-card-container">
            <div className="Directed-card-nav-container">
                <div className="Directed-card-nav-usericon-class">
                   
                </div>
                <div className="Directed-card-nav-username-class">
                    최고봉
                </div>
                <div className="Directed-card-nav-userstatus-class">
                    굳
                </div>
            </div>
            <div className="Directed-card-content-container">
                내용
            </div>
            <div className="Directed-card-footer-container">
                푸터
                {getData.getData[0]?.id
                
                    //getData.getData[0]
                    //==="id"?console.log("ture"):console("false")
                    
                }
                {
                    console.log(index)
                }
                
                
            </div>

        </div>
    )

}

export default Directed_card;
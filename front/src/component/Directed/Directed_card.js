import React from "react";
import './Directed_card.css';
import BRONZE from "../../Img/Grade/4_bronze.png";
import SIVER from "../../Img/Grade/3_silver.png";
import GOLD from "../../Img/Grade/2_gold.png";
import VIP from "../../Img/Grade/1_vip.png";

const gradefunction=(Grade)=>{

    if(Grade===34) //BRONZE 예정
        return (<img className="Directed-img-userimg" src={BRONZE}></img>)
    else if(Grade===32) //SIVER 예정
        return (<img className="Directed-img-userimg" src={SIVER}></img>)
    else if(Grade===30) //GOLD 예정
        return (<img className="Directed-img-userimg" src={GOLD}></img>)
    else //레벨4 VIP
        return (<img className="Directed-img-userimg" src={VIP}></img>)

}



const Directed_card=(getData)=>{



    return(

        <div className="Directed-card-container">
            <div className="Directed-card-nav-container">
                <div className="Directed-card-nav-usericon-class">
                   {
                       gradefunction(getData.getData?.requesterId)
                     
                   }
                </div>
                <div className="Directed-card-nav-username-class">
                    <p>{getData.getData?.requesterNickname}</p>
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
                {
                
                    //getData.getData[0]
                    //==="id"?console.log("ture"):console("false")
                    
                }
                {
                    console.log(getData.getData?.id)
                }
                
                
            </div>

        </div>
    )

}

export default Directed_card;
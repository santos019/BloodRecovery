import React from "react";
import "./Notice_card.css";

// const gradefunction=(Grade)=>{

//     if(Grade===34) //BRONZE 예정
//         return (<img className="Directed-img-userimg" src={BRONZE}></img>)
//     else if(Grade===32) //SIVER 예정
//         return (<img className="Directed-img-userimg" src={SIVER}></img>)
//     else if(Grade===30) //GOLD 예정
//         return (<img className="Directed-img-userimg" src={GOLD}></img>)
//     else //레벨4 VIP
//         return (<img className="Directed-img-userimg" src={VIP}></img>)

// }

//날짜 T이후로 쪼개는거
const dividedate = (inputdate) => {
  var redate = "~ ";
  for (var i in inputdate) {
    if (inputdate[i] == "T") break;

    redate = redate + inputdate[i];
  }
  return redate;
};

const Notice_card = (setData) => {
  return (
    <div className="Notice-card-container">
      <div className="Notice-card-nav-container">
        <div className="Notice-card-nav-usericon-class">
          {/* <p>{setData.setData?.usericon}</p> */}
        </div>

        <div className="Notice-card-nav-username-class">
          <p>{setData.setData?.writerNickname}</p>
        </div>

        <div className="Notice-card-content-container">
          <p className="Notice-card-content-class">
            {setData.setData?.contents}
          </p>
          내용블라블라
        </div>

        <div className="Notice-card-footer-date-container">
          <div className="Notice-card-footer-date-class">
            <p className="Notice-card-footer-date-p-class">
              {setData.setData?.periodTo}
              2020-02-02
            </p>
          </div>
        </div>
        {
          //getData.getData[0]
          //==="id"?console.log("ture"):console("false")
        }
        {/* {console.log(setData.setData?.id)} */}
      </div>
    </div>
  );
};
export default Notice_card;

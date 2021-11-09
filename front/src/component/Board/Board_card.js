import React, { Link, Route } from "react";
import "./Board_card.css";
import BRONZE from "../../Img/Grade/4_bronze.png";
import SIVER from "../../Img/Grade/3_silver.png";
import GOLD from "../../Img/Grade/2_gold.png";
import VIP from "../../Img/Grade/1_vip.png";
import BLOODDROP from "../../Img/DirectedIMG/blood-drop.png";
// import LOCATION from "../../Img/DirectedIMG/location.png";
// import Board_inquire from './Board_inquire';
import Board_main from "./Board_main";
import { connect } from "react-redux";
import { addPage } from "../../component/Modalmove/subscribers/action";

const gradefunction = (Grade) => {
  if (Grade === 1)
    //BRONZE 예정
    return <img className="Directed-img-userimg" src={BRONZE}></img>;
  else if (Grade === 2)
    //SIVER 예정
    return <img className="Directed-img-userimg" src={SIVER}></img>;
  else if (Grade === 3)
    //GOLD 예정
    return <img className="Directed-img-userimg" src={GOLD}></img>;
  //레벨4 VIP
  else return <img className="Directed-img-userimg" src={VIP}></img>;
};
//날짜 T이후로 쪼개는거
const dividedate = (inputdate) => {
  var redate = "";
  for (var i in inputdate) {
    if (inputdate[i] == "T") break;

    redate = redate + inputdate[i];
  }
  return redate;
};

const Board_card = (getData) => {
  // const sendValue=(text)=>{
  //     getData.getsetValue3(getData.getData.id);
  //     //그냥이렇게하면된다!!
  // }

  return (
    <div
      className="Board-card-container"
      onClick={() => getData.addPage("헌혈증요청조회")}
    >
      <div className="Board-card-nav-container">
        <div className="Board-card-nav-usericon-class">
          {gradefunction(getData.getData?.level)}
        </div>
        <div className="Board-card-nav-username-class">
          <p>{getData.getData?.nickname}</p>
        </div>
        <div className="Board-card-nav-userstatus-container">
          <div className="Board-card-nav-userstatus-class">
            <img
              src={BLOODDROP}
              className="Board-card-nav-userstatus-icon"
            ></img>
            {getData.getData?.donationCount}/{getData.getData?.requestCount}
          </div>
        </div>
      </div>
      <div className="Board-card-content-container">
        <p className="Board-card-content-class">{getData.getData?.title}</p>
      </div>
      <div className="Board-card-footer-container">
        <div className="Board-card-footer-date-container">
          <div className="Board-card-footer-date-class">
            <p className="Board-card-footer-date-p-class">
              {dividedate(getData.getData?.requestDate)}
            </p>
          </div>
        </div>

        {console.log(getData.getData?.id)}
      </div>
    </div>
  );
};
const mapStateToProps = (state) => {
  return {
    page: state.page,
  };
};
const mapDispatchToProps = (dispatch) => {
  return {
    addPage: (text) => dispatch(addPage(text)),
  };
};
export default connect(mapStateToProps, mapDispatchToProps)(Board_card);

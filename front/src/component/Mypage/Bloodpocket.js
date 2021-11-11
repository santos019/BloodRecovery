import React, { useEffect, useState } from "react";
import axios from "axios";
import "./Bloodpocket.css";
import GOBACKBTN from "../../Img/DirectedIMG/arrow.png";
import { addPage } from "../../component/Modalmove/subscribers/action";
import { connect } from "react-redux";
import Menu_nav_text from "../Common/Header/Menu_left_nav";
import Menu_left_nav from "../Common/Header/Menu_left_nav";
import POCKETICON from "../../Img/pocket.png";
import DIRECTED_BUTTON_IMG from "../../Img/DirectedIMG/DIRECTEDIMGWHITE.png";
import Common_Button_IMG from "../Common/Button/Common_Button_IMG";
import S3Upload from "../Common/Function/S3fileUpload";

function Bloodpocket_main(props, getData) {
  const [getIMG, setIMG] = useState(null);

  //내가 가진 헌혈증 카드 조회
  const [card, setCard] = useState();
  useEffect(() => {
    axios
      .get(
        // "http://bloodrecovery-lb-1423483073.us-east-2.elb.amazonaws.com:8000/bloodpocket/"
        "http://localhost:8000/bloodpocket/아이디1"
        //+ sessionStorage.getItem("userId")
      )
      .then(function (response) {
        setCard(response);
      });
  }, []);

  function movepage(text) {
    props.addPage(text);
  }
  const getsetValue = (text) => {
    props.addPage(text);
  };

  const getfilename = (value) => {
    // console.log("wow",value)
    setIMG(value);
  };

  //카드조회
  function clickevent() {
    sessionStorage.setItem("cardId", getData.getData.id);
    getData.addPage("헌혈증조회");
  }

  return (
    <div className="Bloodpocket-main-container-class">
      <div className="Bloodpocket-main-class">
        <div className="Bloodpocket-main-Header">
          {console.log("card", card)}
          <Menu_left_nav name={"내 지갑"} imgname={POCKETICON}></Menu_left_nav>
          <div className="Bloodpocket-nav-goback">
            <img
              className="Bloodpocket-goback-bntimg-class"
              onClick={() => props.addPage("마이페이지")}
              src={GOBACKBTN}
            ></img>
          </div>
        </div>
      </div>
      <div className="Bloodpocket-main-nav-container"></div>
      {card?.data.map((menu, index) => (
        <div className="Bloodpocket-card-container" onClick={clickevent}>
          <div className="Bloodpocket-card-nav-container"></div>
        </div>
      ))}
      <div className="Bloodpocket-footer-container">
        {/* {context===true?<Bloodpocket_data></Bloodpocket_data>:null} */}
        <div className="Bloodpocket-footer-btn-container">
          <div className="Bloodpocket-footer-btn-class" onClick={clickevent}>
            <Common_Button_IMG
              name={"기부하기"}
              imgname={DIRECTED_BUTTON_IMG}
            ></Common_Button_IMG>
          </div>
        </div>
        {console.log("cc", card)}
        <div className="Bloodpocket-footer-info1-class">
          헌혈증을 선택하고 기부하기를 누르세요
        </div>
      </div>

      {/* <div className="Mypage-write-footer-container">
        <div className="Mypage-write-footer-upload">
          <S3Upload getfilename={getfilename} />
        </div>
      </div> */}
    </div>
  );
}

const mapDispatchToProps = (dispatch) => {
  return {
    addPage: (text) => dispatch(addPage(text)),
  };
};

export default Bloodpocket_main;

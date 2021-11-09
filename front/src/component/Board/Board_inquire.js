import React, { useEffect, useState } from "react";
import { withRouter } from "react-router";
import Menu_left_nav from "../Common/Header/Menu_left_nav";
import CARDDONATION from "../../Img/CARDDONATION.png";
import GOBACKBTN from "../../Img/DirectedIMG/arrow.png";
// import Common_Button_IMG from "../Common/Button/Common_Button_IMG";
// import Directed_BUTTON_IMG from "../../Img/DirectedIMG/DirectedIMGWHITE.png";
import BLOODDROPIMG from "../../Img/DirectedIMG/blood-drop.png";
import BRONZE from "../../Img/Grade/4_bronze.png";
import SIVER from "../../Img/Grade/3_silver.png";
import GOLD from "../../Img/Grade/2_gold.png";
import VIP from "../../Img/Grade/1_vip.png";
import axios from "axios";

import { connect } from "react-redux";
import { addPage } from "../../component/Modalmove/subscribers/action";
import "./Board_inquire.css";

const Board_inquire = (id) => {
  const [getData, setGetData] = useState();
  const sendValue = () => {
    id.getsetValue3();
  };

  useEffect(() => {
    axios
      .get(
        "http://bloodrecovery-lb-1423483073.us-east-2.elb.amazonaws.com:8000/card/requests/" +
          sessionStorage.getItem("boardId")
      )

      .then(function (response) {
        setGetData(response);
        console.log("response1", response);
      });
  }, []);

  const deleteData = () => {
    axios
      .delete(
        "http://bloodrecovery-lb-1423483073.us-east-2.elb.amazonaws.com:8000/card/requests/" +
          sessionStorage.getItem("boardId")
      )

      .then(function (response) {
        alert("게시글이 삭제되었습니다.");
        console.log("response", response);
      });
  };

  // const writeStatue = (status) => {
  //     if (status === false)
  //         return "진행중";
  //     else return "완료"
  // } 나는 그 1/3 이런거!

  const dividedate = (inputdate) => {
    var redate = "";
    for (var i in inputdate) {
      if (inputdate[i] == "T") break;

      redate = redate + inputdate[i];
    }
    return redate;
  };
  const levelIMG = (level) => {
    if (level === 1) return BRONZE;
    else if (level === 2) return SIVER;
    else if (level === 3) return GOLD;
    else if (level === 4) return VIP;
  };

  return (
    <div className="Board-inquire-container">
      <div className="Board-inquire-nav-container">
        <div className="Board-inquire-nav-class">
          <Menu_left_nav
            name={"헌혈증 기부"}
            imgname={CARDDONATION}
          ></Menu_left_nav>
          {console.log(id.id)}
        </div>
        <div className="Board-inquire-nav-goback">
          <img
            className="Board-inquire-goback-bntimg-class"
            onClick={() => id.addPage("헌혈증_기부")}
            src={GOBACKBTN}
          ></img>
        </div>
      </div>
      <div className="Board-inquire-content-container">
        <div className="Board-inquire-content-class">
          <div className="Board-inquire-card-class">
            <div className="Board-inquire-card-total">
              <div className="Board-inquire-card-nav-class">
                <div className="Board-inquire-card-title-class">
                  {getData?.data.title}
                </div>
                <div className="Board-inquire-card-data-class">
                  {dividedate(getData?.data.requestDate)}
                </div>
              </div>
              <div className="Board-inquire-card-info-class">
                <div className="Board-inquire-card-writer-container">
                  <img
                    src={levelIMG(getData?.data.level)}
                    className="Board-inquire-card-writer-icon"
                  ></img>
                  <div className="Board-inquire-card-writername-class">
                    {getData?.data.nickname}
                  </div>
                </div>
              </div>
              <div className="Board-inquire-card-context-class">
                {getData?.data.contents}
              </div>
              <div className="Board-inquire-card-footer-class">
                <div className="Board-inquire-card-footer-status">
                  <img
                    src={BLOODDROPIMG}
                    className="Board-inquire-card-footer-statueIMG"
                  ></img>
                  <div className="Board-inquire-card-footer-statustext">
                    {getData?.data.donationCount}/{getData?.data.requestCount}
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div className="Board-inquire-footer-container">
            {getData?.data.requesterUserId ===
            sessionStorage.getItem("userId") ? (
              <div>
                <div className="Board-inquire-footer-mypost">
                  <div
                    className="Board-inquire-footer-delete"
                    onClick={deleteData}
                  >
                    삭제
                  </div>
                  <div className="Board-inquire-footer-repost">수정</div>
                </div>
              </div>
            ) : null}

            <div className="Board-inquire-footer-applicant">기부자</div>
          </div>
        </div>
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

export default connect(mapStateToProps, mapDispatchToProps)(Board_inquire);

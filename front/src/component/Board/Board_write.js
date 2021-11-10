import React, { useState } from "react";
import BoardIMG from "../../Img/CARDDONATION.png";
import GOBACKBTN from "../../Img/DirectedIMG/arrow.png";
import Menu_left_nav from "../Common/Header/Menu_left_nav";
import { connect } from "react-redux";
import { addPage } from "../Modalmove/subscribers/action";
import DataPicker from "react-datepicker";
import { ko } from "date-fns/esm/locale";
import S3Upload from "../Common/Function/S3fileUpload";
import "./Board_write.css";
import BLOODDROP from "../../Img/DirectedIMG/blood-drop.png";
import LOCATIONIMG from "../../Img/DirectedIMG/location.png";
import Common_Button_IMG from "../Common/Button/Common_Button_IMG";
import WRITEWHITEIMG from "../../Img/DirectedIMG/WRITE_WHITE.png";
// import Board_write_select from "./Board_write_select";
// import Directed_write_select from "./Directed_write_select";

function Board_write(props) {
  const [startDate, setStartDate] = useState(new Date());
  const [endDate, setendDate] = useState(new Date());
  //헌혈증받는변수
  const [directCount, setDirectCount] = useState(0);

  const [inputs, setInputs] = useState({
    direct_title: "",
    direct_date1: "", //date형식으로
    direct_date2: "", //date형식으로
  });

  const countClick = (text) => {
    if (text === "countdown" && directCount > 0) {
      setDirectCount(directCount - 1);
    } else if (text === "countup" && directCount < 10) {
      setDirectCount(directCount + 1);
    }
  };

  return (
    <div className="Board-write-container">
      <div className="Board-write-nav-container">
        <div className="Board-write-nav-class">
          <Menu_left_nav
            name={"헌혈증 기부"}
            imgname={BoardIMG}
          ></Menu_left_nav>
        </div>
        <div className="Board-write-nav-goback">
          <img
            className="Board-write-goback-bntimg-class"
            onClick={() => props.addPage("헌혈증_기부")}
            src={GOBACKBTN}
          ></img>
        </div>
      </div>
      <div className="Board-write-content-container">
        <div className="Board-write-content-class">
          <div className="Board-write-card-class">
            <div className="Dircected-write-card-total">
              <div className="Board-write-card-nav-class">
                <input
                  name="direct_title"
                  className="Board-write-card-title-class"
                ></input>
              </div>

              <div className="Board-write-card-context-class">
                <textarea
                  name="direct_context"
                  className="Board-write-card-context-input"
                ></textarea>
              </div>
              <div className="Board-write-card-footer-class"></div>
            </div>
          </div>
          <div className="Board-write-footer-container">
            <div className="Board-write-footer-upload-container">
              <div className="Board-write-footer-upload">
                <S3Upload />
              </div>
            </div>
            <div className="Board-write-footer-givecount-container">
              <div className="Board-write-footer-givecount">
                <img
                  src={BLOODDROP}
                  className="Board-write-footer-givecountimg"
                ></img>
                <div className="Board-write-footer-givecounttext">
                  지정헌혈 받을 횟수
                </div>
                <div className="Board-write-footer-count-container">
                  <div
                    className="Board_countdown"
                    onClick={() => countClick("countdown")}
                  >
                    -
                  </div>
                  <div className="Board_count">{directCount}</div>
                  <div
                    className="Board_countup"
                    onClick={() => countClick("countup")}
                  >
                    +
                  </div>
                </div>
              </div>
            </div>

            <div className="Board-write-btn-container">
              <div className="Board-write-btn-class">
                <Common_Button_IMG
                  name={"작성완료"}
                  imgname={WRITEWHITEIMG}
                ></Common_Button_IMG>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

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

export default connect(mapStateToProps, mapDispatchToProps)(Board_write);

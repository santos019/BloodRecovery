import React, { useEffect, useState } from "react";
import { withRouter } from "react-router";
import Menu_left_nav from "../Common/Header/Menu_left_nav";
import DIRECTEDIMG from "../../Img/DIRECTEDIMG.png";
import GOBACKBTN from "../../Img/DirectedIMG/arrow.png";
import Common_Button_IMG from "../Common/Button/Common_Button_IMG";
import DIRECTED_BUTTON_IMG from "../../Img/DirectedIMG/DIRECTEDIMGWHITE.png";

import axios from "axios";
import { connect } from "react-redux";
import { addPage } from "../../component/Modalmove/subscribers/action";
import "./Notice_inquire.css";

const Notice_inquire = (id) => {
  const [getData, setGetData] = useState();
  const [viewData, setViewData] = useState(false);
  const [getApplicants, setGetApplicants] = useState();
  const sendValue = () => {
    id.getsetValue3();
  };
  const getValue = () => {
    setViewData(!viewData);
    console.log("test");
  };
  useEffect(() => {
    axios
      .get(
        "http://bloodrecovery-lb-1423483073.us-east-2.elb.amazonaws.com:8000/notice/" +
          id.id
      )

      .then(function (response) {
        setGetData(response);
        console.log("response1", response);
      });
  }, []);
  useEffect(() => {
    axios
      .get(
        "http://bloodrecovery-lb-1423483073.us-east-2.elb.amazonaws.com:8000/notice/" +
          id.id +
          "/applicants"
      )

      .then(function (response) {
        setGetApplicants(response);
        console.log("response", response);
      });
  }, []);
  const deleteData = () => {
    axios
      .delete(
        "http://bloodrecovery-lb-1423483073.us-east-2.elb.amazonaws.com:8000/notice/" +
          id.id
      )

      .then(function (response) {
        alert("게시글이 삭제되었습니다.");
        console.log("response", response);
      });
  };
  const writeStatue = (status) => {
    if (status === false) return "진행중";
    else return "완료";
  };
  const dividedate = (inputdate) => {
    var redate = "";
    for (var i in inputdate) {
      if (inputdate[i] == "T") break;

      redate = redate + inputdate[i];
    }
    return redate;
  };

  return (
    <div className="Notice-inquire-container">
      <div className="Notice-inquire-nav-container">
        <div className="Notice-inquire-nav-class">
          <Menu_left_nav
            name={"공지사항"}
            imgname={DIRECTEDIMG}
          ></Menu_left_nav>
        </div>
        <div className="Notice-inquire-nav-goback">
          <img
            className="Notice-inquire-goback-bntimg-class"
            onClick={() => id.addPage("공지사항")}
            src={GOBACKBTN}
          ></img>
        </div>
      </div>
      <div className="Notice-inquire-content-container">
        <div className="Notice-inquire-content-class">
          <div className="Notice-inquire-card-class">
            <div className="Notice-inquire-card-total">
              <div className="Notice-inquire-card-nav-class">
                <div className="Notice-inquire-card-title-class">
                  {getData?.data.title}
                </div>
                <div className="Notice-inquire-card-data-class">
                  {dividedate(getData?.data.periodFrom)}~
                  {dividedate(getData?.data.periodTo)}
                </div>
              </div>
              <div className="Notice-inquire-card-info-class">
                <div className="Notice-inquire-card-writer-container">
                  <div className="Notice-inquire-card-writername-class">
                    관리자
                  </div>
                </div>
              </div>
              <div className="Notice-inquire-card-context-class">
                {getData?.data.contents}
              </div>
            </div>
          </div>
          <div className="Notice-inquire-footer-container">
            {getData?.data.requesterUserId ===
            sessionStorage.getItem("userId") ? (
              <div>
                <div className="Notice-inquire-footer-mypost">
                  <div
                    className="Notice-inquire-footer-delete"
                    onClick={deleteData}
                  >
                    삭제
                  </div>
                  <div className="Notice-inquire-footer-repost">수정</div>
                </div>
              </div>
            ) : null}

            <div className="Notice-inquire-footer-applicant">기부자</div>
          </div>
        </div>
        y
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

export default connect(mapStateToProps, mapDispatchToProps)(Notice_inquire);

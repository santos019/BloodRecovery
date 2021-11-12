import React, { useEffect, useState } from "react";
import "./Mypage_myboard.css";
import BRONZE from "../../Img/Grade/4_bronze.png";
import SIVER from "../../Img/Grade/3_silver.png";
import GOLD from "../../Img/Grade/2_gold.png";
import VIP from "../../Img/Grade/1_vip.png";
import BLOODDROP from "../../Img/DirectedIMG/blood-drop.png";
import Mypage_main from "./Mypage_main";
import { connect } from "react-redux";
import { addPage } from "../Modalmove/subscribers/action";
import axios from "axios";

const Mypage_myboard = () => {
  const [getData1, GetMyData1] = useState();
  const [getData2, GetMyData2] = useState();

  useEffect(() => {
    // 내가 쓴 헌혈증 기부 요청글 조회
    axios
      .get(
        "http://bloodrecovery-lb-1423483073.us-east-2.elb.amazonaws.com:8000/card/" +
          sessionStorage.getItem("userId")
      )

      .then(function (response) {
        GetMyData1(response);
        console.log("response", response);
      });
  }, []);

  // useEffect(() => {
  //   // 내가 쓴 지정헌혈 요청글 조회
  //   axios
  //     .get(
  //       "http://bloodrecovery-lb-1423483073.us-east-2.elb.amazonaws.com:8000/direct/" +
  //         sessionStorage.getItem("userId")
  //     )

  //     .then(function (response) {
  //       GetMyData2(response);
  //       // console.log("response1", response);
  //     });
  // }, []);

  const gradefunction = (Grade) => {
    if (Grade === 1)
      //BRONZE 예정
      return <img className="Mypage-img-userimg" src={BRONZE}></img>;
    else if (Grade === 2)
      //SIVER 예정
      return <img className="Mypage-img-userimg" src={SIVER}></img>;
    else if (Grade === 3)
      //GOLD 예정
      return <img className="Mypage-img-userimg" src={GOLD}></img>;
    //레벨4 VIP
    else return <img className="Mypage-img-userimg" src={VIP}></img>;
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

  function clickevent() {
    sessionStorage.setItem("Id", getData1?.data.id);
    // getData.addPage("헌혈증요청조회");
  }
  return (
    <div className="Mypage-myboard-container" onClick={clickevent}>
      <div className="Mypage-myboard-nav-container">
        <div className="Mypage-myboard-nav-usericon-class">
          {gradefunction(getData1?.data.level)}
        </div>
        <div className="Mypage-myboard-nav-username-class">
          {/* {getData1.data?.map()}
          <p>{getData1?.data.nickname}</p>
          {console.log(getData1?.nickname)} */}

          {/* {getData1?.data.map((mylist, index) => (
            <div className="Point-container">
              <div className="Point-plus">{getData1?.data[index].nickname}</div>
            </div>
          ))} */}
          {getData1?.data.nickname}
        </div>
        <div className="Mypage-myboard-nav-userstatus-container">
          <div className="Mypage-myboard-nav-userstatus-class">
            <img
              src={BLOODDROP}
              className="Mypage-myboard-nav-userstatus-icon"
            ></img>
            {getData1?.data.completeStatus == false ? (
              <p className="Mypage-myboard-nav-userstatus-p-class">
                {getData1?.data.donationCount}/{getData1?.data.requestCount}
              </p>
            ) : (
              <p className="Mypage-myboard-nav-userstatus-p-class2">완료</p>
            )}
            {/* {console.log(getData)} */}
            {/* {getData.getData?.donationCount}/{getData.getData?.requestCount} */}
          </div>
        </div>
      </div>
      <div className="Mypage-myboard-content-container">
        <p className="Mypage-myboard-content-class">{getData1?.data.title}</p>
      </div>
      <div className="Mypage-myboard-footer-container">
        <div className="Mypage-myboard-footer-date-container">
          <div className="Mypage-myboard-footer-date-class">
            <p className="Mypage-myboard-footer-date-p-class">
              {dividedate(getData1?.data.requestDate)}
            </p>
          </div>
        </div>

        {/* {console.log(getData.getData?.id)} */}
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
export default connect(mapStateToProps, mapDispatchToProps)(Mypage_myboard);

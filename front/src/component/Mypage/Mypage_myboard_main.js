import React, { useEffect, useState } from "react";
import "./Mypage_myboard_main.css";
import Mypage_main from "./Mypage_main";
import { connect } from "react-redux";
import { addPage } from "../Modalmove/subscribers/action";
import Menu_left_nav from "../Common/Header/Menu_left_nav";
import axios from "axios";
import CARDDONATION from "../../Img/CARDDONATION.png";
import Mypage_card from "./Mypage_myboard_main_card";

const Mypage_myboard = (props) => {
  // const [getData1, GetMyData1] = useState();
  // const [getData2, GetMyData2] = useState();
  const [getData, setGetdata] = useState([]);

  const getsetValue2 = (getData) => {
    // console.log("헌혈증기부", getData);
    props.getsetValue2(getData);
  };

  useEffect(() => {
    // 내가 쓴 헌혈증 기부 요청글 조회
    axios
      .get(
        "http://bloodrecovery-lb-1423483073.us-east-2.elb.amazonaws.com:8000/card/" +
          sessionStorage.getItem("userId")
      )

      .then(function (response) {
        setGetdata(response.data);
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

  // const gradefunction = (Grade) => {
  //   if (Grade === 1)
  //     //BRONZE 예정
  //     return <img className="Mypage-img-userimg" src={BRONZE}></img>;
  //   else if (Grade === 2)
  //     //SIVER 예정
  //     return <img className="Mypage-img-userimg" src={SIVER}></img>;
  //   else if (Grade === 3)
  //     //GOLD 예정
  //     return <img className="Mypage-img-userimg" src={GOLD}></img>;
  //   //레벨4 VIP
  //   else return <img className="Mypage-img-userimg" src={VIP}></img>;
  // };
  // //날짜 T이후로 쪼개는거
  // const dividedate = (inputdate) => {
  //   var redate = "";
  //   for (var i in inputdate) {
  //     if (inputdate[i] == "T") break;

  //     redate = redate + inputdate[i];
  //   }
  //   return redate;
  // };

  // function clickevent() {
  //   sessionStorage.setItem("Id", getData1?.data.id);
  //   // getData.addPage("헌혈증요청조회");
  // }

  return (
    <div className="Mypage-main-container">
      <div className="Mypage-main-nav-container">
        <div className="Mypage-main-nav-class">
          <Menu_left_nav
            name={"마이페이지"}
            imgname={CARDDONATION}
          ></Menu_left_nav>
        </div>
      </div>
      <div className="Mypage-main-cardmain-container">
        {getData.map((menu, index) => (
          <Mypage_card
            getData={getData[index]}
            key={index}
            getsetValue3={getsetValue2}
          >
            {console.log("index", index)}
          </Mypage_card>
        ))}
        {/* {console.log(getData)} */}
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

import React, { useState, useEffect } from "react";
import Menu_left_nav from "../Common/Header/Menu_left_nav";
import "./Board_main.css";
import Board_nav from "./Board_nav";
import Board_card from "./Board_card";
import { connect } from "react-redux";
import { addPage } from "../../component/Modalmove/subscribers/action";
import axios from "axios";
import CARDDONATION from "../../Img/CARDDONATION.png";
import SEARCHICON from "../../Img/searchicon.png";
import WRITEICON from "../../Img/WRITE.png";
import { getDefaultLocale } from "react-datepicker";

const SelectBox = () => {
  return (
    <select>
      <option key="ing" value="ing">
        진행중
      </option>
      <option key="end" value="end">
        진행완료
      </option>
    </select>
  );
};

const Board_main = (props) => {
  const [getData, setGetdata] = useState([]);

  const getsetValue2 = (getData) => {
    // console.log("헌혈증기부", getData);
    props.getsetValue2(getData);
  };
  const getsetValue3 = () => {
    // console.log("헌혈증기부 조회 백");
    props.getsetValue3();
  };

  useEffect(() => {
    axios
      .get(
        // "http://bloodrecovery-lb-1423483073.us-east-2.elb.amazonaws.com:8000/card/requests"
        "http://localhost:8003"
      )
      // "id": 1,
      // "userId": "아이디2",
      // "nickname": "닉네임2",
      // "level": 1,
      // "point": 200,
      // "title": "제목11133",
      // "contents": "내용",
      // "image": "https://bloodrecovery.s3.us-east-2.amazonaws.com/direct/97883a2f-dafa-4dc5-9875-1a4a450cd45b.jpg",
      // "requestCount": 5,
      // "donationCount": 1,
      // "requestDate": "2021-10-26",
      // "completeStatus": false,
      .then(function (response) {
        setGetdata(response.data);
        newdata();
        // console.log("response", response);
      });
  }, []);

  const newdata = () => {
    for (var i = 0; i < getData.length; i++) {
      for (var key in getData[i].length) {
        getData[i][i] = 0;
      }
    }
  };

  const movepage = (text) => {};

  return (
    <div className="Board-main-container">
      <div className="Board-main-nav-container">
        <div className="Board-main-nav-class">
          <Menu_left_nav
            name={"헌혈증 기부"}
            imgname={CARDDONATION}
          ></Menu_left_nav>
        </div>

        <div className="Board-main-nav-select-class">
          <SelectBox></SelectBox>
        </div>
        <div className="Board-main-nav-write-class">
          <img
            src={WRITEICON}
            onClick={() =>
              sessionStorage.getItem("userId") !== null
                ? props.addPage("헌혈증_글쓰기")
                : alert("로그인을 해주세요")
            }
            className="Board-main-nav-writeicon-class"
          ></img>
        </div>
      </div>
      <div className="Board-main-cardmain-container">
        {getData.map((menu, index) => (
          <Board_card
            getData={getData[index]}
            key={index}
            getsetValue3={getsetValue2}
          >
            {console.log("index", index)}
          </Board_card>
        ))}
        {console.log(getData)}
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

export default connect(mapStateToProps, mapDispatchToProps)(Board_main);

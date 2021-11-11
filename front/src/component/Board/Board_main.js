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

const Board_main = (props) => {
  var key1;
  let form = new FormData();
  var arrNumber = new Array();
  const [getSi, setGetSi] = useState("전체");
  const [getData, setGetdata] = useState([]);
  const [selectStatus, setSelectStatus] = useState(false);
  const [frStatus, setfrStatus] = useState("진행중");
  const [inputs, setInputs] = useState({
    direct_main_bloodtype: "",
  });

  const SelectBox = () => {
    return (
      <select value={frStatus} onChange={handleChange}>
        <option key="진행중" value="진행중">
          진행중
        </option>
        <option key="진행완료" value="진행완료">
          진행완료
        </option>
      </select>
    );
  };

  const handleChange = (e) => {
    setfrStatus(e.target.value);
    if (e.target.value === "진행중") {
      setSelectStatus(false);
    } else if (e.target.value === "진행완료") {
      setSelectStatus(true);
    }
  };
  const onChange = (e) => {
    const { name, value } = e.target;
    const nextInputs = {
      //스프레드 문법으로 기존의 객체를 복사한다.
      ...inputs,
      [name]: value,
    };
    //만든 변수를 seInput으로 변경해준다.
    setInputs(nextInputs);

    // console.log(inputs);
  };

  const getsetValue2 = (getData) => {
    // console.log("헌혈증기부", getData);
    props.getsetValue2(getData);
  };
  // const getsetValue3 = () => {
  //   // console.log("헌혈증기부 조회 백");
  //   props.getsetValue3();
  // };

  useEffect(() => {
    if (inputs.direct_main_bloodtype === "") {
      if (getSi === "전체") {
        axios
          .get("http://localhost:8003?status=" + selectStatus) //status상태만붙여주고
          .then(function (response) {
            setGetdata(response.data);

            console.log("1번케이스", response);
          });
      } else {
        axios
          .get("http://localhost:8003?status=") //status상태만붙여주고, 시도 붙여주기
          .then(function (response) {
            setGetdata(response.data);

            console.log("2번케이스", response);
          });
      }
    }
  }, [selectStatus]);

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

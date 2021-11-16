import React, { useEffect, useState, useRef } from "react";
import axios from "axios";
import "./Change_info.css";
import BRONZE from "../../Img/Grade/4_bronze.png";
import SIVER from "../../Img/Grade/3_silver.png";
import GOLD from "../../Img/Grade/2_gold.png";
import VIP from "../../Img/Grade/1_vip.png";
import POINTICON from "../../Img/point.png";
import Menu_left_nav from "../Common/Header/Menu_left_nav";
// import { addPage } from "../Modalmove/subscribers/action";
// import { connect } from "react-redux";
import GOBACKBTN from "../../Img/DirectedIMG/arrow.png";
import { connect, ReactReduxContext } from "react-redux";
import { addPage } from "../../component/Modalmove/subscribers/action";

import BLOODICON from "../../Img/광기1.png";
import BLOODGIF from "../../Img/광기움짤.gif";
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

function Change_info(props, getData) {
  const [user, setUser] = useState();
  useEffect(() => {
    axios
      .get(
        "http://bloodrecovery-lb-1423483073.us-east-2.elb.amazonaws.com:8000/user/info/" +
          sessionStorage.getItem("userId")
      )
      .then(function (response) {
        setUser(response.data);
        console.log("rr", sessionStorage.getItem("userId"));
      });
  }, []);

  function movepage(text) {
    props.addPage(text);
  }

  // function () {
  return (
    <div className="Mypage-main-container-class">
      <div className="Mypage-main-class">
        <div className="Mypage-main-Header-container-class">
          {/* {console.log(props.index)} */}
          <Menu_left_nav
            name={"내정보수정"}
            imgname={BLOODICON}
            // imgname={BLOODGIF}
          ></Menu_left_nav>
        </div>
      </div>
      <div className="Mypage-main-nav-container"></div>
      <div className="Mypage-main-profile">
        <img className="Mypage-main-profileimg" src={user?.profile}></img>
      </div>

      <div className="Mypage-usericon-class">
        {gradefunction(getData.getData?.requesterLevel)}
      </div>
      <div className="Mypage-main-nickname">{user?.nickname}</div>
      <div className="Mypage-main-nav2"></div>
      <div className="Mypage-main-username">{user?.name}</div>
      <div className="Mypage-main-userid">{user?.userId}</div>
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

export default connect(mapStateToProps, mapDispatchToProps)(Change_info);

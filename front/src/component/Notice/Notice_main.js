import React, { useState, useEffect } from "react";
import Menu_left_nav from "../Common/Header/Menu_left_nav";
import "./Notice_main.css";
import axios from "axios";
import SEARCHICON from "../../Img/searchicon.png";
import WRITEICON from "../../Img/WRITE.png";
// import NOTICEIMG from "../../Img/NOTICEIMG.png";

import Notice_card from "./Notice_card";

function Notice_main() {
  var i = true;
  const [btn, setbtn] = useState(false);
  const [setData, setGetdata] = useState([]);
  const onClick = () => {
    i = !i;
    console.log("작동" + i);
  };

  useEffect(() => {
    axios
      .get(
        "http://BloodRecovery-LB-1423483073.us-east-2.elb.amazonaws.com:8000/notice"
      )

      .then(function (response) {
        setGetdata(response.data);

        // console.log("response", setData);
      });
  }, [setData]);

  return (
    <div className="Notice-main-container">
      <div className="Notice-main-nav-container">
        <div className="Notice-main-nav-class">
          <Menu_left_nav name={"공지사항"}></Menu_left_nav>

          {/* {console.log("ge", getData[0]?.id)} */}
        </div>

        <div className="Notice-main-nav-search-class">
          <div className="Notice-main-nav-write-class">
            <img
              src={WRITEICON}
              // onClick={() => props.addPage("공지사항_글쓰기")}
              className="Notice-main-nav-writeicon-class"
            ></img>
          </div>
        </div>
      </div>
      <div className="Notice-main-cardmain-container">
        {/* <Notice_card getData={getData}></Notice_card> */}
        {/* {getData.map((menu)=>(menu.requesterId))
                } */}
        {setData.map((menu, index) => (
          <Notice_card setData={setData[index]} key={index}>
            {/* {console.log("index", index)} */}
          </Notice_card>
        ))}
        {/* {console.log(getData)} */}
      </div>
    </div>
  );
}

export default Notice_main;

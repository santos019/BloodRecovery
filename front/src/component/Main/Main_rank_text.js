import React, { useState, useEffect } from "react";
import "./Main_rank_text.css";
import axios from "axios";
const Main_rank_text = (props) => {
  const [myRank, setMyRank] = useState([]);
  useEffect(() => {
    axios
      .get(
        "http://bloodrecovery-lb-1423483073.us-east-2.elb.amazonaws.com:8000/rank/rankings/" +
          sessionStorage.getItem("userId")
      )
      .then(function (response) {
        setMyRank(response.data);
      });
  }, []);

  return (
    <div className="Main-rank-text-text-class">
      <div className="Main-rank-text-p-class">
        "현재 {myRank.nickname}님의 순위는 {myRank.userRank}위입니다"
        {/* {console.log(myRank)} */}
      </div>
    </div>
  );
};

export default Main_rank_text;

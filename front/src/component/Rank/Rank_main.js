import React, { useState, useEffect } from "react";
import Menu_nav_text from "../Common/Header/Menu_nav_text";
import axios from "axios";
import "./Rank_main.css";

function Rank_main() {
  const [ranks, setRanks] = useState([]);
  useEffect(() => {
    axios.get("http://localhost:8000/rankings").then(function (response) {
      setRanks(response.data);
      // console.log("rr" + response.data[0]["id"]);
    });
  }, []);

  return (
    <div>
      <Menu_nav_text name={"랭킹"}></Menu_nav_text>

      <div className="rank_my">
        "nickname님의 포인트는 point점입니다. 현재 랭킹은 userRank위 입니다!"
      </div>
      <div className="rank_all">
        {ranks.map((rank) => (
          <div>
            {rank.userRank} {rank.userNickname} {rank.userPoint}
          </div>
        ))}
      </div>
      <div className="rank_bottom">
        <p>매월 1일 00시 정각 기준 랭킹 1위에게는 소정의 상품이 증정됩니다!</p>
        <p>랭킹은 매시간 마다 갱신됩니다.</p>
      </div>
    </div>
  );
}

export default Rank_main;

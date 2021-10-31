import React from "react";
import Menu_nav_text from "../Common/Menu_nav_text";
import axios from "axios";
function Rank_main() {
  axios({
    method: "GET",
    url: "/rankings",
    // data: {
    //   //   id: id.value,
    //   //   userId: userId.value,
    //   //   userNickname: userNickname.value,
    //   //   userProfile: userProfile.value,
    //   //   userPoint: userPoint.value,
    // },
  })
    .then((res) => {
      console.log(res);
    })
    .catch((error) => {
      console.log(error);
    });

  return (
    <div>
      <Menu_nav_text name={"랭킹"}></Menu_nav_text>
    </div>
  );
}

export default Rank_main;

import React, { useState, useEffect} from 'react';
import './Main_rank_text.css'
import axios
 from 'axios';
const Main_rank_text=(props)=>
{
    const [myRank, setMyRank] = useState([]);
    useEffect(() => {
      axios
        .get(
          "http://ec2-18-219-208-124.us-east-2.compute.amazonaws.com:8000/rank/rankings/" +
            sessionStorage.getItem("userId")
        )
        .then(function (response) {
          setMyRank(response.data);
        });
    }, []);
   

    return(
        <div className="Main-rank-text-text-class">
            <div className="Main-rank-text-p-class">
                "현재 {myRank.nickname}님의 순위는 {myRank.userRank}위입니다"
                {/* {console.log(myRank)} */}
            </div>
        </div>
    )

    
}

export default Main_rank_text;
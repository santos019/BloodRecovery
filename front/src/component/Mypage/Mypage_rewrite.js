import React, { useState, useEffect } from "react";
import CARDDONATION from "../../Img/CARDDONATION.png";
import GOBACKBTN from "../../Img/DirectedIMG/arrow.png";
import Menu_left_nav from "../Common/Header/Menu_left_nav";
import { connect } from "react-redux";
import { addPage } from "../../component/Modalmove/subscribers/action";
import S3Upload from "../Common/Function/S3fileUpload";
import "./Mypage_rewrite.css";
import BLOODDROP from "../../Img/DirectedIMG/blood-drop.png";
import Common_Button_IMG from "../../component/Common/Button/Common_Button_IMG";
import WRITEWHITEIMG from "../../Img/DirectedIMG/WRITE_WHITE.png";
import axios from "axios";

function Mypage_write(props) {
  // const [startDate, setStartDate] = useState();
  // const [endDate, setendDate] = useState(new Date());
  //헌혈증받는변수
  const [restatus, setRestatus] = useState(false);
  // const [getData, setGetData] = useState();
  const [getIMG, setIMG] = useState(null);
  // const [titlecheck,setTitleCheck]=useState(false)
  // const [contextcheck,setContextCheck]=useState(false)
  // const [bloodtypecheck,setBloodCheck]=useState(false)
  // const [signal,setSignal]=useState(false)
  //   const [inputs, setInputs] = useState({
  //     direct_title: "",
  //     direct_context: "",
  //   });

  //   useEffect(() => {
  //     axios
  //       .get(
  //         "http://bloodrecovery-lb-1423483073.us-east-2.elb.amazonaws.com:8000/card/requests/" +
  //           // "http://localhost:8003/requests/"
  //           sessionStorage.getItem("MypageId")
  //       )

  //       .then(function (response) {
  //         // console.log(response);
  //         const firstinputs = {
  //           request_context: response.data.contents,
  //           request_title: response.data.title,
  //         };
  //         setInputs(firstinputs);
  //         setIMG(response.data.img);
  //         // setStartDate(response.data.periodFrom)
  //       });
  //   }, []);

  // 나의 정보 불러오기
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

  const onChange = (e) => {
    const { name, value } = e.target;
    const nextInputs = {
      //스프레드 문법으로 기존의 객체를 복사한다.
      ...inputs,
      [name]: value,
    };
    //만든 변수를 seInput으로 변경해준다.
    setInputs(nextInputs);
    console.log(inputs);
  };

  // function changeFormat(date, format) {
  //   if (moment(date).isValid()) {
  //     return moment(date).format(format);
  //   } else {
  //     return null;
  //   }
  // }

  const senddata = () => {
    axios
      .put(
        "http://bloodrecovery-lb-1423483073.us-east-2.elb.amazonaws.com:8000/user/info/" +
          sessionStorage.getItem("userId"),
        {
          nickname: inputs.nickname,
          profile: getIMG,
        }
      )
      .then(function (response) {
        console.log(response);
      });
    alert("개인정보가 수정되었습니다.");
  };

  const getfilename = (value) => {
    // console.log("wow",value)
    setIMG(value);
  };
  return (
    <div className="Mypage-rewrite-container">
      {/* {console.log("rewrite", inputs)} */}
      <div className="Mypage-rewrite-nav-container">
        <div className="Mypage-rewrite-nav-class">
          <Menu_left_nav
            name={"마이페이지 수정"}
            imgname={CARDDONATION}
          ></Menu_left_nav>
        </div>
        <div className="Mypage-rewrite-nav-goback">
          <img
            className="Mypage-rewrite-goback-bntimg-class"
            onClick={() => props.addPage("마이페이지")}
            src={GOBACKBTN}
          ></img>
        </div>
      </div>
      <div className="Mypage-rewrite-content-container">
        <div className="Mypage-rewrite-content-class">
          <div className="Mypage-rewrite-card-class">
            <div className="Mypage-rewrite-card-total">
              <div className="Mypage-rewrite-card-nav-class">
                <input
                  name="request_title"
                  className="Mypage-rewrite-card-title-class"
                  value={inputs.nickname}
                  onChange={onChange}
                ></input>
              </div>

              {/* <div className="Mypage-rewrite-card-context-class">
                <textarea
                  name="request_context"
                  className="Mypage-rewrite-card-context-input"
                  value={inputs.request_context}
                  onChange={onChange}
                ></textarea>
              </div> */}
              <div className="Mypage-rewrite-card-footer-class"></div>
            </div>
          </div>
          <div className="Mypage-rewrite-footer-container">
            <div className="Mypage-rewrite-footer-upload-container">
              <div className="Mypage-rewrite-footer-upload">
                <S3Upload getfilename={getfilename} />
              </div>
            </div>
            <div className="Mypage-rewrite-btn-container">
              <div className="Mypage-rewrite-btn-class" onClick={senddata}>
                <Common_Button_IMG
                  name={"수정완료"}
                  imgname={WRITEWHITEIMG}
                ></Common_Button_IMG>
              </div>
            </div>
          </div>
        </div>
      </div>
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

export default connect(mapStateToProps, mapDispatchToProps)(Mypage_write);

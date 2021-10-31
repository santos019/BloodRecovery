import "./App.css";
import ReactModal from "react-modal";
import { BrowserRouter, Link, Route, Switch } from "react-router-dom";
import Main_title_text from "./component/Main/Main_title_text.js";
import Main_rank from "./component/Main/Main_rank.js";
import React, { useState, useEffect } from "react";
import Test1 from "./component/Main/Test1";
import UseLocalHook from "./component/Common/UseLocalHook";
import Main_Button from "./component/Common/Button/Main_Button";
import Board_main from "./component/Board/Board_main";
import Directed_main from "./component/Directed/Directed_main";
import Notice_main from "./component/Notice/Notice_main";
import Bloodhouse_main from "./component/Bloodhouse/Bloodhouse_main";
import Login_main from "./component/Login/Login_main";
import Join_main from "./component/Join/Join_main";
import Rank_main from "./component/Rank/Rank_main";
import Main_base from "./component/Main/Main_base";
var modal = "";
var text = "";
function App() {
  const modal_style = {
    overlay: {
      position: "fixed",
      top: 0,
      bottom: 0,
      left: 0,
      right: 0,
      backgroundColor: "rgba(0, 0, 0,0 )",
    },
    content: {
      left: 200,
      right: 200,
      top: 100,
      bottom: 100,
      zIndex: 0,
    },
  };
  //랭킹으로 이동하게 만드는 함수
  const [getValue, setValue] = useState("랭킹");
  const getsetValue = (text) => {
    setValue(text);
  };
  //새로고침해도 모달창이 안꺼지도록 하는 함수
  const [modalIsOpen, setModalIsOpen] = UseLocalHook("true", false);
  //새로고침해도 모달창에서 불러온 컴포넌트가 안꺼지게 하는 함수
  const [modal, setmodal] = useState(
    () => JSON.parse(window.localStorage.getItem("modal")) || 0
  );

  useEffect(() => {
    window.localStorage.setItem("modal", JSON.stringify(modal));
  }, [modal]);

  return (
    <div className="App">
      <Main_base></Main_base>
      {/* <div className="Main_nav_class" onClick={() => setModalIsOpen(true)}>
        <div className="Main_nav_login_class" onClick={() => setmodal("로그인")}>
          <Main_Button name={"로그인"} ></Main_Button>
        </div>

        <div className="Main_nav_join_class" onClick={() => setmodal("회원가입")}>
          <Main_Button name={"회원가입"} ></Main_Button>
          
        </div>
      </div>


      <Main_title_text></Main_title_text> */}

      {/* <Main_list></Main_list> */}

      <BrowserRouter>
        {/* <div className="Main_list_class" onClick={() => setModalIsOpen(true)}>
          {/* <div onClick={() => setmodal(getValue)}>
            <Main_rank value={text} getsetValue={getsetValue}></Main_rank>
            {/* {console.log("value"+getValue)} 
          </div> 
          <div onClick={() => setmodal("헌혈증_기부")}>
            <Main_Button name={"헌혈증 기부"} ></Main_Button>
          </div>

          <div onClick={() => setmodal("지정헌혈")}>
            <Main_Button name={"지정헌혈"} ></Main_Button>
          </div>
          <div onClick={() => setmodal("지헌혈의_집_예약")}>
            <Main_Button name={"헌혈의 집 예약"} ></Main_Button>
          </div>

          <div onClick={() => setmodal("공지사항")}>
            <Main_Button name={"공지사항"} ></Main_Button>
          </div>

        </div> */}

        <Switch>
          <Route exact path="/test1" component={Test1} />
          <Route exact path="/board" component={Board_main} />
          <Route exact path="/directed" component={Directed_main} />
          <Route exact path="/notice" component={Notice_main} />

          <Route exact path="/ranking" component={Rank_main} />

      
          <Route exact path="/join" component={Join_main}/>




          {/* <ReactModal style={modal_style} isOpen={modalIsOpen} onRequestClose={() => setModalIsOpen(false)}>
            <Link to="/">

            </Link>

            {{
              헌혈증_기부: <Board_main></Board_main>,
              지정헌혈: <Directed_main></Directed_main>,
              지헌혈의_집_예약: <Bloodhouse_main></Bloodhouse_main>,
              공지사항: <Notice_main></Notice_main>,
              로그인: <Login_main></Login_main>,
              회원가입: <Join_main></Join_main>,
              랭킹: <Rank_main></Rank_main>,

            }[modal]
            }




          </ReactModal> */}
        </Switch>
      </BrowserRouter>
    </div>
  );
}

export default App;

import React, { useState, useEffect } from 'react';
import './Login_main.css';
import Menu_left_nav from "../Common/Header/Menu_left_nav";
import IDIMG from '../../Img/login.png';
import PASSIMG from '../../Img/password.png';
import blood from '../../Img/blood.png';
import axios from "axios";

const Login_main=(props)=>{

  const [loginId, setLoginid] = useState("");
  const [loginPassword, setLoginPassword] = useState("");
  //{sessionStorage.setItem("domain", "webisfresse.com")}
  //{sessionStorage.getItem("domain")}

  const [inputs, setInputs] = useState({

    // loin_id:'',
    // loin_password:''
  })


  const sendValue=(text)=>{
    props.loginsuccess(text);
}
  const onSendClick = () => {


    console.log("id", loginId, "password", loginPassword);
    console.log(inputs);
    axios
      .post("http://bloodrecovery-lb-1423483073.us-east-2.elb.amazonaws.com:8000/user/login", JSON.stringify(inputs), {
        headers: {
          "Content-Type": `application/json`,
        },
      })
      .then(function (res) {

        console.log(res.data.result);

        if (res.data.result === true) {
          alert("로그인성공")
          sessionStorage.setItem("userId",loginId)
          console.log(sessionStorage.getItem("userId"))
          sendValue("성공")

        }
        else if (res.data.result === false) {
          alert("로그인 실패")
        }

      });


  }

  const onChange = (e) => {
    const { name, value } = e.target
    const nextInputs = {
      //스프레드 문법으로 기존의 객체를 복사한다.
      ...inputs,
      [name]: value,
    }
    //만든 변수를 seInput으로 변경해준다.
    setInputs(nextInputs)

    console.log(inputs)
    if (name === "id") {

      setLoginid(e.target.value)
    }
    else if (name === "password") {

      setLoginPassword(e.target.value)
    }

  }

  // useEffect(()=>{
  //   let data = {
  //     "id": "chungil987",
  //     "password": "1234"
  // }
  // axios
  // .post("http://ec2-18-219-208-124.us-east-2.compute.amazonaws.com:8000/user/login",  JSON.stringify(inputs), {
  //   headers: {
  //     "Content-Type": `application/json`,
  //   },
  // })
  // .then((res) => {
  //   console.log(res);
  // });


  // },[])


  return (
    <div className="Login-main-class">
      <div className="Login-main-container-class">
        <Menu_left_nav name={"로그인"} imgname={blood}></Menu_left_nav>

      </div>
      <div className="Login-main-input-container-class">
        <div className="Login-main-input-id-class">
          <img className="Login-main-idimg-class" src={IDIMG} />

          <input className="Login-main-input-box-class" type="text" name="id" onChange={onChange} >
          </input>
        </div>
        <div className="Login-main-input-password-class">
          <img className="Login-main-idimg-class" src={PASSIMG} />
          <input type="text" className="Login-main-input-box-class" name="password" onChange={onChange}>
          </input>
        </div>
      </div>
      <div className="Login-main-btn-container-class">
        <div className="Login-main-btn-class">
          <div className="Login-Common-Button-class" onClick={onSendClick}>
            <div className="Login-Common-Button-text-class">로그인</div>
          </div>
        </div>
      </div>
      <div className="Login-main-find-container">
        <div className="Login-main-find-class">
          아이디 찾기 / 비밀 번호
        </div>

      </div>
      <div className="Login-main-joinbtn-container">
        <div className="Login-Common-joinbtn-class">
          <div className="Login-Common-joinbtn-text-class">회원가입</div>
        </div>
      </div>

    </div>

  );
}

export default Login_main;
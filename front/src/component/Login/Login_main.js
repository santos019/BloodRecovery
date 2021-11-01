import React, { useState } from 'react';
import './Login_main.css';
import Menu_left_nav from "../Common/Header/Menu_left_nav";
import IDIMG from '../../Img/login.png';
import PASSIMG from '../../Img/password.png';
import blood from '../../Img/blood.png';
function Login_main() {


  return (
    <div className="Login-main-class">
      <div className="Login-main-container-class">
        <Menu_left_nav name={"로그인"} imgname={blood}></Menu_left_nav>
      </div>
      <div className="Login-main-input-container-class">
        <div className="Login-main-input-id-class">
          <img className="Login-main-idimg-class" src={IDIMG}/>
     
          <input className="Login-main-input-box-class" type="text" name="Login_id" >
          </input>
        </div>
        <div className="Login-main-input-password-class">
        <img className="Login-main-idimg-class" src={PASSIMG}/>
          <input type="text" className="Login-main-input-box-class" name="Login_id" >
          </input>
        </div>
      </div>
      <div className="Login-main-btn-container-class">
        <div className="Login-main-btn-class">
        <div className="Login-Common-Button-class">
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
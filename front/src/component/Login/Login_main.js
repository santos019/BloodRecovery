import React, { useState } from 'react';
import './Login_main.css';
import Menu_nav_text from "../Common/Header/Menu_nav_text";
function Login_main() {


  return (
    <div className="Login-main-class">
      <div className="Login-main-container-class">
        <Menu_nav_text name={"로그인"}></Menu_nav_text>
      </div>
      <div className="Login-main-input-container-class">
        <div className="Login-main-input-id-class">
          <input type="text" name="Login_id" >

          </input>
        </div>
        <div className="Login-main-input-password-class">

        </div>

      </div>
      <div className="Login-main-input-btn-class">

      </div>

    </div>

  );
}

export default Login_main;
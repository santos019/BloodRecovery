import React from "react";
import './Login_find.css';
import Menu_left_nav from "../Common/Header/Menu_left_nav";
import blood from '../../Img/blood.png';
function Login_find() {


    return (

        <div className="Login-find-container">

            <div className="Login-find-id-container">
                <div className="Login-find-margin">
                <div className="Login-find-id-header">
                    <Menu_left_nav name={"아이디 찾기"} imgname={blood} />
                </div>
            </div>
            </div>
            <div className="Login-find-password-container">
            <div className="Login-find-margin">
                <div className="Login-find-password-header">
                    <Menu_left_nav name={"비밀번호 찾기"} imgname={blood} />
                </div>
            </div>
            </div>

        </div>
    )

}

export default Login_find;
import React from "react";
import "./Header_nav.css";
const Header_nav=(props)=>{


    const sendValue=(text)=>{
                 props.getsetValue(text);
             }
    const logout=()=>{
        sessionStorage.clear();
        props.logoutsuccess()

    }
    return (

        <div className="Header-nav-class">
            <div className="Header-nav-list-class">
                <div className="Header-nav-Login-class" onClick={logout}>
                    로그아웃
                </div>
                <div className="Header-nav-Join-class" onClick={()=>sendValue("회원가입")}>
                    마이페이지
                </div>
            </div>
        </div>

    )

}

export default Header_nav;
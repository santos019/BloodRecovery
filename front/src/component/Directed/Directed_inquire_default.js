import React, { useEffect, useState } from "react";
import DIRECTED_BUTTON_IMG from "../../Img/DirectedIMG/DIRECTEDIMGWHITE.png";
import Common_Button_IMG from "../Common/Button/Common_Button_IMG";
import Directed_inquire_default_data from "./Directed_inquire_default_dats";
import axios from "axios";
import './Directed_inquire_default.css';
const Directed_inquire_default = (id) => {

//신청하는api
    const beaApplicant = () => {
        if (sessionStorage.getItem("userId") == null) {
            alert("로그인해주세요")
        }
        else {
            axios
            .post("http://bloodrecovery-lb-1423483073.us-east-2.elb.amazonaws.com:8000/direct/directedItem/" + sessionStorage.getItem("directId")+"/applicant",{applicantIdentify:sessionStorage.getItem("userId")})

            .then(function (response) {

                console.log("신청하기", response)

            });

            id.getValue();
        }
   

    }
    return (
        
        <div className="Directed-inquire-default-footer-container">
              {/* {context===true?<Directed_inquire_default_data></Directed_inquire_default_data>:null} */}
            <div className="Directed-inquire-default-footer-btn-container">      
                <div className="Directed-inquire-default-footer-btn-class" onClick={beaApplicant}>
                    <Common_Button_IMG name={"신청하기"} imgname={DIRECTED_BUTTON_IMG}></Common_Button_IMG>
                </div>
            </div>
            <div className="Directed-inquire-default-footer-info1-class">
                신청 하기를 누르면 요청자의 상세 정보를 열람할 수 있습니다.
            </div>
            <div className="Directed-inquire-default-footer-info2-class">
                헌혈의 집을 이용한 지정 헌혈만 가능 합니다.
            </div>

        </div>

    )
}
export default Directed_inquire_default;
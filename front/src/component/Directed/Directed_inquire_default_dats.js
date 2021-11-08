import React,{useEffect, useState} from "react";
import "./Directed_inquire_default_data.css";
import Common_Button_IMG from "../Common/Button/Common_Button_IMG";
import DIRECTED_BUTTON_IMG from "../../Img/DirectedIMG/DIRECTEDIMGWHITE.png";
import axios from "axios";
const Directed_inquire_default_data=(id)=>{
const [getData,setGetData]=useState();
    useEffect(() => {
        axios
            .get("http://bloodrecovery-lb-1423483073.us-east-2.elb.amazonaws.com:8000/direct/directedItem/" + id.id.id+"/patient")

            .then(function (response) {

                setGetData(response);
                console.log("response", response)

            });

    }, []);

    return(
        <div className="Directed-inquire-default-data-container">
            <div className="Directed-inquire-default-class">
                <div className="Directed-inquire-default-data1">
                    지정헌혈 정보
                </div>
                <div className="Directed-inquire-default-data2">
                    환자 성명:{getData?.data.patientName}
                </div>
                <div className="Directed-inquire-default-data2">
                    의료기관명:{getData?.data.hospitalName}
                </div>
                <div className="Directed-inquire-default-data2">
                    병실호수:{getData?.data.roomNumber}
                </div>
            </div>
            <div className="Directed-inquire-default-btn-container">
                <div className="Directed-inquire-default-btn-class">
            <Common_Button_IMG name={"인증하기"} imgname={DIRECTED_BUTTON_IMG}></Common_Button_IMG>
            {console.log("tet",id.id.id)}
            </div>
            <div className="Directed-inquire-default-info-container">
                <div className="Directed-inqire-default-info">
                    요청 기간 이내에 지정헌혈 인증을 완료해주세요.
                </div>
            </div>
        </div>
        </div>
    )
}
export default Directed_inquire_default_data;
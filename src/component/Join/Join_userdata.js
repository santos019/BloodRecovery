import react from "react";
import './Join_userdata.css';
import Textbox from "../Common/Textbox/Textbox";
import Common_Button from "../Common/Button/Common_Button";
function Join_userdata() {


    return (

        <div className="Join-userdata-class">
            <div className="Join-usesrdata-nickname">
                <div className="Join-userdata-nickname-text-class">
                <Textbox name={"닉네임"}></Textbox>
                </div>
                <div className="Join-userdata-button-class">
                    <Common_Button name={"중복확인"}></Common_Button>
                </div>

            </div>
            
            <div className="Join-usesrdata-id-class">
            <div className="Join-userdata-nickname-text-class">
                <Textbox name={"아이디"}></Textbox>
                </div>
                <div className="Join-userdata-button-class">
                    <Common_Button name={"중복확인"}></Common_Button>
                </div>
            </div>
            <div className="Join-usesrdata-password">
                <Textbox name={"비밀번호"}></Textbox>
            </div>
            <div className="Join-usesrdata-passwordconfirm">
                <Textbox name={"비밀번호 확인"}></Textbox>
            </div>
            <div className="Join-usesrdata-name">
                <Textbox name={"성명"}></Textbox>
            </div>
            <div className="Join-usesrdata-resisternumber">
                <Textbox name={"주민등록번호"}></Textbox>
            </div>
            <div className="Join-userdata-button-class">
                    <Common_Button name={"인증"}></Common_Button>
                </div>

        </div>
    )
}

export default Join_userdata;
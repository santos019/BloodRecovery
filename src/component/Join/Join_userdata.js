import react, { useCallback, useState } from "react";
import './Join_userdata.css';
import Common_Button from "../Common/Button/Common_Button";
import * as ValueCheck_Null from "../Common/Function/ValueCheck_Null";
var idvalue;
var textvalue;
// function check1(text,textname){

//     if(ValueCheck_Null(text,textname)===true)
//     alert("완료");

//     return true;

// }
{/*
const Checkvalue = useCallback(
    
)(e) => {

    console.log(
        "dmdkdkdk" + text
    );
    if (text === "") {
        console.log(
            "공백"
        );
        alert("공백임");
    }

}
*/}

function Join_userdata() {
   

const [isNickname,setIsNickname]=useState(false)
const Checkvalue1=(textvalue)=>{
console.log(textvalue)
}
const Checkvalue=useCallback((textvalue)=>{
    setIsNickname(textvalue.target.value)
    console.log("0wkdltkd")
if(textvalue.target.value.length<1){
    alert("0자이상써주세요")
    
}
},[])
const [inputs, setInputs] = useState({  
    name: '',
    nickname: '',
})
const { name, nickname } = inputs   
const onChange=(e)=>{
    const { name, value } = e.target   
    const nextInputs = {            
        //스프레드 문법으로 기존의 객체를 복사한다.
                 ...inputs,  
                 [name]: value,
             }
        //만든 변수를 seInput으로 변경해준다.
             setInputs(inputs)  
            
}   
    return (

        <div className="Join-userdata-class">
            <div className="Join-usesrdata-nickname">
                <div className="Join-userdata-nickname-text-class">
                    <div className="Textbox">
                        <span className="Textbox-name-class" for="Textbox-class">닉네임</span>
                        <input type="text" name="nickname" value={nickname} onChange={onChange}className="Textbox-class">
                        </input>
                    </div>
                </div>
                <div className="Join-userdata-button-class" onClick={()=>{console.log(inputs)}}>
                    <Common_Button name={"중복확인"}></Common_Button>
                </div>
                <div className="Join-userdata-notice-class">
                    <p>영문, 한글, 숫자 '-' 포함 5~20자 이내</p>
                </div>

            </div>

            <div className="Join-usesrdata-id-class">
                <div className="Join-userdata-nickname-text-class">
                <div className="Textbox">
                        <span className="Textbox-name-class" for="Textbox-class">아이디</span>
                        <input type="text" value={textvalue} className="Textbox-class">
                        </input>
                        {console.log(textvalue)}
                    </div>  
                </div>
                <div className="Join-userdata-button-class" >
                    <Common_Button name={"중복확인"} ></Common_Button>
                </div>
            </div>
            <div className="Join-userdata-nickname-text-class">
            <div className="Textbox">
                        <span className="Textbox-name-class" for="Textbox-class">비밀번호</span>
                        <input type="text" value={textvalue} className="Textbox-class">
                        </input>
                    </div>
            </div>
            <div className="Join-userdata-nickname-text-class">
            <div className="Textbox">
                        <span className="Textbox-name-class" for="Textbox-class">비밀번호 확인</span>
                        <input type="text" value={textvalue} className="Textbox-class">
                        </input>
                    </div>
            </div>
            <div className="Join-userdata-nickname-text-class">
            <div className="Textbox">
                        <span className="Textbox-name-class" for="Textbox-class">성명</span>
                        <input type="text" value={textvalue} className="Textbox-class">
                        </input>
                    </div>
            </div>
            <div className="Join-userdata-nickname-text-class">
            <div className="Textbox">
                        <span className="Textbox-name-class" for="Textbox-class">주민등록번호</span>
                        <input type="text" value={textvalue} className="Textbox-class">
                        </input>
                    </div>
            </div>
            <div className="Join-userdata-button-class">
                <Common_Button name={"인증"}></Common_Button>
            </div>

        </div>
    )
}

export default Join_userdata;
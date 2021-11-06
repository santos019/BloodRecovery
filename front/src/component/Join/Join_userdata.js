import react, { useCallback, useState } from "react";
import './Join_userdata.css';
import Common_Button from "../Common/Button/Common_Button";
import axios from "axios";


const Join_userdata=(props)=>{
    
const [agreement,setAgreement]=useState(false)
const [nicknameCheck,setNicknameCheck]=useState(false)
const [idCheck,setIdCheck]=useState(false)
const [passwordCheck,setPasswordCheck]=useState(false)
const [passwordconfirmCheck,setPasswordconfirmCheck]=useState(false)
const [nameCheck,setNameCheck]=useState(false)
const [resister1Check,setResister1Check]=useState(false)
const [resister2Check,setResister2Check]=useState(false)
const [inputs, setInputs] = useState({  
    join_nickname: '',
    join_id:'',
    join_password:'',
    join_passwordconfirm:'',
    join_name:'',
    join_register1:'',
    join_register2:''
})
var nicknameEXP= /^[a-zA-Zㄱ-ㅎㅏ-ㅣ가-힣0-9_]{5,20}$/;
var idEXP=/^[a-zA-Z0-9_]{5,20}$/;
var passwordEXP=/^[a-zA-Z0-9~!@#$%^&*()_]{8,16}$/;
var nameEXP=/^[ㄱ-ㅎㅏ-ㅣ가-힣]{2,20}$/; 
var register1EXP=/^[0-9]{6}$/
var register2EXP=/^[0-9]{7}$/
const {join_nickname, join_id,join_password, join_passwordconfirm,join_name,join_register1,join_register2  } = inputs   
const join_agreement=false;
const sendValue=(text)=>{
    props.getsetValue(text);
}
const onChange1=(e)=>{

    setAgreement(!agreement)
}
const onChange=(e)=>{
    const { name, value } = e.target   
    const nextInputs = {            
        //스프레드 문법으로 기존의 객체를 복사한다.
                 ...inputs,  
                 [name]: value,
             }
        //만든 변수를 seInput으로 변경해준다.
             setInputs(nextInputs)  
            
             console.log(inputs)
             if(name==="join_nickname")
             {
                 console.log("닉네임유효성",nicknameEXP.test(e.target.value))
                 setNicknameCheck(nicknameEXP.test(e.target.value))
             }
            else if(name==="join_id")
             {
                // console.log("아이디 유효성",idEXP.test(e.target.value))
                // setIdCheck(idEXP.test(e.target.value))
             }
             else if(name==="join_password")
             {
                 console.log("비밀번호 유효성",passwordEXP.test(e.target.value))
                 setPasswordCheck(passwordEXP.test(e.target.value))

             }
             else if(name==="join_passwordconfirm")
             { console.log("비밀번호확인 유효성",join_password)
             //RegExp라는 형식이 따로있다.
                // const passwordconfirmEXP =new RegExp(join_password)
                 console.log("비밀번호확인 유효성",join_password===e.target.value)
                 setPasswordconfirmCheck((join_password===e.target.value))
             }
             else if(name==="join_name")
             {
                 console.log("이름 유효성",nameEXP.test(e.target.value))
                 setNameCheck(nameEXP.test(e.target.value))

             }
             else if(name==="join_register1")
             {
                 console.log("주민번호1 유효성",register1EXP.test(e.target.value))
                 setResister1Check(register1EXP.test(e.target.value))

             }
             else if(name==="join_register2")
             {
                 console.log("주민번호2 유효성",register2EXP.test(e.target.value))
                 setResister2Check(register2EXP.test(e.target.value))

             }
}   
const idoverlap=()=>{

    if(idEXP.test(join_id)==false)
    {
        console.log("아이디 양식에 맞춰 입력해주세요");
    }
    else if(idEXP.test(join_id)===true){

        axios.get("ec2-18-219-208-124.us-east-2.compute.amazonaws.com:8000/user/idCheck/"+join_id)
        .then(function(res){
            console.log(res)
        })

    }


    console.log("아이디 유효성",idEXP.test(join_id))
    setIdCheck(idEXP.test(join_id))
}

const valueCheck=()=>{
    var alert_blank=0;
// 1은 동의체크
// 2는 빈칸/유효성 체크
// 3은 닉네임 중복확인체크
// 4는 아이디 중복확인체크
// 5는 비밀번호 확인 체크
// 6은 성명과 주민등록번호 인증 체크
var personalNumber=join_register1+join_register2;
console.log(personalNumber);
    for(const key in inputs)//빈칸체크
    {
       //검증탈락
        if (inputs[key]==false)
        {
            //console.log(inputs[key]+"error");
            alert_blank=2;
            console.log("alert_blank11",inputs) 
            alert("양식을 바르게 입력해주세요")
            break;
        }
        
        // console.log([key] , inputs[key]);
        // console.log({key} , inputs[key]);
    }
    //무사히 검증이끝남
    if(alert_blank!=2)



    {   alert_blank=7;
        sendValue(alert_blank);
    }
    // if(alert_blank==2) alert("양식을 올바르게 입력해주세요")
    //     //else if() 나머지는 api와 연동한뒤구현예정
    // else{alert_blank=7;   
    //     console.log("ㅁㅁalert_blank"+alert_blank)    
    //     //sendValue(alert_blank);    
    //     setpersonalNumber(join_register1+join_register2)
    //     console.log("check",personalNumber)
    //     //axios.get("ec2-18-219-208-124.us-east-2.compute.amazonaws.com:8000/user/register")
    //     //.data()
    // }
    
 console.log(agreement,
    nicknameCheck,
    idCheck,
    passwordCheck,
    passwordconfirmCheck,
    nameCheck,
    resister1Check,
    resister2Check)
    alert_blank=0;
   
}
    return (

        <div className="Join-userdata-class">
             <div className="Join-checkbox-class">
            <input type="checkbox" name="join_agreement" onChange={onChange1} value={join_agreement}className="Join-checkbox-input-class"  id="Join-checkbox-checkbox-id">
            </input>
            <label className="Join-checkbox-text-class" for="Join-checkbox-checkbox-id">동의합니다</label>
        </div>
            <div className="Join-usesrdata-nickname">
                <div className="Join-userdata-nickname-text-class">
                    <div className="Textbox">
                        <span className="Textbox-name-class" for="Textbox-class">닉네임</span>
                        <input type="text" name="join_nickname" value={join_nickname} onChange={onChange}className="Textbox-class">
                        </input>
                    </div>
                </div>
                <div className="Join-userdata-button-class">
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
                        <input type="text" name="join_id" value={join_id} onChange={onChange} className="Textbox-class">
                        </input>
                    </div>  
                </div>
                <div className="Join-userdata-button-class" onClick={idoverlap} >
                    <Common_Button name={"중복확인"}  ></Common_Button>
                </div>
            </div>
            <div className="Join-userdata-nickname-text-class">
            <div className="Textbox">
                        <span className="Textbox-name-class" for="Textbox-class">비밀번호</span>
                        <input type="text" name="join_password" value={join_password} onChange={onChange} className="Textbox-class">
                        </input>
                    </div>
            </div>
            <div className="Join-userdata-nickname-text-class">
            <div className="Textbox">
                        <span className="Textbox-name-class" for="Textbox-class">비밀번호 확인</span>
                        <input type="text" name="join_passwordconfirm" value={join_passwordconfirm} onChange={onChange} className="Textbox-class">
                        </input>
                    </div>
            </div>
            <div className="Join-userdata-nickname-text-class">
            <div className="Textbox">
                        <span className="Textbox-name-class" for="Textbox-class">성명</span>
                        <input type="text" name="join_name" value={join_name} onChange={onChange} className="Textbox-class">
                        </input>
                    </div>
            </div>
            <div className="Join-userdata-nickname-text-class">
            <div className="Textbox">
                        <span className="Textbox-name-class" for="Textbox-class">주민등록번호</span>
                        <input type="text" maxlength='6' name="join_register1" value={join_register1} onChange={onChange} className="Textbox1-class">
                        </input> 
                        <p className="Join-userdata-register-p-class">-</p>
                        <input type="text" maxlength='7'name="join_register2" value={join_register2} onChange={onChange} className="Textbox1-class">
                            </input> 
                    </div>
            </div>
            <div className="Join-userdata-button-class">
                <Common_Button name={"인증"}></Common_Button>
            </div>
            <div className="Join-userdata-complete-btn-container-class">
            <div className="Join-userdata-complete-btn-class" onClick={valueCheck}> 
                <Common_Button name={"가입완료"}></Common_Button>

            </div>
            </div>

        </div>
    )
}

export default Join_userdata;

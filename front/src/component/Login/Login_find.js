import React,{useState} from "react";
import './Login_find.css';
import Menu_left_nav from "../Common/Header/Menu_left_nav";
import blood from '../../Img/blood.png';
import Common_Button from "../Common/Button/Common_Button";
import axios from "axios";
function Login_find() {
    const [check,setcheck]=useState(false)
    const [inputs, setInputs] = useState({
        find_name: '',
        find_personal:''
    })
    const [inputsPassword, setInputsPassword] = useState({
        findps_name: '',
        findps_personal:'',
        findps_id:'',
        findps_password:''
    })
   
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
 
    }   
    const onChange2=(e)=>{
        const { name, value } = e.target   
        const nextInputs2 = {            
            //스프레드 문법으로 기존의 객체를 복사한다.
                     ...inputsPassword,  
                     [name]: value,
                 }
            //만든 변수를 seInput으로 변경해준다.
            setInputsPassword(nextInputs2)  
                 
                 console.log(inputsPassword)
 
    }   
    const senddata=()=>{


        if(inputs.find_name===""){alert("성명을 입력해주세요")}
        else if(inputs.find_personal===""){alert("주민등록번호를 입력해주세요")}
        //else if(인증안했을떄)
        else{

            axios.post("http://bloodrecovery-lb-1423483073.us-east-2.elb.amazonaws.com:8000/user/idFind",{name:inputs.find_name,personalNumber:inputs.find_personal})
            .then(function(res){
                console.log("비밀번호",res)
                alert("찾으신 아이디는 "+res.data+" 입니다.")

            })
        }
    }
    const senddata1=()=>{
        var i =0;

        if(inputsPassword.findps_name===""){alert("성명을 입력해주세요")}
        else if(inputsPassword.findps_personal===""){alert("주민등록번호를 입력해주세요")}
        else if(inputsPassword.findps_id===""){alert("아이디를 입력해주세요")}
        //else if(인증안했을떄)
        else{

            axios.post("http://bloodrecovery-lb-1423483073.us-east-2.elb.amazonaws.com:8000/user/idFind",{name:inputsPassword.findps_name,personalNumber:inputsPassword.findps_personal})
            .then(function(res){
                console.log("다음단계",res)
                
                if(res.data===inputsPassword.findps_id){
                    axios.post("http://bloodrecovery-lb-1423483073.us-east-2.elb.amazonaws.com:8000/user/pwReset",{userId:inputsPassword.findps_id,password:inputs.findps_password})
                    .then(function(res){
                        console.log("ㅎㅎ",res)
                        alert("비밀번호가 변경되었습니다.")
                        
                    })

                }
                
            })
            
        }

        // if(check===true){
        //     console.log(i)
        //     axios.post("http://bloodrecovery-lb-1423483073.us-east-2.elb.amazonaws.com:8000/user/pwReset",{userId:inputsPassword.findps_id,password:inputs.findps_password})
        //     .then(function(res){
        //         console.log("ㅎㅎ",res)
        //         alert("비밀번호가 변경되었습니다.")
                
        //     })
        // }
        // else{alert("오류")}
    }

    return (

        <div className="Login-find-container">

            <div className="Login-find-id-container">
                <div className="Login-find-margin">
                    <div className="Login-find-header">
                        <Menu_left_nav name={"아이디 찾기"} imgname={blood} />
                    </div>
                    <div className="Login-find-context-id-container">
                        <div className="Login-find-context-row">
                            <div className="Login-find-context-name" >
                                성명
                            </div>
                            <input className="Login-find-input" name="find_name" onChange={onChange}></input>
                        </div>
                        <div className="Login-find-context-row">
                            <div className="Login-find-context-name">
                                주민등록번호
                            </div>

                            <input className="Login-find-input" name="find_personal" onChange={onChange}></input>
                            <div className="Login-find-register-class">
                                <div className="Login-find-register-name-class">
                                    인증
                                </div>
                            </div>
                        </div>
                    </div>
                    <div className="Login-find-btn-container">
                        <div className="Login-find-btn-class" onClick={senddata}> 
                            <Common_Button name={"아이디 찾기"} />
                        </div>
                    </div>
                </div>
            </div>
            <div className="Login-find-password-container">
                <div className="Login-find-margin1">
                    <div className="Login-find-header">
                        <Menu_left_nav name={"비밀번호 재설정"} imgname={blood} />
                    </div>
                    <div className="Login-find-context-id-container">
                        <div className="Login-find-context-row">
                            <div className="Login-find-context-name">
                                성명
                            </div>
                            <input className="Login-find2-input" name="findps_name" onChange={onChange2}></input>
                        </div>
                        <div className="Login-find-context-row">
                            <div className="Login-find-context-name">
                                주민등록번호
                            </div>

                            <input className="Login-find2-input" name="findps_personal" onChange={onChange2}></input>
                            <div className="Login-find-register-class">
                                <div className="Login-find-register-name-class">
                                    인증
                                </div>
                            </div>
                        </div>
                        <div className="Login-find-context-row">
                            <div className="Login-find-context-name">
                                아이디
                            </div>
                            <input className="Login-find2-input" name="findps_id" onChange={onChange2}></input>
                        </div>
                        <div className="Login-find-context-row">
                            <div className="Login-find-context-name">
                                재설정 비밀번호
                            </div>
                            <input className="Login-find2-input" name="findps_password" onChange={onChange2}></input>
                        </div>
                    </div>
                    <div className="Login-find-btn-container">
                        <div className="Login-find-btn-class" onClick={senddata1}>
                            <Common_Button name={"비밀번호 재설정"} />
                        </div>
                    </div>
                </div>
            </div>

        </div>
    )

}

export default Login_find;
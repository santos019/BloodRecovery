import React, { useState } from "react";
import DIRECTEDIMG from '../../Img/DIRECTEDIMG.png';
import GOBACKBTN from '../../Img/DirectedIMG/arrow.png';
import Menu_left_nav from '../Common/Header/Menu_left_nav';
import { connect } from 'react-redux'
import { addPage } from '../../component/Modalmove/subscribers/action'
import DataPicker from "react-datepicker";
import { ko } from 'date-fns/esm/locale';
import S3Upload from "../Common/Function/S3fileUpload";
import './Directed_write.css';
import BLOODDROP from '../../Img/DirectedIMG/blood-drop.png';
import LOCATIONIMG from '../../Img/DirectedIMG/location.png';
import Common_Button_IMG from '../../component/Common/Button/Common_Button_IMG';
import WRITEWHITEIMG from '../../Img/DirectedIMG/WRITE_WHITE.png';
import Directed_write_select from "./Directed_write_select";




function Directed_write(props) {
    const [startDate, setStartDate] = useState(new Date());
    const [endDate, setendDate] = useState(new Date());
    //헌혈증받는변수
    const [directCount, setDirectCount] = useState(0);
    const [getSido,setSido]=useState(1);
    const [getSigungu,setSigungu]=useState(1);


    const [inputs, setInputs] = useState({
        direct_title: '',
        direct_date1: '',//date형식으로
        direct_date2: '',//date형식으로
        direct_patient: '',
        direct_hospital: '',
        direct_room: ''
    })
    const { direct_title, direct_date1, direct_date2, direct_patient, direct_hospital, direct_room } = inputs

    // const onChange=(e)=>{
    //     const { name, value } = e.target   
    //     const nextInputs = {            
    //         //스프레드 문법으로 기존의 객체를 복사한다.
    //                  ...inputs,  
    //                  [name]: value,
    //              }
    //         //만든 변수를 seInput으로 변경해준다.
    //              setInputs(nextInputs)  

    //              console.log(inputs)
    //              if(name==="direct_title")
    //              {
    //                  console.log("닉네임유효성",nicknameEXP.test(e.target.value))
    //                  setNicknameCheck(nicknameEXP.test(e.target.value))
    //              }
    //             else if(name==="join_id")
    //              {
    //                 // console.log("아이디 유효성",idEXP.test(e.target.value))
    //                 // setIdCheck(idEXP.test(e.target.value))
    //              }
    //              else if(name==="join_password")
    //              {
    //                  console.log("비밀번호 유효성",passwordEXP.test(e.target.value))
    //                  setPasswordCheck(passwordEXP.test(e.target.value))

    //              }
    //              else if(name==="join_passwordconfirm")
    //              { console.log("비밀번호확인 유효성",join_password)
    //              //RegExp라는 형식이 따로있다.
    //                 // const passwordconfirmEXP =new RegExp(join_password)
    //                  console.log("비밀번호확인 유효성",join_password===e.target.value)
    //                  setPasswordconfirmCheck((join_password===e.target.value))
    //              }
    //              else if(name==="join_name")
    //              {
    //                  console.log("이름 유효성",nameEXP.test(e.target.value))
    //                  setNameCheck(nameEXP.test(e.target.value))

    //              }
    //              else if(name==="join_register1")
    //              {
    //                  console.log("주민번호1 유효성",register1EXP.test(e.target.value))
    //                  setResister1Check(register1EXP.test(e.target.value))

    //              }
    //              else if(name==="join_register2")
    //              {
    //                  console.log("주민번호2 유효성",register2EXP.test(e.target.value))
    //                  setResister2Check(register2EXP.test(e.target.value))

    //              }
    // }   
    //헌혈증카운트세는거
 
      
    const countClick = (text) => {

        if (text === "countdown" && directCount > 0) {
            setDirectCount(directCount - 1)

        }
        else if (text === "countup" && directCount < 10) {

            setDirectCount(directCount + 1)
        }

    }
    const getValue=(text)=>{
        setSido(text)
        

    }
    const getValue2=(text)=>{
        setSigungu(text)
       

    }
    return (

        <div className="Directed-write-container">
            <div className="Directed-write-nav-container">
                <div className="Directed-write-nav-class">
                    <Menu_left_nav name={"지정헌혈"} imgname={DIRECTEDIMG}></Menu_left_nav>
                </div>
                <div className="Directed-write-nav-goback">
                    <img className="Directed-write-goback-bntimg-class" onClick={() => props.addPage("지정헌혈")} src={GOBACKBTN}></img>
                </div>
            </div>
            <div className="Directed-write-content-container">
                <div className="Directed-write-content-class" >
                    <div className="Directed-write-card-class">
                        <div className="Dircected-write-card-total">
                            <div className="Directed-write-card-nav-class">
                                <input name="direct_title" className="Directed-write-card-title-class">
                                </input>
                                <div className="Directed-write-card-data-class">
                                    <DataPicker locale={ko} selected={startDate} minDate={new Date()} onChange={date => setStartDate(date)}></DataPicker> <div className="Directed-write-card-wow">~</div>
                                    <DataPicker locale={ko} selected={endDate} minDate={startDate} onChange={date => setendDate(date)}></DataPicker>
                                </div>
                            </div>

                            <div className="Directed-write-card-context-class">
                                <textarea name="direct_context" className="Directed-write-card-context-input"></textarea>
                            </div>
                            <div className="Directed-write-card-footer-class">

                            </div>
                        </div>
                    </div>
                    <div className="Directed-write-footer-container">
                        <div className="Directed-write-footer-upload-container">
                            <div className="Directed-write-footer-upload">
                                <S3Upload />
                            </div>
                        </div>
                        <div className="Directed-write-footer-givecount-container">
                            <div className="Directed-write-footer-givecount">
                                <img src={BLOODDROP} className="Directed-write-footer-givecountimg"></img>
                                <div className="Directed-write-footer-givecounttext">
                                    지정헌혈 받을 횟수
                                </div>
                                <div className="Directed-write-footer-count-container">
                                    <div className="Directed_countdown" onClick={() => countClick("countdown")}>
                                        -
                                    </div>
                                    <div className="Directed_count">
                                        {directCount}
                                    </div>
                                    <div className="Directed_countup" onClick={() => countClick("countup")}>
                                        +
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div className="Directed-write-footer-bloodtype-container">
                            <div className="Directed-write-footer-bloodtype-class">
                                <img src={BLOODDROP} className="Directed-write-footer-givecountimg"></img>
                                <div className="Directed-write-footer-bloodtypetext">
                                    지정헌혈 받을 혈액형
                                </div>
                                <input className="Directed-write-footer-bloodtypeinput" name="directed-bloodtype"></input>
                            </div>

                        </div>
                        <div className="Directed-write-footer-location-container">
                            <div className="Directed-write-footer-locatin-class">
                                <img src={LOCATIONIMG} className="Directed-write-footer-givecountimg"></img>
                                <div className="Directed-write-footer-locationtext">
                                    지정헌혈 받을 병원 위치
                                </div>
                                <div className="Directed-write-footer-locationselect">
                                    <Directed_write_select getValue={getValue} getValue2={getValue2}/>
                                    {console.log("get",getSido,"se",getSigungu)}
                                </div>
                            </div>
                        </div>
                        <div className="Directed-write-data-container">
                            <div className="Directed-write-data-class">
                                <div className="Directed-write-data-data1">
                                    지정헌혈 정보
                                </div>
                                <div className="Directed-write-data-data2">
                                    <div className="Directed-write-data-data2text">환자 성명:</div>
                                    <input className="direct-patientname"></input>
                                </div>
                                <div className="Directed-write-data-data2">
                                <div className="Directed-write-data-data2text">의료기관명:</div>
                                <input className="direct-hopitalname"></input>
                                </div>
                                <div className="Directed-write-data-data2">
                                <div className="Directed-write-data-data2text">병실호수:</div>
                                <input className="direct-roomnumber"></input>
                                </div>
                                <div className="Directed-write-data-data2">
                                <div className="Directed-write-data-data2text"> 연락처:</div>
                                <input className="direct-phonenumber"></input>
                                </div>
                            </div>
                        </div>
                        <div className="Directed-write-btn-container">
                            <div className="Directed-write-btn-class">
                                <Common_Button_IMG name={"작성완료"} imgname={WRITEWHITEIMG}></Common_Button_IMG>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>

    )
}

const mapStateToProps = (state) => {
    return {
        page: state.page

    }
}
const mapDispatchToProps = (dispatch) => {
    return {
        addPage: (text) => dispatch(addPage(text))
    }
}

export default connect(mapStateToProps, mapDispatchToProps)(Directed_write);
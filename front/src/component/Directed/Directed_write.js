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

const SelectBox = () => {
    return (
        <select>
            <option key="서울광역시" value="1">
                서울광역시
            </option>
            <option key="부산광역시" value="2">부산광역시</option>
            <option key="대구광역시" value="3">대구광역시</option>
            <option key="인천광역시" value="4">인천광역시</option>
            <option key="광주광역시" value="5">광주광역시</option>
            <option key="대전광역시" value="6">대전광역시</option>
            <option key="울산광역시" value="7">울산광역시</option>
            <option key="경기도" value="8">경기도</option>
            <option key="강원도" value="9">강원도</option>
            <option key="충청북도" value="10">충청북도</option>
            <option key="충청남도" value="11">충청남도</option>
            <option key="전라북도" value="12">전라북도</option>
            <option key="전라남도" value="13">전라남도</option>
            <option key="경상북도" value="14">경상북도</option>
            <option key="경상남도" value="15">경상남도</option>
            <option key="제주특별자치도" value="16">제주특별자치도</option>

        </select>
    );
};
const SelectBox2 = () => {
    return (
        <select>
            <option key="ing" value="ing">
                서울
            </option>
            <option key="end" value="end">경기도</option>
        </select>
    );
};


function Directed_write(props) {

    const [startDate, setStartDate] = useState(new Date());
    const [endDate, setendDate] = useState(new Date());
    //헌혈증받는변수
    const [directCount, setDirectCount] = useState(0);

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
    return (

        <div className="Directed-write-container">
            <div className="Directed-write-nav-container">
                <div className="Directed-write-nav-class">
                    <Menu_left_nav name={"지정헌혈"} imgname={DIRECTEDIMG}></Menu_left_nav>
                    {console.log()}
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
                                    <SelectBox></SelectBox>
                                </div>
                            </div>
                        </div>
                        <div className="Directed-write-data-container">
                            <div className="Directed-write-data-class">
                                <div className="Directed-write-data-data1">
                                    지정헌혈 정보
                                </div>
                                <div className="Directed-write-data-data2">
                                    환자 성명:<input className="direct-patientname"></input>
                                </div>
                                <div className="Directed-write-data-data2">
                                    의료기관명:<input className="direct-hopitalname"></input>
                                </div>
                                <div className="Directed-write-data-data2">
                                    병실호수:<input className="direct-roomnumber"></input>
                                </div>
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
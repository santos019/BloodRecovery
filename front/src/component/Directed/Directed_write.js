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





function Directed_write(props) {
    const [getState,setState]=useState("1");
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
    const handleChange=(e)=>{
        setState(e.target.value);
    
        
      }
      const SelectBox = () => {
        return (
            <select value={getState} onChange={handleChange}>
                <option key="서울특별시" value="1">서울특별시</option>
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
        
        if(getState==="1")//서울
        {return (
            <select>
                <option key="ing" value="ing">종로구</option>
                <option key="end" value="end">중구</option>
                <option key="ing" value="ing">용산구</option>
                <option key="end" value="end">성동구</option>
                <option key="ing" value="ing">광진구</option>
                <option key="end" value="end">동대문구</option>
                <option key="ing" value="ing">중랑구</option>
                <option key="end" value="end">성북구</option>
                <option key="ing" value="ing">강북구</option>
                <option key="end" value="end">도봉구</option>
                <option key="ing" value="ing">노원구</option>
                <option key="end" value="end">은평구</option>
                <option key="ing" value="ing">서대문구</option>
                <option key="end" value="end">마포구</option>
                <option key="ing" value="ing">양천구</option>
                <option key="end" value="end">강서구</option>
                <option key="ing" value="ing">구로구</option>
                <option key="end" value="end">금천구</option>
                <option key="ing" value="ing">영등포구</option>
                <option key="end" value="end">동작구</option>
                <option key="end" value="end">관악구</option>
                <option key="ing" value="ing">서초구</option>
                <option key="end" value="end">강남구</option>
                <option key="ing" value="ing">송파구</option>
                <option key="end" value="end">강동구</option>
            </select>
        );}
        else if(getState==="2")//부산
        {return (
            <select>
                <option key="ing" value="ing">중구</option>
                <option key="end" value="end">서구</option>
                <option key="ing" value="ing">동구</option>
                <option key="end" value="end">영도구</option>
                <option key="ing" value="ing">부산진구</option>
                <option key="end" value="end">동래구</option>
                <option key="ing" value="ing">남구</option>
                <option key="end" value="end">북구</option>
                <option key="ing" value="ing">강서구</option>
                <option key="end" value="end">해운대구</option>
                <option key="ing" value="ing">사하구</option>
                <option key="end" value="end">금정구</option>
                <option key="ing" value="ing">연제구</option>
                <option key="end" value="end">수영구</option>
                <option key="ing" value="ing">사상구</option>
            </select>
        );
        }
        else if(getState==="3")//대구
        {return (
            <select>
                <option key="ing" value="ing">중구</option>
                <option key="end" value="end">동구</option>
                <option key="ing" value="ing">서구</option>
                <option key="end" value="end">남구</option>
                <option key="ing" value="ing">북구</option>
                <option key="end" value="end">수성구</option>
                <option key="ing" value="ing">달서구</option>
                <option key="end" value="end">달성군</option>
            </select>
        );
        }
        else if(getState==="4")//인천
        {return (
            <select>
                <option key="ing" value="ing">중구</option>
                <option key="end" value="end">동구</option>
                <option key="ing" value="ing">미추홀구</option>
                <option key="end" value="end">연수구</option>
                <option key="ing" value="ing">남동구</option>
                <option key="end" value="end">부평구</option>
                <option key="ing" value="ing">계양구</option>
                <option key="end" value="end">서구</option>
                <option key="ing" value="ing">강화군</option>
                <option key="end" value="end">옹진군</option>
            </select>
        );
        }
        else if(getState==="5")//광주
        {return (
            <select>
                <option key="ing" value="ing">동구</option>
                <option key="end" value="end">서구</option>
                <option key="ing" value="ing">남구</option>
                <option key="end" value="end">북구</option>
                <option key="ing" value="ing">광산구</option>
            </select>
        );
        }
        else if(getState==="6")//대전광역시
        {return (
            <select>
                <option key="ing" value="ing">동구</option>
                <option key="end" value="end">중구</option>
                <option key="ing" value="ing">서구</option>
                <option key="end" value="end">유성구</option>
                <option key="ing" value="ing">대덕구</option>
            </select>
        );
        }
        else if(getState==="7")//울산
        {return (
            <select>
                 <option key="ing" value="ing">중구</option>
                <option key="end" value="end">남구</option>
                <option key="ing" value="ing">동구</option>
                <option key="end" value="end">북구</option>
                <option key="ing" value="ing">울주군</option>
            </select>
        );
        }
        else if(getState==="8")//경기도
        {return (
            <select>
                <option key="ing" value="ing">
                    부산
                </option>
                <option key="end" value="end">경기도</option>
            </select>
        );
        }
        else if(getState==="9")//강원도
        {return (
            <select>
                <option key="ing" value="ing">
                    부산
                </option>
                <option key="end" value="end">경기도</option>
            </select>
        );
        }
        else if(getState==="10")//충청북도
        {return (
            <select>
                <option key="ing" value="ing">
                    부산
                </option>
                <option key="end" value="end">경기도</option>
            </select>
        );
        }
        else if(getState==="11")//충청남도
        {return (
            <select>
                <option key="ing" value="ing">
                    부산
                </option>
                <option key="end" value="end">경기도</option>
            </select>
        );
        }
        else if(getState==="12")//전라북도
        {return (
            <select>
                <option key="ing" value="ing">
                    부산
                </option>
                <option key="end" value="end">경기도</option>
            </select>
        );
        }
        else if(getState==="13")//전라남도
        {return (
            <select>
                <option key="ing" value="ing">
                    부산
                </option>
                <option key="end" value="end">경기도</option>
            </select>
        );
        }
        else if(getState==="14")//경상북도
        {return (
            <select>
                <option key="ing" value="ing">
                    부산
                </option>
                <option key="end" value="end">경기도</option>
            </select>
        );
        }
        else if(getState==="15")//경상남도
        {return (
            <select>
                <option key="ing" value="ing">
                    부산
                </option>
                <option key="end" value="end">경기도</option>
            </select>
        );
        }
        else if(getState==="16")//제주특별자치도
        {return (
            <select>
                <option key="ing" value="ing">
                    부산
                </option>
                <option key="end" value="end">경기도</option>
            </select>
        );
        }
        

    };
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
                   {console.log("chenk",getState)}
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
                                    <SelectBox></SelectBox><SelectBox2></SelectBox2>
                                    {console.log()}
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
import React from "react";
import { withRouter } from "react-router";
import Menu_left_nav from '../Common/Header/Menu_left_nav';
import DIRECTEDIMG from '../../Img/DIRECTEDIMG.png';
import GOBACKBTN from '../../Img/DirectedIMG/arrow.png';
import Common_Button_IMG from "../Common/Button/Common_Button_IMG";
import DIRECTED_BUTTON_IMG from "../../Img/DirectedIMG/blood-donation.png";
import './Directed_inquire.css';
const Directed_inquire = (props) => {

    const sendValue = () => {
        props.getsetValue3()

    }



    return (


        <div className="Directed-inquire-container">
            <div className="Directed-inquire-nav-container">
                <div className="Directed-inquire-nav-class">
                    <Menu_left_nav name={"지정헌혈"} imgname={DIRECTEDIMG}></Menu_left_nav>
                </div>
                <div className="Directed-inquire-nav-goback">
                    <img className="Directed-inquire-goback-bntimg-class" onClick={sendValue} src={GOBACKBTN}></img>
                </div>
            </div>
            <div className="Directed-inquire-content-container">
                <div className="Directed-inquire-content-class" >
                    <div className="Directed-inquire-card-class">
                        <div className="Dircected-inquire-card-total">
                            <div className="Directed-inquire-card-nav-class">
                                <div className="Directed-inquire-card-title-class">
                                    1234567891012345678910123456789123456789123456123
                                </div>
                                <div className="Directed-inquire-card-data-class">
                                    2021.10.30 ~ 2021.10.31
                                </div>
                            </div>
                            <div className="Directed-inquire-card-info-class">
                                <div className="Directed-inquire-card-info-location">
                                    sss
                                </div>
                                <div className="Directed-inquire-card-info-location">
                                    sss
                                </div>
                                <div className="Directed-inquire-card-writer-container">
                                    <img src={GOBACKBTN} className="Directed-inquire-card-writer-icon"></img>
                                    <div className="Directed-inquire-card-writername-class">
                                        sss
                                    </div>
                                </div>
                            </div>
                            <div className="Directed-inquire-card-context-class">
                                대한적십자 연계

                                1. 헌혈증 기부
                                (마이페이지에서 사이트에 기부 / 헌혈 게시판에서 유저에게 기부)
                                - 전혈 (8주마다) : 200p
                                (마이페이지에서 사이트에 기부 / 헌혈 게시판에서 유저에게 기부)
                                - 전혈 (8주마다) : 200p
                            </div>
                            <div className="Directed-inquire-card-footer-class">
                                <div className="Directed-inquire-card-footer-status">
                                    000000000
                                </div>
                            </div>
                        </div>
                    </div>
                    <div className="Directed-inquire-footer-container">
                        <div className="Directed-inquire-footer-btn-container">
                            <div className="Directed-inquire-footer-btn-class">
                                <Common_Button_IMG name={"신청하기"} imgname={DIRECTED_BUTTON_IMG}></Common_Button_IMG>
                            </div>
                        </div>
                        <div className="Directed-inquire-footer-info1-class">
                            신청 하기를 누르면 요청자의 상세 정보를 열람할 수 있습니다.
                        </div>
                        <div className="Directed-inquire-footer-info2-class">
                            헌혈의 집을 이용한 지정 헌혈만 가능 합니다.
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )

}

export default Directed_inquire;
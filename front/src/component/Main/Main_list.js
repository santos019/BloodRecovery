import React, { useState } from 'react';
import Main_Button from '../Common/Button/Main_Button';
import './Main_list.css';

function Main_list() {
    return (
        <div className="Main_list_class">
            <div>
                <Main_Button name={"헌혈증 기부"} ></Main_Button>
            </div>
            <div>
                <Main_Button name={"지정헌혈"} ></Main_Button>
            </div>
            <div>
                <Main_Button name={"헌혈의 집 예약"} ></Main_Button>
            </div>

            <div>
                <Main_Button name={"공지사항"} ></Main_Button>
            </div>
        </div>
    )
    

}

export default Main_list;
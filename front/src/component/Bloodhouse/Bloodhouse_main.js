import React, { useState } from "react";
import Bloodhouse_nav from "./Bloodhouse_nav";
import ReactModal from "react-modal";
import Main_Button from "../Common/Button/Main_Button";
import UseLocalHook from "../Common/Function/UseLocalHook";
import ReactDatePicker from "react-datepicker";
import Bloodhouse_footer from "./Bloodhouse_footer";
import Calendar from "react-calendar";
import "./Bloodhouse_main.css";

function Bloodhouse_main() {
  const [date, setDate] = useState(new Date());

  const onDateChange = (date) => {
    console.log(date);
  };

  return (
    <div className="Bloodhouse_main_container">
      <div className="Bloodhouse_nav_container">
        <div className="Bloodhouse_nav_class">
          <Bloodhouse_nav></Bloodhouse_nav>
        </div>
      </div>
      <div className="Bloodhouse_content_container">
        <div className="Bloodhouse_content_class">
          <div className="Bloodhouse_content_where_container">
            <p className="Bloodhouse_content_text">헌혈의 집 선택</p>
            선택 컨포넌트 부분
          </div>
          <div className="Bloodhouse_content_when_container">
            <p className="Bloodhouse_content_text">예약 날짜 선택</p>
            <div className="Bloodhouse_content_calendar_class">
              <Calendar onChange={onDateChange} value={setDate} />
            </div>
            <div className="Bloodhouse_content_time_class">시간 부분</div>
          </div>
          <div className="Bloodhouse_content_bloodtype_container">
            <p className="Bloodhouse_content_text">헌혈 종류 선택</p>
            <div className="Bloodhouse_content_bloodtype_button_class">
              <button>전혈</button>
              <button>혈소판</button>
              <button>혈장</button>
              <button>혈소판혈장</button>
            </div>
          </div>
        </div>
      </div>
      <div className="Bloodhouse_footer_container">
        <div className="Bloodhouse_footer_class">
          <button className="Bloodhouse_footer_button_class">예약하기</button>
        </div>
      </div>
    </div>
  );
}

export default Bloodhouse_main;

import React from "react";
// import BoardIMG from '../../Img/BoardIMG.png';
import GOBACKBTN from "../../Img/DirectedIMG/arrow.png";
import Menu_left_nav from "../Common/Header/Menu_left_nav";
function Board_write(props) {
  const sendValue = () => {
    props.getsetValue3();
  };
  return (
    <div className="Board-inquire-container">
      <div className="Board-inquire-nav-container">
        <div className="Board-inquire-nav-class">
          <Menu_left_nav
            name={"헌혈증 기부"}
            // imgname={BoardIMG}
          ></Menu_left_nav>
          {console.log()}
        </div>
        <div className="Board-inquire-nav-goback">
          <img
            className="Board-inquire-goback-bntimg-class"
            onClick={sendValue}
            src={GOBACKBTN}
          ></img>
        </div>
      </div>
      <div className="Board-inquire-content-container">
        <div className="Board-inquire-content-class">
          <div className="Board-inquire-card-class">
            <div className="Board-inquire-card-total">
              <div className="Board-inquire-card-nav-class">
                <input className="Board-inquire-card-title-class"></input>
                <div className="Board-inquire-card-data-class"></div>
              </div>

              <div className="Board-inquire-card-context-class">0000000</div>
              <div className="Board-inquire-card-footer-class"></div>
            </div>
          </div>
          <div className="Board-inquire-footer-container"></div>
        </div>
      </div>
    </div>
  );
}
export default Board_write;

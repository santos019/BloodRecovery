import React, { useState,useEffect } from 'react';
import Menu_left_nav from '../Common/Header/Menu_left_nav';
import './Directed_main.css';
import DIRECTEDIMG from '../../Img/DIRECTEDIMG.png';
import SEARCHICON from '../../Img/searchicon.png';
import WRITEICON from '../../Img/WRITE.png';
import Directed_card from './Directed_card';
import axios from "axios";

const SelectBox = () => {
	return (
		<select>
			<option key="ing" value="ing">
				진행중
			</option>
			<option key="end" value="end">진행완료</option>
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


function Directed_main() {
    let form = new FormData();
    useEffect(() => {
        axios
          .get("http://localhost:8000/directed/")
          .then((response) => (console.log(response)));
        // .then(({ data }) => setRanks(data));
      }, []);
     
    
    
    
    
    return (
        <div className="Directed-main-container">
            <div className="Directed-main-nav-container">
                <div className="Directed-main-nav-class" >
                    <Menu_left_nav name={"지정헌혈"} imgname={DIRECTEDIMG}></Menu_left_nav>
                </div>
                <div className="Directed-main-nav-search-class">
                    <input type="text" name="search_Data" className="Directed-main-input">
                    </input>
                    <img src={SEARCHICON} className="Directed-main-nav-searchicon-class"></img>
                </div>
                <div className="Directed-main-nav-select-class">
                    <SelectBox></SelectBox>
                </div>
                <div className="Directed-main-nav-select2-class">
                    <SelectBox2></SelectBox2>
                </div>
                <div className="Directed-main-nav-write-class">
                <img src={WRITEICON} className="Directed-main-nav-writeicon-class"></img>
                </div>
            </div>
            <div  className="Directed-main-cardmain-container">
                <Directed_card></Directed_card>
            </div>
        </div>
    )
}

export default Directed_main;
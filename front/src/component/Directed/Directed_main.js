import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import Menu_left_nav from '../Common/Header/Menu_left_nav';
import './Directed_main.css';
import DIRECTEDIMG from '../../Img/DIRECTEDIMG.png';
import SEARCHICON from '../../Img/searchicon.png';
import WRITEICON from '../../Img/WRITE.png';
import Directed_card from './Directed_card';
import Directed_inquire from './Directed_inquire';

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


//0관리자 1
const Directed_main=(props)=>{
    var key1
    let form = new FormData();
    var arrNumber = new Array(); 
    const [getData, setGetdata] = useState([]);

    
    // const sendValue=(props)=>{
    //     props.getsetValue2("test")
    // }
    //props 개념에대해 다시 알아봐야할것같다... getsetValue2 인자에 props를 메인에서 props를 읽을수없다 
    const getsetValue2 = () => {
        console.log("지정헌혈")
        props.getsetValue2();
    
     
    }
    const getsetValue3 = () => {
        console.log("지정헌혈조회백")
        props.getsetValue3();
    
     
    }
    useEffect(() => {
        axios
            .get("http://ec2-18-219-208-124.us-east-2.compute.amazonaws.com:8000/direct")
        //     .data(
        //         {id: ,
        // requesterId: ,
        // requesterNickname: {},
        // requesterLevel: {},
        // title: {},
        // locationSido: {},
        // locationSigungu: {},
        // periodTo: {},
        // bloodType: {},
        // completeStatus:{},}
        //     )
            .then(function(response){
                
                setGetdata(response.data); 
                newdata();
                console.log("response",response)
            // if(response != 'undefined' && response != null) {
            //     setGetdata(response.data)
            //  }

            });
            //key1= getData[0];
            console.log("jet",key1)
            
            /*.then(response=>console.log(response))*/
            //console.log("get"+JSON.stringify(getData))
           
           // alert(JSON.stringify(getData.data));
        // .then(({ data }) => setRanks(data));
    }, []);
  
   
    const newdata = () => {
       for(var i=0; i<getData.length;i++)
       {
           
         
           for(var key in getData[i].length)
           {
               
            getData[i][i]=0;
               //data +=key + "="+ getData[i][key] + " ";
               //console.log("data"+data)
           }
       }
      // console.log(arrNumber)
    }



    return (

        <div className="Directed-main-container">
            <div className="Directed-main-nav-container">
                <div className="Directed-main-nav-class" >
                    <Menu_left_nav name={"지정헌혈"} imgname={DIRECTEDIMG}></Menu_left_nav>               
                    {console.log("ge",getData[0]?.id)}
                  
                </div>
                <div className="Directed-main-nav-search-class">
                    <input type="text" name="search_Data" className="Directed-main-input">
                    </input>
                    <div className="Directed-main-nav-searchicon-container">
                    <img src={SEARCHICON} className="Directed-main-nav-searchicon-class"></img>
                    </div>
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
            <div className="Directed-main-cardmain-container">
                {/* <Directed_card getData={getData}></Directed_card> */}
                {/* {getData.map((menu)=>(menu.requesterId))
                } */}
                {//워닝이뜨기떄문에 key값설정해야함
                    getData.map((menu,index)=>(<Directed_card getData={getData[index]} key={index} getsetValue={getsetValue2} >
                        {console.log("index",index)}
                    </Directed_card>))
                }
                {console.log(getData)}
                
            </div>
        </div>
    )
}

export default Directed_main;
import React, { useState, useEffect } from 'react';
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
const testcase=(response)=>{


}

//0관리자 1
function Directed_main() {
    var key1
    let form = new FormData();
    var arrNumber = new Array(); 
    const [getData, setGetdata] = useState([]);
    useEffect(() => {
        axios
            .get("http://ec2-18-188-48-137.us-east-2.compute.amazonaws.com:8000/directeds/")
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
                {
                    getData.map((menu,index)=>(<Directed_card getData={getData[index]}  >
                        {console.log("index",index)}
                    </Directed_card>))
                }
                {console.log(getData)}
                
            </div>
        </div>
    )
}

export default Directed_main;
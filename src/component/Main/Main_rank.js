import React, { useState } from 'react';
import Test_img1 from '../../test/Test_img1.jpg'
import './Main_rank.css'
import Main_rank_text from './Main_rank_text';


const Main_rank=(props)=>
{
    const sendValue=(text)=>{
        props.getsetValue(text);
    }
    return(
        
        <div className="Main-rank-class">
            <div className="Main-rank-img-container">
            <img className="Main-rank-img-imgclass" src={Test_img1}>
                
            </img>
            </div>
            <div className="Main-rank-text-container-class">
                <div className="Main-rank-text-class" onClick={()=>sendValue("랭킹")}>
            <Main_rank_text></Main_rank_text>
            </div>
            </div>
        </div>
    )

    
}

// const Main_rank=(props)=>
// {
//     const sendValue=()=>{
//         props.getsetValue("랭킹");
//     }
    
//     return(
//         <div className="Main_rank_img_class" onClick={sendValue}>
//             <img src={Test_img1}></img>
//             <Main_rank_text></Main_rank_text>
//         </div>
//     )

    
// }

export default Main_rank;
import React, { useState } from 'react';
import Test_img1 from '../../test/Test_img1.jpg'
import './Main_rank.css'
import Main_rank_text from './Main_rank_text';
function Main_rank()
{
    return(
        <div className="Main_rank_img_class">
            <img src={Test_img1}></img>
            <Main_rank_text></Main_rank_text>
        </div>
    )

    
}

export default Main_rank;
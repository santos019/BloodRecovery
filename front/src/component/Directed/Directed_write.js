import React from "react";
import DIRECTEDIMG from '../../Img/DIRECTEDIMG.png';
import GOBACKBTN from '../../Img/DirectedIMG/arrow.png';
import Menu_left_nav from '../Common/Header/Menu_left_nav';
import {connect} from 'react-redux'
import {addPage} from '../../component/Modalmove/subscribers/action'

function Directed_write(props) {

   
    return (

        <div className="Directed-inquire-container">
            <div className="Directed-inquire-nav-container">
                <div className="Directed-inquire-nav-class">
                    <Menu_left_nav name={"지정헌혈"} imgname={DIRECTEDIMG}></Menu_left_nav>
                    {console.log()}
                </div>
                <div className="Directed-inquire-nav-goback">
                    <img className="Directed-inquire-goback-bntimg-class" onClick={()=>props.addPage("지정헌혈")} src={GOBACKBTN}></img>
                </div>
            </div>
            <div className="Directed-inquire-content-container">
                <div className="Directed-inquire-content-class" >
                    <div className="Directed-inquire-card-class">
                        <div className="Dircected-inquire-card-total">
                            <div className="Directed-inquire-card-nav-class">
                                <input className="Directed-inquire-card-title-class">
                                  
                                </input>
                                <div className="Directed-inquire-card-data-class">
                                 
                                </div>
                            </div>
                          
                            <div className="Directed-inquire-card-context-class">
                              0000000
                            </div>
                            <div className="Directed-inquire-card-footer-class">
                              
                            </div>
                        </div>
                    </div>
                    <div className="Directed-inquire-footer-container">
                        
                        
                    </div>
                </div>
            </div>
        </div>
    )
}

const mapStateToProps=(state)=>{
    return{
        page:state.page
        
    }
}
const mapDispatchToProps=(dispatch)=>{
    return{
        addPage: (text)=>dispatch(addPage(text))
    }
}

export default connect(mapStateToProps,mapDispatchToProps)(Directed_write);
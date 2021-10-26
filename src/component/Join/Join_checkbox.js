import React from "react";
import "./Join_checkbox.css";
function Join_checkbox(){


    return(

        <div className="Join-checkbox-class">
            <input type="checkbox" className="Join-checkbox-input-class"  id="Join-checkbox-checkbox-id">
            </input>
            <label className="Join-checkbox-text-class" for="Join-checkbox-checkbox-id">동의합니다</label>
        </div>

    )
}

export default Join_checkbox;
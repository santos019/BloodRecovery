import React, { useState } from 'react';
import propTypes from 'prop-types';

const Menu_nav_text=({name})=>{



    return (
        <div className="Menu_nav_text">
            <h1>{name}</h1>
        </div>

    );
}
Menu_nav_text.defaultProps={
    name:'기본이름'
};

Menu_nav_text.propTypes={
    name: propTypes.string
};


export default Menu_nav_text;


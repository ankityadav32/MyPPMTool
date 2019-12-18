import React, { Component } from 'react';
import {Link} from 'react-router-dom'
const CreateProjectButton =()=> {
    
        return (
            <div>
              <Link to="/AddProject" className="btn btn-lg btn-info">
                        Create a Project
              </Link>  
            </div>
        );
        
    }


export default CreateProjectButton;
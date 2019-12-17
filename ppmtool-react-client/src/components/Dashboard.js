import React, { Component } from 'react';
import ProjectItem from './Project/ProjectItem';
import "bootstrap/dist/css/bootstrap.min.css"
class Dashboard extends Component {
    render() {
        return (
            <div className="alert alert-warning">
                Welcome To PPMTOOL
                <ProjectItem/>
                <ProjectItem/>
            </div>
        );
    }
}

export default Dashboard;
import React, { Component } from 'react';
import ProjectItem from './Project/ProjectItem';

class Dashboard extends Component {
    render() {
        return (
            <div>
                Welcome To PPMTOOL
                <ProjectItem/>
                <ProjectItem/>
            </div>
        );
    }
}

export default Dashboard;
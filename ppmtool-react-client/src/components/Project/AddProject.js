import React, { Component } from 'react';

import {connect} from 'react-redux'
import Proptypes from 'prop-types'
import {createProject} from '../../actions/projectActions'
import classnames from 'classnames'
class AddProject extends Component {
    constructor(){
        super();
        this.state={

            "projectName": "",
            "projectIdentifier": "",
            "description": "",
            "start_date": "",
            "end_date":"" ,  
            errors:{}          
        }
    }
componentWillReceiveProps(nextProps){
    if(nextProps.errors){
        this.setState({errors:nextProps.errors})
    }
}

    onChange = (e) =>{
        this.setState({[e.target.name]:e.target.value})
    }

    onSubmit = (e) =>{
        e.preventDefault();
        const newProject={
            "projectName": this.state.projectName,
            "projectIdentifier": this.state.projectIdentifier,
            "description": this.state.description,
            "start_date": this.state.start_date,
            "end_date": this.state.end_date
        }
        this.props.createProject(newProject,this.props.history)
    }
    render() {
        return (
            
    <div className="project">
        <div className="container">
            <div className="row">
                <div className="col-md-8 m-auto">
                    <h5 className="display-4 text-center">Create  Project form</h5>
                    <hr />
                    <form onSubmit={this.onSubmit}>
                        <div className="form-group">
                            <input type="text" className={classnames("form-control form-control-lg ",{
                                "is-invalid":this.state.errors.projectName 
                            })} placeholder="Project Name" name="projectName" value={this.state.projectName} onChange={this.onChange}/>
                            {this.state.errors.projectName && (
                                <div className='invalid-feedback'>{this.state.errors.projectName}</div>
                            )}
                        </div>
                        <div className="form-group">
                            <input type="text" className={classnames("form-control form-control-lg",{
                                'is-invalid':this.state.errors.projectIdentifier
                            })} placeholder="Unique Project ID" name="projectIdentifier" value={this.state.projectIdentifier} onChange={this.onChange}/>
                            {this.state.errors.projectIdentifier && (
                                <div className = 'invalid-feedback'>{this.state.errors.projectIdentifier}</div>
                            )}
                        </div>

                        
                        <div className="form-group">
                            <textarea className={classnames("form-control form-control-lg",{
                                'is-invalid':this.state.errors.description
                            })} placeholder="Project Description" name="description" value={this.state.description} onChange={this.onChange}></textarea>
                            {this.state.errors.description && (
                                <div className = 'invalid-feedback'>{this.state.errors.description}</div>
                            )}
                        </div>
                        <h6>Start Date</h6>
                        <div className="form-group">
                            <input type="date" className="form-control form-control-lg" name="start_date" value={this.state.start_date} onChange={this.onChange}/>
                        </div>
                        <h6>Estimated End Date</h6>
                        <div className="form-group">
                            <input type="date" className="form-control form-control-lg" name="end_date" value={this.state.end_date} onChange={this.onChange}/>
                        </div>

                        <input type="submit" className="btn btn-primary btn-block mt-4" />
                    </form>
                </div>
            </div>
        </div>
    </div>
           
        );
    }
}


AddProject.propTypes = {
    createProject : Proptypes.func.isRequired,
    errors : Proptypes.object.isRequired
};

const mapStateToProps = (state) =>{
   return {errors:state.errors}
}

export default connect (mapStateToProps,{createProject })(AddProject);


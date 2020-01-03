import {combineReducers} from 'redux'
import errorReducer from './errorReducer';
import projectreducers from './projectreducers';



export default combineReducers({
    errors:errorReducer,
    project:projectreducers
});
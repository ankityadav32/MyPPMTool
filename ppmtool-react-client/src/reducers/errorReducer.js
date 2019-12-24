import {GET_ERRORS} from '../actions/types';
import { returnStatement } from '../../node_modules/@babel/types';

const initialState  = {}

export default function(state = initialState,action){
    switch(action.type)
    {
        case GET_ERRORS:
        return action.payload;    

        default:
        return state;
    }
}
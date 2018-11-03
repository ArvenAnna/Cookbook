import React from 'react'
import ReactDOM from 'react-dom';
import {Provider} from 'react-redux';
import {HashRouter} from "react-router-dom";

import store from './Store.js';

ReactDOM.render(
        <Provider store={store}>
            <HashRouter>
                <div>This is react</div>
            </HashRouter>
        </Provider>,
    document.getElementById('mount')
)
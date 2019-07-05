import React from 'react';
import {BrowserRouter, Route} from 'react-router-dom';
import MainMenu from "./components/mainMenu";
import {Formular, Home, UploadImage} from "./scenes";

import {Container} from "react-bootstrap";


import './styles/App.css';
import "bootstrap/dist/css/bootstrap.min.css";
import { library } from '@fortawesome/fontawesome-svg-core';
import { faCheckSquare, fas } from '@fortawesome/free-solid-svg-icons';
library.add(fas, faCheckSquare,);


class App extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {
        return (
            <BrowserRouter>
                <Container fluid className="App main">
                    <MainMenu site_name="ECOCERT"/>
                    <Route exact path="/" component={ Home }/>
                    <Route exact path="/formular" component={ Formular }/>
                    <Route exact path="/uploadimage" component={ UploadImage }/>
                </Container>
            </BrowserRouter>
        );
    }
}
export default App;
